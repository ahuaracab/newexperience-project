package com.newexperience.testCases;

import com.newexperience.pageObjects.AccountPage;
import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.SigninPage;
import com.newexperience.pageObjects.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003_RegisterAccount extends BaseClass {

    @Test
    public void registerAccount() throws InterruptedException, IOException {

        logger.info("URL is opened");

        HomePage hp = new HomePage(driver);
        Thread.sleep(3000);
        hp.clickLnkSignin();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))){
            logger.info("test failed");
            captureScreen(driver,"registerAccount");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(3000);
        sip.setTxtEmailCreate("ahuaracab338@mailinator.com");
        sip.clickBtnCreateAccount();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"))){
            logger.info("test failed");
            captureScreen(driver,"registerAccount");
            Assert.assertTrue(false);
        }

        SignupPage sup = new SignupPage(driver);
        Thread.sleep(5000);
        sup.setTxtCustomerFirstName("Angelo");
        sup.setTxtCustomerLastName("Huaraca");
        sup.setTxtPassword("123456789");
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

        AccountPage ap = new AccountPage(driver);

        if (!(ap.getLnkAccountName().equals("Angelo Huaraca"))){
            logger.info("test failed");
            captureScreen(driver,"registerAccount");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}
