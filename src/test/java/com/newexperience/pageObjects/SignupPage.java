package com.newexperience.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

    WebDriver supdriver;

    public SignupPage(WebDriver rdriver){
        supdriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(id = "customer_firstname")
    @CacheLookup
    WebElement txtCustomerFirstName;

    @FindBy(id = "customer_lastname")
    @CacheLookup
    WebElement txtCustomerLastName;

    @FindBy(id = "passwd")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(id = "firstname")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(id = "lastname")
    @CacheLookup
    WebElement txtLastName;

    @FindBy(id = "address1")
    @CacheLookup
    WebElement txtAddres;

    @FindBy(id = "city")
    @CacheLookup
    WebElement txtCity;

    @FindBy(id = "id_state")
    @CacheLookup
    WebElement cbxSelectState;

    @FindBy(id = "postcode")
    @CacheLookup
    WebElement txtPostCode;

    @FindBy(id = "id_country")
    @CacheLookup
    WebElement cbxSelectCountry;

    @FindBy(id = "phone_mobile")
    @CacheLookup
    WebElement txtPhoneMobile;

    @FindBy(id = "alias")
    @CacheLookup
    WebElement txtReference;

    @FindBy(id = "submitAccount")
    @CacheLookup
    WebElement btnSubmitAccount;

    public void setTxtCustomerFirstName(String customerFirstName) {
        txtCustomerFirstName.sendKeys(customerFirstName);
    }

    public void setTxtCustomerLastName(String customerLastName) {
        txtCustomerLastName.sendKeys(customerLastName);
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void setTxtFirstName(String firstname) {
        txtFirstName.sendKeys(firstname);
    }

    public void setTxtLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void setTxtAddres(String addres) {
        txtAddres.sendKeys(addres);
    }

    public void setTxtCity(String city) {
        txtCity.sendKeys(city);
    }

    public void clickCbxSelectState(String state) {
        Select selectState = new Select(cbxSelectState);
        selectState.selectByVisibleText(state);
    }

    public void setTxtPostCode(String postCode) {
        txtPostCode.sendKeys(postCode);
    }

    public void clickCbxSelectCountry(String country) {
        Select selectCountry = new Select(cbxSelectCountry);
        selectCountry.selectByVisibleText(country);
    }

    public void setTxtPhoneMobile(String phoneMobile) {
        txtPhoneMobile.sendKeys(phoneMobile);
    }

    public void setTxtReference(String reference) {
        txtReference.sendKeys(reference);
    }

    public void clickBtnSubmitAccount() {
        btnSubmitAccount.click();
    }
}
