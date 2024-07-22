package com.sdet.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.base.TestBase;

public class CreateAccountPage extends TestBase {

	By createAccountLink = By.xpath("//header/div[1]/div/ul/li[3]/a");
	By firstName = By.cssSelector("#firstname");
	By lastName = By.cssSelector("#lastname");
	By email = By.cssSelector("#email_address");
	By pwd = By.xpath("//div[@class=\"control\"]/input[@id=\"password\"]");
	By cnfPassword = By.xpath("//input[@name=\"password_confirmation\"]");
	By createAccBtn = By.xpath("//button[@title=\"Create an Account\"]");
	By thankYouMsg = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

	public boolean clickOnCreateAccountLink() {

		driver.findElement(createAccountLink).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		boolean personalInfoPageVisible = false;

		try {
			personalInfoPageVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(createAccBtn))
					.isDisplayed();
		} catch (Exception ex) {
			ex.getStackTrace();
			return false;
		}

		return personalInfoPageVisible;
	}

	public boolean fillDetails(String firstname, String lastName1, String username, String password, String cnfPwd) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastName1);
		driver.findElement(email).sendKeys(username);
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(cnfPassword).sendKeys(cnfPwd);
		driver.findElement(createAccBtn).click();

		// Thread.sleep(10000);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMsg)).isDisplayed();
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		TestBase.launchBrowser();
		TestBase.navigateToURL();
		CreateAccountPage cp = new CreateAccountPage();
		System.out.println(cp.clickOnCreateAccountLink());
		//System.out.println(cp.fillDetails("test113f@example.com", "Test@123"));

	}

}