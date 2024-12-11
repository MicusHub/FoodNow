package foodnow.tests;

import com.foodnow.pages.RegisterPage;
import com.foodnow.utils.DataProviders;
import foodnow.core.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class RegisterPositiveTests extends TestBase {
    Logger logger = LoggerFactory.getLogger(RegisterPositiveTests.class);

    @BeforeMethod
    public void preCondition() {
        logger.info("[RegisterPositiveTests] Navigating to registration page");
        new RegisterPage(app.driver)
                .clickIconAuthorization()
                .clickRegistrButton();
    }

    @Test(dataProvider = "validRegistrationData", dataProviderClass = DataProviders.class)
    public void registerPositiveTest(String firstName, String lastName, String email, String password, String phone) {
        logger.info("[RegisterPositiveTests] Starting positive registration test with data: firstName={}, lastName={}, email={}, password={}, phone={}",
                firstName, lastName, email, password, phone);

        new RegisterPage(app.driver)
                .enterPersonalData(firstName, lastName, email, password, phone)
                .clickSubmitRegister();

        String expectedUrl = "https://oyster-app-hck73.ondigitalocean.app/#/login";
        String actualUrl = app.driver.getCurrentUrl();

        if (!actualUrl.equals(expectedUrl)) {
            logger.error("[RegisterPositiveTests] Registration failed. Expected URL: {}, Actual URL: {}, Screenshot: {}", expectedUrl, actualUrl, app.getBaseHelper().takeScreenshot());
        } else {
            logger.info("[RegisterPositiveTests] Registration successful.  User redirected to login page.");
        }
    }

    @AfterMethod
    public void postCondition(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[RegisterPositiveTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[RegisterPositiveTests] Test FAILED: " + method.getName() + ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }
    }
}
