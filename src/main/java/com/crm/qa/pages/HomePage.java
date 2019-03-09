package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath ="//td[contains(text(),'User: Naveen AutomationLabs')]")
	WebElement user;
	
	@FindBy(xpath ="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath ="//a[@title='New Contact']")
	WebElement newContactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath ="//a[@title='Tasks']")
	WebElement taskLink;

	//Initializing page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Mathods - features
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUser() {
		return user.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink() {
		taskLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactsLink() {
		
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();	
	}
	
	
	
}
