package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.OrderPage;
import com.newexperience.pageObjects.SigninPage;
import com.newexperience.pageObjects.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC010_PayOnlineWithRegister extends BaseClass{
    @Test
    public void payOnlineWithoutLogin() throws InterruptedException {


        HomePage hp = new HomePage(driver);
        hp.addAnPopularProductToCart();
        Thread.sleep(3000);
        hp.clickBtnProccedToCheckout();
        Thread.sleep(5000);

        OrderPage op = new OrderPage(driver);
        op.clickBtnProceedToCheckoutOrder();

        Thread.sleep(3000);

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(3000);
        sip.setTxtEmailCreate("ahuaracab12345@mailinator.com");
        sip.clickBtnCreateAccount();
        Thread.sleep(5000);

        SignupPage sup = new SignupPage(driver);
        Thread.sleep(3000);
        sup.clickGender("Mr");
        sup.setTxtCustomerFirstName("Angelo");
        sup.setTxtCustomerLastName("Huaraca");
        sup.setTxtPassword("123465789");
        sup.setTxtFirstName("Angelo");
        sup.setTxtLastName("Huaraca");
        sup.setTxtAddres("Los Rosales");
        sup.setTxtCity("Lima");
        sup.clickCbxSelectState("Delaware");
        sup.setTxtPostCode("13057");
        sup.clickCbxSelectCountry("United States");
        sup.setTxtPhoneMobile("987654321");
        sup.setTxtReference("Las Torres");
        sup.clickBtnSubmitAccount();

        Thread.sleep(5000);

        op.clickBtnProceesAddress();
        Thread.sleep(3000);
        op.clickChbxTermsOfService();
        op.clickBtnProceesCarrier();
        Thread.sleep(3000);
        op.clickPayMethod("bankwire");
        op.clickBtnConfirmOrder();
        Thread.sleep(5000);

        Assert.assertEquals(op.getTxtOrderComplete(),"Your order on My Store is complete.");


    }
}
