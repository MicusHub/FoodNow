package com.foodnow.pages;

import com.foodnow.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddProductPage extends BaseHelper {

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//img[@class='css-rbpvgo'])[1]")
    WebElement mainProductPage;

    public AddProductPage clickFoodCategory() {
        click(mainProductPage);
        return this;
    }

    @FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root') and text()='Meat']")
    WebElement meatCategory;

    public AddProductPage clickMeatCategory() {
        click(meatCategory);
        return this;
    }

    private static final By ADD_STEAK_TO_CART_LOCATOR = By.xpath("//div[@aria-label='Add to cart' and @class='css-1urp7g4']//button");
// // @FindBy(xpath = "(//div[@class='MuiStack-root css-jj2ztu'])[2]")

    public AddProductPage clickAddSteakToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addSteakToCart = wait.until(ExpectedConditions.elementToBeClickable(ADD_STEAK_TO_CART_LOCATOR));
        click(addSteakToCart);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Rump Steak was added to cart')]")
    WebElement steakAddedToCart;

    public AddProductPage verifyProductIsAdded() {
        wait.until(ExpectedConditions.textToBePresentInElement(steakAddedToCart, "Rump Steak was added to cart"));
        return this;
    }


    public AddProductPage addProduct() {
        clickFoodCategory()
                .clickMeatCategory()
                .clickAddSteakToCart()
                .verifyProductIsAdded();
        return this;
    }
}
