package com.sdet.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.base.TestBase;

public class SignInPage extends TestBase{
	
	static By clickOnSignInLink = By.xpath("//div[1]/ul[1]/li[2]/a[contains(text(),\"Sign In\")]");
	static By emailTextBox  = By.cssSelector("#email");
	static By passwd  = By.xpath("//input[@name=\"login[password]\"]");
	static By signInBtn = By.cssSelector("#send2");
	static By welcomeMsg = By.xpath("//span[text()=\"Welcome, Shubham Tange!\"]");
	public static  boolean sigin() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickOnSignInLink));
		driver.findElement(clickOnSignInLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailTextBox));
		driver.findElement(emailTextBox).sendKeys("shubhamtange999@gmail.com");
		driver.findElement(passwd).sendKeys("Shubham@123");
		driver.findElement(signInBtn).click();
		
		boolean welcomMsgDisplayed = false;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsg));
			welcomMsgDisplayed = true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return welcomMsgDisplayed;
	}
	
}