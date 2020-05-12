package com.newexperience.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver ldriver;

    public HomePage(WebDriver rdriver) {
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(className = "header_user_info")
    @CacheLookup
    WebElement lnkSignin;

    @FindBy(css = ".header_user_info>.account")
    @CacheLookup
    WebElement lnkAccountName;

    @FindBy(id = "contact-link")
    @CacheLookup
    WebElement lnkContactUs;

    @FindBy(css = "#homefeatured a[data-id-product]>span" )
    @CacheLookup
    List<WebElement> lstBtnCartPopularProducts;

    @FindBy(className = "cross" )
    @CacheLookup
    WebElement btnClose;

    @FindBy(css = "a>.ajax_cart_quantity" )
    @CacheLookup
    WebElement txtQuantityProductInCart;

    @FindBy(css = ".button-container>a" )
    @CacheLookup
    WebElement btnProccedToCheckout;


    public void clickLnkSignin(){
        lnkSignin.click();
    }

    public String getLnkAccountName(){
        return lnkAccountName.getText();
    }

    public void clickLnkContactUs(){
        lnkContactUs.click();
    }

    public int getCountPopularProduct(){
        return lstBtnCartPopularProducts.size();
    }

    public void addAllPopularProductToCart() throws InterruptedException {
        int size = getCountPopularProduct();
        for (int i = 0; i <size ; i++) {
            JavascriptExecutor executor = (JavascriptExecutor)ldriver;
            executor.executeScript("arguments[0].click();", lstBtnCartPopularProducts.get(i));
            Thread.sleep(3000);
            btnClose.click();
        }
    }

    public int getTxtQuantityProductInCart(){
        return Integer.parseInt(txtQuantityProductInCart.getText());
    }

    public void addAnPopularProductToCart() throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor)ldriver;
        executor.executeScript("arguments[0].click();", lstBtnCartPopularProducts.get(0));
    }

    public void clickBtnProccedToCheckout(){
        btnProccedToCheckout.click();
    }






}
