package com.newexperience.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SigninPage {
	
	WebDriver ldriver;

	public SigninPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "email_create")
	@CacheLookup
	WebElement txtEmailCreate;

	@FindBy(id = "SubmitCreate")
	@CacheLookup
	WebElement btnCreateAccount;

	@FindBy(id = "email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id = "passwd")
	@CacheLookup
	WebElement txtPasswd;

	@FindBy(id = "SubmitLogin")
	@CacheLookup
	WebElement btnSubmitLogin;

	@FindBy(css = ".lost_password>a")
	@CacheLookup
	WebElement lnkLostPassword;


	public void setTxtEmailCreate(String emailCreate) {
		txtEmailCreate.sendKeys(emailCreate);
	}

	public void clickBtnCreateAccount() {
		btnCreateAccount.click();
	}

	public void setTxtEmail(String email){
		txtEmail.sendKeys(email);
	}

	public void setTxtPasswd(String passwd){
		txtPasswd.sendKeys(passwd);
	}

	public void clickBtnSubmitLogin() {
		btnSubmitLogin.click();
	}

	public void clickLnkLostPassword() {
		lnkLostPassword.click();
	}
	
}
