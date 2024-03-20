package com.sdet.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.sdet.base.TestBase;

public class SignInPage extends TestBase{
	
	By clickOnSignInLink = By.xpath("//div[1]/ul[1]/li[2]/a[contains(text(),\"Sign In\")]");
	By emailTextBox  = By.cssSelector("#email");
	By passwd  = By.cssSelector("//input[@name=\"login[password]\"]");
	
	
	public static void main(String[] args) throws IOException {
		launchBrowser();
		navigateToURL();
	}
}
