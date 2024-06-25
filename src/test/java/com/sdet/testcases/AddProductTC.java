package com.sdet.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.DataProvider;


import com.sdet.base.TestBase;
import com.sdet.pages.AddToCartPage;
import com.sdet.pages.SignInPage;
import com.sdet.utilities.ReadDataFromExcel;

public class AddProductTC extends TestBase {

	AddToCartPage ap = new AddToCartPage();

	@BeforeClass()
	public void beforeClass() throws IOException {
		if(driver==null) {
			launchBrowser();
			navigateToURL();
			String[][] data = dp();
			String username = data[0][0];
			String password = data[0][1];
			SignInPage.sigin(username, password);
		}
		
	}
	
	@Test(priority = 1)
	public void validateAddProductCart() throws InterruptedException {

		ap.addProduct();
	}

	@Test(priority = 2)
	public void validateSelectProductTees() {
		ap.selectProduct();
	}

	@Test(priority = 3)
	public void validateGoToCart() throws InterruptedException {
		ap.goToCart();

	}

	@Test(priority = 4)
	public void validateCartReview() {
		String actReview = ap.validateWaterBottleReview();
		String expReview = "Wide mouth opening makes it easy to clean!";
		AssertJUnit.assertEquals(actReview, expReview);
	}
	
	@Test(priority = 5)
	public void validateProceedTOCheckout() throws InterruptedException {
		ap.goToCart();
		AssertJUnit.assertTrue(ap.proceedToCheckOut());
		
	}
	
	@Test(priority = 6)
	public void validateShippingMehtod() throws InterruptedException {
		
		AssertJUnit.assertTrue(ap.selectShippingMethod());
		
	}
	
	
	@Test(priority = 7)
	public void validateAddAddress() throws InterruptedException {
		
		ap.addAddress();
		
	}
	

	@Test(priority = 8)
	public void validateApplyDiscount() throws InterruptedException {
		
		AssertJUnit.assertTrue(ap.applyDiscount());
		
	}
	
	
	@Test(priority = 9)
	public void validatePlaceOrder() throws InterruptedException {
		
		AssertJUnit.assertTrue(ap.placeOrder());
		
	}
	
	
	@DataProvider
	public String[][] dp(){
		String data[][] = ReadDataFromExcel.getData();
		return data;
	}
	
	
	
}
