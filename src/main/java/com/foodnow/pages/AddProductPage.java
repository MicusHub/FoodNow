package com.foodnow.pages;

import com.foodnow.core.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProductPage extends BaseHelper {

    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root') and text()='Meat']")
    WebElement meatCategory;

    public AddProductPage clickMeatCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(meatCategory)); // явное ожидание
        click(meatCategory);
        return this;
    }

    @FindBy(xpath = "(//img[@class='css-rbpvgo'])[1]")
    WebElement mainProductPage;

    public AddProductPage clickFoodCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(mainProductPage));// явное ожидание
        click(mainProductPage);
        return this;
    }

    @FindBy(xpath = "(//div[@class='MuiStack-root css-jj2ztu'])[2]")
    WebElement addSteakToCart;

    public AddProductPage clickAddSteakToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addSteakToCart));// явное ожидание
        click(addSteakToCart);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(), 'Rump Steak was added to cart')]")
    WebElement steakAddedToCart;

    public AddProductPage verifyProductIsAdded() {
        wait.until(ExpectedConditions.visibilityOf(steakAddedToCart)); // явное ожидание
        shouldHaveText(steakAddedToCart, "Rump Steak was added to cart", 2000);
        return this;
    }

    public void addProduct() {
        new AddProductPage(driver)
                .clickFoodCategory()
                .clickMeatCategory()
                .clickAddSteakToCart()
                .verifyProductIsAdded();
    }

    public void addProduct1() {
        new AddProductPage(driver)
                .verifyProductIsAdded();
    }
}
