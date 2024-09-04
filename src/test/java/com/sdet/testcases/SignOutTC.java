package com.sdet.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet.base.TestBase;
import com.sdet.pages.SignInPage;
import com.sdet.pages.SignOutPage;
import com.sdet.utilities.ReadDataFromExcel;

public class SignOutTC extends TestBase{

	@BeforeClass()
	public void beforeClass() throws IOException {
		if(driver==null) {
			launchBrowser();
			navigateToURL();
			String[][] data = dp();
			String username = data[0][0];
			String password = data[0][1];
			SignInPage.signin(username, password);
		}
	}
	@Test
	public void validateSignOut() {
		
		SignOutPage user = new SignOutPage();
		Assert.assertTrue(user.clickSignout());
	}
	
	@DataProvider
	public String[][] dp(){
		String data[][] = ReadDataFromExcel.getDataForSignIn();
		return data;
	}
}
