package foodnow.tests;

import com.foodnow.pages.AddProductPage;
import com.foodnow.pages.CartPage;
import com.foodnow.pages.LoginPage;
import com.foodnow.pages.OrderDetailsPage;
import foodnow.core.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class OderDetailsTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new LoginPage(app.driver).loginExistedUser();
        new AddProductPage(app.driver).addProduct();
        new CartPage(app.driver).checkoutToCart();
    }


    @Test
    public void formPayment() {
        logger.info("*** ORDER DETAILS TESTING IN PROGRESS ***");
        new OrderDetailsPage(app.driver)
                .enterAddress()
                .clickSubmitOrder();
    }

    @AfterMethod
    public void postConditions(Method method, ITestResult result) {
        if (result.isSuccess()) {
            logger.info("[OderDetailsTests] Test PASSED: " + method.getName());
        } else {
            logger.error("[OderDetailsTests] Test FAILED: " + method.getName() + ", Screenshot: " + app.getBaseHelper().takeScreenshot());
        }
    }
}
