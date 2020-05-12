package com.newexperience.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    WebDriver ldriver;

    public OrderPage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(css = ".cart_navigation>.button")
    @CacheLookup
    WebElement btnProceedToCheckoutOrder;

    @FindBy(name = "processAddress")
    @CacheLookup
    WebElement btnProceesAddress;

    @FindBy(name = "cgv")
    @CacheLookup
    WebElement chbxTermsOfService;

    @FindBy(name = "processCarrier")
    @CacheLookup
    WebElement btnProceesCarrier;

    @FindBy(className = "bankwire")
    @CacheLookup
    WebElement lnkBankwire;

    @FindBy(className = "cheque")
    @CacheLookup
    WebElement lnkCheque;

    @FindBy(css = "#cart_navigation>button")
    @CacheLookup
    WebElement btnConfirmOrder;

    @FindBy(className = "cheque-indent")
    @CacheLookup
    WebElement txtOrderComplete;

    public void clickBtnProceedToCheckoutOrder(){
        btnProceedToCheckoutOrder.click();
    }

    public void clickBtnProceesAddress(){
        btnProceesAddress.click();
    }

    public void clickChbxTermsOfService(){
        chbxTermsOfService.click();
    }

    public void clickBtnProceesCarrier(){
        btnProceesCarrier.click();
    }

    public void clickPayMethod(String payMethod){
        if (payMethod.equals("bankwire"))
            lnkBankwire.click();
        else
            lnkCheque.click();
    }

    public void clickBtnConfirmOrder(){
        btnConfirmOrder.click();
    }

    public String getTxtOrderComplete(){
        return txtOrderComplete.getText();
    }
}
