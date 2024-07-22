package com.sdet.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdet.base.TestBase;

public class AddToCartPage extends TestBase{
	
	By saleMenu = By.xpath("//span[text()=\"Sale\"]");
	By teesLink = By.xpath("//div[2]/div/div/ul[1]/li[3]/a");
	By material = By.xpath("//div[text()=\"Material\"]");
	By cottonMaterial = By.xpath("//div[@id=\"narrow-by-list\"]/div[7]/div[2]/ol/li[2]/a");
	
	By pattern = By.xpath("//div[text()=\"Pattern\"]");
	//By solidPattern = By.xpath("//div[@id=\"narrow-by-list\"]/div[10]/div[2]/ol/li/a");
	By solidPattern = By.xpath("//a[contains(text(), \"Solid\")]");
	By climateBtn = By.xpath("//div[text()=\"Climate\"]");
	//By warmClimate = By.xpath("//div[@id=\"narrow-by-list\"]/div[10]/div[2]/ol/li[2]/a");
	By warmClimate = By.xpath("//div[text()=\"Climate\"]");
	
	By gabrialleTees = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]");
	By sizeL = By.xpath("//div[@option-label=\"L\"]");
	By greenColor = By.xpath("//div[@option-label=\"Green\"]");
	By addToCart = By.xpath("//span[contains(text(),\"Add to Cart\")]");
	By successMsg = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/text()[1]");
	
	
	By showCartIcon = By.xpath("//a[@class=\"action showcart\"]");
	By viewEdit = By.xpath("//span[text()=\"View and Edit Cart\"]");
	
	By searchTextBox = By.cssSelector("#search");
	By waterBottle = By.xpath("//img[@alt=\"Affirm Water Bottle \"]");
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
	
	public void selectProduct() throws InterruptedException {
		driver.findElement(gabrialleTees).click();
		Thread.sleep(2000);
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtn)).click();
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAddress)).isDisplayed();
		
	
	}
	
	public boolean selectShippingMethod() {
		
		By flatRate = By.xpath("//input[@name=\"ko_unique_1\"]");
		By tableRate = By.xpath("//input[@name=\"ko_unique_2\"]");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(flatRate));
		String[] shippingMehothods = {"flatRate", "tableRate" };
		
		Random randomMethod = new Random();
		int randomIndex = randomMethod.nextInt(shippingMehothods.length-1);
		
		String methodName = shippingMehothods[randomIndex];
		System.out.println(methodName);
		if(methodName.equals("flatRate")) {
			driver.findElement(flatRate).click();
		}
		else if(methodName.equals("tableRate")) {
			driver.findElement(tableRate).click();
		}
		
		if(methodName.equals("flatRate")) {
			return driver.findElement(flatRate).isSelected();
		}
		else if(methodName.equals("tableRate")) {
			return driver.findElement(tableRate).isSelected();
		}
		
		return false;
	}
	
	public void addAddress() throws InterruptedException {
		
		By newAddressBtn = By.xpath("//button/span[text()=\"New Address\"]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		By fname = By.xpath("//input[@name=\"firstname\"]");
		By lname = By.xpath("//input[@name=\"lastname\"]");
		By streetAdd = By.xpath("//input[@name=\"street[0]\"]");
		
		By city =By.xpath("//input[@name=\"city\"]");
		By country = By.xpath("//select[@name=\"country_id\"]");
		By state = By.xpath("//select[@name=\"region_id\"]");
		By zipCode = By.xpath("//input[@name=\"postcode\"]");
		By phone = By.xpath("//input[@name=\"telephone\"]");
		Thread.sleep(2000);
		
		List<WebElement> listAddress = driver.findElements(newAddressBtn);
		System.out.println("listAddress size"+ listAddress.size() +"\nlist: "+ listAddress);
		
		if(listAddress.size()==0) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fname));
			System.out.println("First Name: "+driver.findElement(fname).getText());
			System.out.println("Last Name: "+driver.findElement(lname).getText());
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(streetAdd));
			driver.findElement(streetAdd).sendKeys("N-9, 105/3, M2 Road, Aurangabad");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(city));
			driver.findElement(city).sendKeys("Aurangabad");
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(country));
			Select countryList = new Select(driver.findElement(country));
			countryList.selectByVisibleText("India");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(state));
			Select stateList = new Select(driver.findElement(state));
			stateList.selectByVisibleText("Maharashtra");
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode));
			driver.findElement(zipCode).sendKeys("431001");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
			driver.findElement(phone).sendKeys("1234567890");
		}
		
	}
	
	public boolean applyDiscount() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		By applyDiscountCode = By.xpath("//span[text()=\"Apply Discount Code\"]");
		By enterCodeTextBox = By.xpath("//input[@placeholder=\"Enter discount code\"]");
		By applyDiscount = By.xpath("//span[text()=\"Apply Discount\"]");
		By errorMessage = By.xpath("//*[@id=\"co-payment-form\"]/fieldset/div[3]/div[2]/div");
		By nextBtn = By.xpath("//span[text()=\"Next\"]");
		
		driver.findElement(nextBtn).click();
		Thread.sleep(5000);
		WebElement applyDisc = driver.findElement(applyDiscountCode);
		wait.until(ExpectedConditions.elementToBeClickable(applyDiscountCode));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyDisc);
		//driver.findElement(applyDiscountCode).click();
		driver.findElement(enterCodeTextBox).sendKeys("TEES20");
		WebElement applyDiscountBTN = driver.findElement(applyDiscount);
		wait.until(ExpectedConditions.elementToBeClickable(applyDiscount));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyDiscountBTN);
		//driver.findElement(applyDiscount).click();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
	
	}
	
	public boolean placeOrder() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By placeOrder = By.xpath("//span[text()=\"Place Order\"]");
		By thankYouMsg = By.xpath("//span[text()=\"Thank you for your purchase!\"]");		
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder));
		driver.findElement(placeOrder).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouMsg));
		captureScreenshots("order placed successfully");
		return driver.findElement(thankYouMsg).isDisplayed();
		
	}
	
}
