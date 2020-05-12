package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_SigninLinkValidate extends BaseClass {

    @Test
    public void signinLinkValidate() throws InterruptedException {
        logger.info("URL is opened");

        HomePage hp = new HomePage(driver);

        hp.clickLnkSignin();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }
}