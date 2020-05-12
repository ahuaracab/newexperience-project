package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.OrderPage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC009_PayOnlineWithLogin extends BaseClass{
    @Test
    public void payOnlineWithoutLogin() throws InterruptedException {

        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.clickLnkSignin();
        Thread.sleep(5000);
        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))) {
            logger.info("NO SE REDIRECCIONO A LA PAGINA DE SIGNIN");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(5000);
        sip.setTxtEmail("ahuaracab123@mailinator.com");
        sip.setTxtPasswd("123465789");
        sip.clickBtnSubmitLogin();

        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(5000);

        hp.addAnPopularProductToCart();
        Thread.sleep(3000);
        hp.clickBtnProccedToCheckout();
        Thread.sleep(5000);

        OrderPage op = new OrderPage(driver);
        op.clickBtnProceedToCheckoutOrder();
        Thread.sleep(3000);
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
