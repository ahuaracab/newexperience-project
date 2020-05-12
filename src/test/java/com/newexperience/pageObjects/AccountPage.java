package com.newexperience.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver ldriver;

    public AccountPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(className = "header_user_info")
    @CacheLookup
    WebElement lnkSignin;

    @FindBy(css = ".header_user_info>.account")
    @CacheLookup
    WebElement lnkAccountName;

    public String getLnkAccountName(){
        return lnkAccountName.getText();
    }
}
