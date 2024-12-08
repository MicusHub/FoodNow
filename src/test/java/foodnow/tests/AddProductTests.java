package foodnow.tests;

import com.foodnow.pages.AddProductPage;
import com.foodnow.pages.LoginPage;
import foodnow.core.TestBase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class AddProductTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData("addproduct@gmail.com", "addproduct@gmail.com")
                .clickSubmitLogin();
    }

    @Test
    public void addProductPositiveTest() {
        addProduct();
    }

    private void addProduct() {
        new AddProductPage(app.driver)
                .clickFoodCategory()
                .clickMeatCategory()
                .clickAddSteakToCart()
                .verifyProductIsAdded();
    }

    @AfterMethod
    public void stopTest(Method method, ITestResult result){
        if (result.isSuccess()){
            getLogger().info("Test is PASSED: [" + method.getName() + "]");
        } else {
            getLogger().info("Test is FAILED: [" + method.getName() + "], Screenscot: [" + app.getBaseHelper().takeScreenshot() + "]");
        }
    }
}
