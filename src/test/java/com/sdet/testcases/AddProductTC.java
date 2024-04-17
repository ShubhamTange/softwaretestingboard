package com.sdet.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sdet.base.TestBase;
import com.sdet.pages.AddToCartPage;

public class AddProductTC extends TestBase {

	AddToCartPage ap = new AddToCartPage();

	@Test(priority = 2)
	public void validateAddProductCart() throws InterruptedException {

		ap.addProduct();

	}

	public void validateSelectProductTees() {
		ap.selectProduct();
	}

	public void validateGoToCart() throws InterruptedException {
		ap.goToCart();

	}

	public void validateCartReview() {
		String actReview = ap.validateWaterBottleReview();
		String expReview = "Wide mouth opening makes it easy to clean!";
		Assert.assertEquals(actReview, expReview);
	}
	
	public void validateProceedTOCheckout() throws InterruptedException {
		ap.goToCart();
		
	}
	
	
}
