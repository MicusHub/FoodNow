package foodnow.tests;

import com.foodnow.pages.CartPage;
import com.foodnow.pages.LoginPage;
import foodnow.core.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class CartTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new LoginPage(app.driver).loginExistedUser();
        new CartPage(app.driver).addProductToCart();
    }


    @Test
    public void tproceedToCheckou() {
        logger.info("*** CART TESTING IN PROGRESS ***");
        new CartPage(app.driver).checkoutToCart();
    }

    @AfterMethod
    public void postConditions(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[CartTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[CartTests] Test FAILED: " + method.getName() + ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }
    }
}
