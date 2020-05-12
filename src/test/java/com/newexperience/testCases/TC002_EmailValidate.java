package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.SigninPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_EmailValidate extends BaseClass {

    @Test
    public void emailValidate() throws InterruptedException {

        logger.info("URL is opened");

        HomePage hp = new HomePage(driver);
        hp.clickLnkSignin();
        Thread.sleep(5000);
        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))) {
            Assert.assertTrue(false);
        }

        SigninPage sp = new SigninPage(driver);
        sp.setTxtEmailCreate("ahuaracab12@mailinator.com");
        sp.clickBtnCreateAccount();
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");

    }
}
