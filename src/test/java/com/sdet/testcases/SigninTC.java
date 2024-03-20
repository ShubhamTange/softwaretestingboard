package com.sdet.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sdet.base.TestBase;
import com.sdet.pages.SignInPage;

public class SigninTC extends TestBase{

	@BeforeClass
	public void beforeClass() throws IOException {
		
		launchBrowser();
		navigateToURL();
		
	}
	
	@Test
	public void signInTC() {
		Assert.assertTrue(SignInPage.sigin());
	}
}