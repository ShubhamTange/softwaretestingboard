package com.sdet.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import com.sdet.base.TestBase;
import com.sdet.pages.SignInPage;
import com.sdet.pages.myOrder;
import com.sdet.utilities.ReadDataFromExcel;

public class MyOrderTC extends TestBase{
	myOrder order = new myOrder();
	
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
	
	@Test(priority = 1)
	public void validateGoToMyAccount() {
		
		AssertJUnit.assertTrue(order.goToMyAccount());
	}
	
	
	@Test(priority = 2)
	public void validateViewOrder() {
		AssertJUnit.assertTrue(order.goToMyOrder());
	}
	
	@DataProvider
	public String[][] dp(){
		String data[][] = ReadDataFromExcel.getDataForSignIn();
		return data;
	}
}
