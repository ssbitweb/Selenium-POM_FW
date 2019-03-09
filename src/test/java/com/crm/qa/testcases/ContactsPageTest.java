package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.swithcToFrame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test(priority =1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactspage.verifyContactslabel(),"Contacts Label is Missing on Contacts Page");
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContactsByName("sachin pune");
	}
	
	@Test(priority = 3)
	public void selectMultiPleContactsTest() {
		contactspage.selectContactsByName("sachin multiple");
		contactspage.selectContactsByName("sachin pune");
	}
	
	@DataProvider
	public  Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority =4 , dataProvider ="getCRMTestData")
	public void validateCreateNewContacts(String title, String firstName, String lastname, String company) {
		homepage.clickOnNewContactsLink();
		//contactspage.createNewContacts("Mr.", "sachin", "pune", "HSBC");
		contactspage.createNewContacts(title, firstName, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
