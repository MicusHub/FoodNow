package foodnow.tests;

import com.foodnow.pages.CartPage;
import com.foodnow.pages.LoginPage;
import foodnow.core.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new LoginPage(app.driver)
                .clickIconAuthorization()
                .clickLoginButton()
                .enterPersonalData("fgg@jhfsd.com", "Asd123Lkj@") // Валидные данные
                .clickSubmitLogin();

        new CartPage(app.driver).addProductToCart();
        // .verifyProductIsAdded();  // Если нужно, раскомментируйте и добавьте метод в CartPage
    }

    @Test
    public void proceedToCheckout() {
        checkoutToCart();
    }

    private void checkoutToCart() {
        new CartPage(app.driver)
                .clickIconCart()
                .clickPlusButton() // Убедитесь, что этот метод существует в CartPage
                .proceedToCheckout(); // Убедитесь, что этот метод существует в CartPage
    }
}
