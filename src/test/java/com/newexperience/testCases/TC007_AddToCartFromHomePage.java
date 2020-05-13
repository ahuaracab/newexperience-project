package com.newexperience.testCases;

import com.newexperience.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC007_AddToCartFromHomePage extends BaseClass {

    @Test
    public void addToCartFromHomePage() throws InterruptedException, IOException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(5000);
        hp.addAllPopularProductToCart();

        if (hp.getTxtQuantityProductInCart()!=hp.getCountPopularProduct()){
            logger.info("test failed");
            captureScreen(driver,"addToCartFromHomePage");
            Assert.assertTrue(false);
        }

        logger.info("test passed");
        Assert.assertTrue(true);
    }
}
