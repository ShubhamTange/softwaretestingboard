package com.sdet.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sdet.base.TestBase;
import com.sdet.pages.AddToCartPage;
import com.sdet.pages.SignInPage;
import com.sdet.utilities.ReadDataFromExcel;

public class SigninTC extends TestBase{

	@BeforeClass
	public void beforeClass() throws IOException {
		
		launchBrowser();
		navigateToURL();
		
	}
	
	@Test(dataProvider = "dp", priority = 1)
	public void signInTC(String username, String password) {
		Assert.assertTrue(SignInPage.sigin(username, password));
	}
	
	@Test(priority = 2)
	public void addProductCart() throws InterruptedException {
		AddToCartPage ap = new AddToCartPage();
		ap.addProduct();
		ap.selectProduct();
		ap.goToCart();
		String actReview = ap.validateWaterBottleReview();
		String expReview = "Wide mouth opening makes it easy to clean!";
		
		Assert.assertEquals(actReview, expReview);
		ap.goToCart();
		ap.proceedToCheckOut();
		ap.addAddress();
	}
	
	
	
	@DataProvider
	public String[][] dp(){
		String data[][] = ReadDataFromExcel.getData();
		return data;
	}
	
}