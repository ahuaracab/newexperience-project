package com.newexperience.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoveredPasswordPage {

    WebDriver ldriver;

    public RecoveredPasswordPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(css = "p>button")
    @CacheLookup
    WebElement btnSubmitEmail;

    @FindBy(css = ".box>p")
    @CacheLookup
    WebElement txtEmailAlert;

    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void clickBtnSubmitEmail(){
        btnSubmitEmail.click();
    }

    public String getTxtEmailAlert(){
        return txtEmailAlert.getText();
    }

}
