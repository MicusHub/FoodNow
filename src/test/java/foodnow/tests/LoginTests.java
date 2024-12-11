package foodnow.tests;

import com.foodnow.pages.LoginPage;
import com.foodnow.utils.DataProviders;
import foodnow.core.TestBase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        logger.info("*** LOGIN TESTING IN PROGRESS ***");
    }

    @Test
    public void loginPositiveTest() {
        logger.info("*** LOGIN POSITIVE TESTING IN PROGRESS ***");
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData("fgg@jhfsd.com", "Asd123Lkj@")
                .clickSubmitLogin()
                .verifyUserIsLoggedIn();
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataProviders.class)
    public void loginNegativeTestWithAssert(String email, String password) {
        logger.info("[LoginTests] Starting negative login test with data: email={}, password={}", email, password);
        String loginUrl = "https://oyster-app-hck73.ondigitalocean.app/#/login"; //  URL страницы логина
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData(email, password)
                .clickSubmitLogin();

        String actualUrl = app.driver.getCurrentUrl();

        if (!actualUrl.equals(loginUrl)) {  // Проверка, что URL не изменился
            logger.error("[LoginTests] Test FAILED: Unexpected URL after login with invalid data: " + actualUrl + ", Screenshot: " + app.getBaseHelper().takeScreenshot());
            Assert.fail("Unexpected URL after login with invalid data: " + actualUrl);
        } else {
            logger.info("[LoginTests] Invalid login attempt successfuly prevented.");
        }

    }

    @AfterMethod
    public void postConditions(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[LoginTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[LoginTests] Test FAILED: " + method.getName() + ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }

        if (result.isSuccess() && method.getName().equals("loginPositiveTest")) {
            new LoginPage(app.driver).logout();
        }
    }
}

