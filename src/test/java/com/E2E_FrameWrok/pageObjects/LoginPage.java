package com.E2E_FrameWrok.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver rDriver){
		
		driver= rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(id ="username")
	WebElement username;
	
	@FindBy(id ="password")
	WebElement password;
	
	@FindBy(id ="submit")
	WebElement submit;
	
	public void setUsername(String username) {
				this.username.sendKeys(username);
			}
	
	public void setPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickSubmit() {
		submit.click();
	}
		
}
