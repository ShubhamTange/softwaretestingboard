package com.sdet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.base.TestBase;

public class AddToCartPage extends TestBase{
	
	By saleMenu = By.xpath("//span[text()=\"Sale\"]");
	By teesLink = By.xpath("//div[2]/div/div/ul[1]/li[3]/a");
	By material = By.xpath("//div[text()=\"Material\"]");
	By cottonMaterial = By.xpath("//div[@id=\"narrow-by-list\"]/div[5]/div[2]/ol/li[2]/a");
	By pattern = By.xpath("//div[text()=\"Pattern\"]");
	By solidPattern = By.xpath("//div[@id=\"narrow-by-list\"]/div[10]/div[2]/ol/li/a");
	By climateBtn = By.xpath("//div[text()=\"Climate\"]");
	By warmClimate = By.xpath("//div[@id=\"narrow-by-list\"]/div[10]/div[2]/ol/li[2]/a");
	
	By gabrialleTees = By.xpath("//div[4]/ol/li[4]");
	By sizeL = By.xpath("//div[@option-label=\"L\"]");
	By greenColor = By.xpath("//div[@option-label=\"Green\"]");
	By addToCart = By.xpath("//span[contains(text(),\"Add to Cart\")]");
	By successMsg = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/text()[1]");
	
	
	By showCartIcon = By.xpath("//a[@class=\"action showcart\"]");
	By viewEdit = By.xpath("//span[text()=\"View and Edit Cart\"]");
	
	By searchTextBox = By.cssSelector("#search");
	By waterBottle = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/div[2]/ol/li[1]/div/a/span/span/img");
	By reviews = By.cssSelector("#tab-label-reviews-title");
	By reviewComment = By.cssSelector(".review-content");
	By addToCartBtn = By.cssSelector("#product-addtocart-button");
	
	By proceedToCheckoutBtn = By.xpath("//button/span[text()=\"Proceed to Checkout\"]");
	By shippingAddress = By.xpath("//li[@id=\"shipping\"]/div[1]");
	
	
	public void addProduct() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(saleMenu).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(teesLink));
		driver.findElement(teesLink).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(material));
		System.out.println("Clicked material");
		driver.findElement(material).click();
		Thread.sleep(2000);
		System.out.println("Clicked Cotton material");
		driver.findElement(cottonMaterial).click();
		
		System.out.println("Clicked Pattern");
		driver.findElement(pattern).click();
		System.out.println("Clicked Solidpattern");	
		driver.findElement(solidPattern).click();
		
		Thread.sleep(2000);
		System.out.println("Clicked Climate");
		driver.findElement(climateBtn).click();
		System.out.println("Clicked warmClimate");
		driver.findElement(warmClimate).click();
		Thread.sleep(2000);
		
		
	}
	
	
	public void selectProduct() {
		driver.findElement(gabrialleTees).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(sizeL));
		driver.findElement(sizeL).click();
		driver.findElement(greenColor).click();
		driver.findElement(addToCart).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		
	}
	
	public void goToCart() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(showCartIcon).click();
		System.out.println("Clicked on showCartIcon");
		driver.findElement(viewEdit).click();
		
	}
	
	public String validateWaterBottleReview() {
		
		driver.findElement(searchTextBox).sendKeys("water bottle reviews");
		driver.findElement(searchTextBox).sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(waterBottle));
		driver.findElement(waterBottle).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(reviews));
		driver.findElement(reviews).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(reviewComment));
		String comments = driver.findElement(reviewComment).getText();
		System.out.println(comments);
		driver.findElement(addToCartBtn).click();
		
		return comments;
	}
	
	public boolean proceedToCheckOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn)).click();
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAddress)).isDisplayed();
		
	
	}
	
	
	public void addAddress() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		By fname = By.xpath("//input[@name=\"firstname\"]");
		By lname = By.xpath("//input[@name=\"lastname\"]");
		By streetAdd = By.xpath("//input[@name=\"street[0]\"]");
		
		By city =By.xpath("//input[@name=\"city\"]");
		By country = By.xpath("//select[@name=\"country_id\"]");
		By state = By.xpath("//select[@name=\"region_id\"]");
		By zipCode = By.xpath("//input[@name=\"postcode\"]");
		By phone = By.xpath("//input[@name=\"telephone\"]");
 		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(fname));
		System.out.println("First Name: "+driver.findElement(fname).getText());
		System.out.println("Last Name: "+driver.findElement(lname).getText());
		
		driver.findElement(streetAdd).sendKeys("N-9, 105/3, M2 Road, Aurangabad");
		driver.findElement(city).sendKeys("Aurangabad");
		
		Select countryList = new Select(driver.findElement(country));
		countryList.selectByVisibleText("India");
		
		Select stateList = new Select(driver.findElement(state));
		stateList.selectByVisibleText("Maharashtra");
	
		driver.findElement(zipCode).sendKeys("431001");
		driver.findElement(phone).sendKeys("1234567890");
		
	}
	
}
