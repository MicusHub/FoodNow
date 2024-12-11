package com.foodnow.pages;

import com.foodnow.core.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends BaseHelper {
    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "address-id")
    WebElement address;
    public OrderDetailsPage enterAddress() {
        type(address, "Plstrasse 71, 12943 Berlin");
        return this;
    }


    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitOrder;
    public OrderDetailsPage clickSubmitOrder() {
        click(submitOrder);
        return this;
    }
}
