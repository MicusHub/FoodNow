package foodnow.tests;

import com.foodnow.pages.RegisterPage;
import com.foodnow.utils.DataProviders;
import foodnow.core.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.time.Duration;

public class RegisterNegativeTests extends TestBase {
    Logger logger = LoggerFactory.getLogger(RegisterNegativeTests.class);

    @BeforeMethod
    public void preCondition() {
        logger.info("[RegisterNegativeTests] Navigating to registration page");
        new RegisterPage(app.driver)
                .clickIconAuthorization()
                .clickRegistrButton();
    }

    @Test(dataProvider = "invalidRegistrationData", dataProviderClass = DataProviders.class)
    public void registerNegativeTest(String firstName, String lastName, String email, String password, String phone) {
        logger.info("[RegisterNegativeTests] Starting negative registration test with data: firstName={}, lastName={}, email={}, password={}, phone={}",
                firstName, lastName, email, password, phone);

        new RegisterPage(app.driver)
                .enterPersonalData(firstName, lastName, email, password, phone)
                .clickSubmitRegister();

        String expectedUrl = "https://oyster-app-hck73.ondigitalocean.app/#/registration";
        String actualUrl = app.driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert(); // Используем SoftAssert

        softAssert.assertEquals(actualUrl, expectedUrl,
                "[RegisterNegativeTests] Registration did not fail as expected. Expected URL: " + expectedUrl +
                        ", Actual URL: " + actualUrl + ", Screenshot: " + app.getBaseHelper().takeScreenshot());

        softAssert.assertAll(); // Проверяем все assertion в конце теста
    }


    @AfterMethod
    public void postCondition(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[RegisterNegativeTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[RegisterNegativeTests] Test FAILED: " + method.getName() + ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }
    }
}
