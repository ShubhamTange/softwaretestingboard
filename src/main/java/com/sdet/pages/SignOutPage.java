package com.sdet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.base.TestBase;

public class SignOutPage extends TestBase{

	By clickArrow = By.xpath("//header/div[1]/div/ul/li[2]/span/button");
	By signoutOpt = By.xpath("//header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
	By signOutMsg = By.xpath("//span[text()=\"You are signed out\"]");
	
	public boolean clickSignout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickArrow)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(signoutOpt)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(signOutMsg));
		captureScreenshots("signoutmsg");
		return driver.findElement(signOutMsg).isDisplayed();

	}
	
}
