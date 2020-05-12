package com.newexperience.testCases;

import com.newexperience.pageObjects.AccountPage;
import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004_Login extends BaseClass {

    @Test
    public void login() throws InterruptedException {
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

        Thread.sleep(5000);

        AccountPage ap = new AccountPage(driver);
        Thread.sleep(3000);
        Assert.assertEquals(ap.getLnkAccountName(), "Angelo Huaraca");
    }
}
