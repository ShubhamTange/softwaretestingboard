package com.sdet.testcases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sdet.base.TestBase;
import com.sdet.pages.CreateAccountPage;
import com.sdet.pages.SignInPage;
import com.sdet.utilities.ReadDataFromExcel;

public class CreateAccountTC extends TestBase{

	@BeforeClass()
	public void beforeClass() throws IOException {
		if(driver==null) {
			launchBrowser();
			navigateToURL();
		}
	}
	
	@Test(priority = 1)
	public void validateClickOnCreateAccountLink() {
		
		CreateAccountPage cp = new CreateAccountPage();
		assertTrue(cp.clickOnCreateAccountLink());
	}
	
	@Test(priority = 2, dataProvider = "dp")
	public void validatefillDetails(String firstname, String lastName1, String username, String password, String cnfPwd) throws InterruptedException {
		
		CreateAccountPage cp = new CreateAccountPage();
		assertTrue(cp.fillDetails(firstname, lastName1, username, password, cnfPwd));
	}
	
	@DataProvider
	public Object[][] dp(){
		
		String data[][] = ReadDataFromExcel.getDataForRegistration();
		return data;
	}
	
	
}
