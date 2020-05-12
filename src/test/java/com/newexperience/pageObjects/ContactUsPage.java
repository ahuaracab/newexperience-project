package com.newexperience.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    WebDriver ldriver;

    public ContactUsPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "id_contact")
    @CacheLookup
    WebElement cbxSelectContact;

    @FindBy(id = "email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "message")
    @CacheLookup
    WebElement txtMessage;

    @FindBy(id = "submitMessage")
    @CacheLookup
    WebElement btnSubmitMessage;

    @FindBy(css = ".center_column>p")
    @CacheLookup
    WebElement txtContactAlert;


    public void clickCbxSelectState(String contact) {
        Select selectContact = new Select(cbxSelectContact);
        selectContact.selectByVisibleText(contact);
    }

    public void setTxtEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTxtMessage(String message) {
        txtMessage.sendKeys(message);
    }

    public void clickBtnSubmitMessage() {
        btnSubmitMessage.click();
    }

    public String getTxtContactAlert(){
        return txtContactAlert.getText();
    }
}
