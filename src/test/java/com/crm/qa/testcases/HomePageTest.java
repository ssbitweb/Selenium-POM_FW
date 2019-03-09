package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest() {
		super();
	}
	
	//Test cases should be separated -- independent to each other
	//before each test case -- launch the browse and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home page Title is not matched");
		System.out.println(homePageTitle);
	}
	
	@Test(priority = 2)
	public void verifyUserTest() {
		testutil.swithcToFrame();
		Assert.assertTrue(homepage.verifyUser());
	}
	
	@Test(priority = 3)
	public void verifyContactsPageLink() {
		testutil.swithcToFrame();
		contactspage = homepage.clickOnContactsLink();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
