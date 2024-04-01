package com.sdet.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.sdet.base.TestBase;
import com.sdet.pages.SignInPage;
import com.sdet.utilities.ReadDataFromExcel;

public class SigninTC extends TestBase{

	@BeforeClass
	public void beforeClass() throws IOException {
		
		launchBrowser();
		navigateToURL();
		
	}
	
	@Test(dataProvider = "dp")
	public void signInTC(String username, String password) {
		Assert.assertTrue(SignInPage.sigin(username, password));
	}
	
	
	@DataProvider
	public String[][] dp(){
		String data[][] = ReadDataFromExcel.getData();
		return data;
	}
}