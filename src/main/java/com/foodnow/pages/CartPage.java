package com.foodnow.pages;

import com.foodnow.core.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BaseHelper {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "(//img[@class='css-13s0wde'])[2]")
    WebElement cartIcon;
    public CartPage clickIconCart() {
        //js.executeScript("window. scrollTo( 0,  0)");
        //wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        click(cartIcon);
        return this;
    }


    //@FindBy(xpath = "(//button[contains(@class,'MuiButton-root')])[2]")
    @FindBy(xpath = "//button[normalize-space(text())='+']")
    WebElement plusButton;
    public CartPage clickPlusButton() {
        //wait.until(ExpectedConditions.elementToBeClickable(plusButton));
        click(plusButton);
        return this;
    }

    //@FindBy(xpath = "(//div[@class='css-1361dhl']//div)[2]")
    @FindBy(xpath = "//button[normalize-space(text())='Proceed to checkout']")
    WebElement checkout;
    public CartPage proceedToCheckout() {
        //wait.until(ExpectedConditions.elementToBeClickable(checkout));
        click(checkout);
        return this;
    }

    public void addProductToCart() {
        new AddProductPage(driver)
                .clickFoodCategory()
                .clickMeatCategory()
                .clickAddSteakToCart();
    }

    public void checkoutToCart() {
        new CartPage(driver)
                .clickIconCart()
                .clickPlusButton()
                .proceedToCheckout();
    }
}
