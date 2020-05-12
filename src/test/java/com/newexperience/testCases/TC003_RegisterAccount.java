package com.newexperience.testCases;

import com.newexperience.pageObjects.AccountPage;
import com.newexperience.pageObjects.HomePage;
import com.newexperience.pageObjects.SigninPage;
import com.newexperience.pageObjects.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_RegisterAccount extends BaseClass {

    @Test
    public void registerAccount() throws InterruptedException {

        logger.info("URL is opened");

        HomePage hp = new HomePage(driver);
        Thread.sleep(3000);
        hp.clickLnkSignin();
        Thread.sleep(5000);
        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account"))) {
            logger.info("NO SE REDIRECCIONO A LA PAGINA DE SIGNIN");
            Assert.assertTrue(false);
        }

        SigninPage sip = new SigninPage(driver);
        Thread.sleep(3000);
        sip.setTxtEmailCreate("ahuaracab123@mailinator.com");
        sip.clickBtnCreateAccount();
        Thread.sleep(5000);

        if (!(driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"))) {
            logger.info("NO SE REDIRECCIONO A LA PAGINA DE REGISTRO");
            Assert.assertTrue(false);
        }

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

        AccountPage ap = new AccountPage(driver);
        Assert.assertEquals(ap.getLnkAccountName(), "Angelo Huaraca");
    }
}
