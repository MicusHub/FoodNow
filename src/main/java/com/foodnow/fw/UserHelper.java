package com.foodnow.fw;

import com.foodnow.core.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }
//
//    public void login(String email, String password) {
//        click(By.xpath("//a[.='LOGIN']"));
//        type(By.name("email"), email.toLowerCase());
//        type(By.name("password"), password);
//        click(By.name("login"));
//        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
//    }
//
//    public void register(String email, String password) {
//        click(By.xpath("//a[.='LOGIN']"));
//        type(By.name("email"), email);
//        type(By.name("password"), password);
//        click(By.name("registration"));
//        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
//    }
//
//    public void logout() {
//        click(By.xpath("//button[.='Sign Out']"));
//    }
//
//    public void fillInRegistrationForm(User user) {
//        type(By.name("email"), user.getEmail());
//        type(By.name("password"), user.getPassword());
//    }
//
//    public void clickRegistrationButton() {
//        click(By.name("registration"));
//    }
//
//    public void clickLoginLink() {
//        click(By.xpath("//a[.='LOGIN']"));
//    }
//
//    public boolean isSignOutButtonPresent() {
//        return isElementPresent(By.xpath("//button[.='Sign Out']"));
//    }
//
//    public void clickOnLoginButton() {
//        click(By.name("login"));
//    }
//
//    public boolean isError409Present() {
//        return isElementPresent(By.xpath("//div[.='Registration failed with code 409']"));
//    }
//
//    public boolean isLoginLinkPresent() {
//        return    isElementPresent(By.xpath("//a[.='LOGIN']"));
//    }
}
