package com.sdet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.base.TestBase;

public class myOrder extends TestBase{
	
	By clickDrop = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button");
	By myAccount = By.xpath("//div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a");
	By myOrders = By.xpath("//a[text()=\"My Orders\"]");
	By viewOrders = By.xpath("//span[text()=\"View Order\"]");
	By orderDetails = By.xpath("//h1/span[contains(text(),'Order')]");
	
	
	public boolean goToMyAccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(clickDrop).click();
		driver.findElement(myAccount).click();
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(myOrders)).isDisplayed();
		
	}
	
	
	public boolean goToMyOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(myOrders).click();
		driver.findElement(viewOrders).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails));
		
		String getOrderId = driver.findElement(orderDetails).getText();
		System.out.println(getOrderId);
		return driver.findElement(orderDetails).isDisplayed();
	}
	

}
