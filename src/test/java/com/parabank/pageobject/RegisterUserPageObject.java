    package com.parabank.pageobject;

import java.lang.annotation.ElementType;
import java.time.Duration;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class RegisterUserPageObject {

	WebDriver driver;
	Wait<WebDriver> fwait;

	public RegisterUserPageObject(WebDriver driver) {
		this.driver = driver;
		fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoreAll(Arrays.asList(NoSuchElementException.class, StaleElementReferenceException.class,
						ElementClickInterceptedException.class, ElementNotInteractableException.class));
	}

	
	private By registerBtn = By.xpath("//a[normalize-space()='Register']");
	private By firstName = By.id("customer.firstName");
	private By LastName = By.id("customer.lastName");
	private By address = By.id("customer.address.street");
	private By city = By.id("customer.address.city");
	private By state = By.id("customer.address.state");
	private By zipCode = By.id("customer.address.zipCode");
	private By phoneNo = By.id("customer.phoneNumber");
	private By snn = By.id("customer.ssn");

	private By userName = By.id("customer.username");
	private By pass = By.id("customer.password");
	private By confPass = By.id("repeatedPassword");
	private By register=By.xpath("//input[@value='Register']");
	private By registerErrorMsg=By.id("customer.username.errors");
	private By successRegisterMsg=By.xpath("//p[contains(text(),'Your account was created successfully')]");
	 
	public void clickRegisterBtn() {
		WebElement element = driver.findElement(registerBtn);
		element.click();
	}

	public void setFirstName(String name) {
		WebElement element = driver.findElement(firstName);
		element.sendKeys(name);
	}

	public void setLastName(String lname) {
		WebElement element = driver.findElement(LastName);
		element.sendKeys(lname);
	}

	public void setAddress(String add) {
		WebElement element = driver.findElement(address);
		element.sendKeys(add);
	}

	public void setCity(String city) {
		WebElement element = driver.findElement(this.city);
		element.sendKeys(city);
	}

	public void setState(String state) {
		WebElement element = driver.findElement(this.state);
		element.sendKeys(state);
	}

	public void setZipCode(String zipCode) {
		WebElement element = driver.findElement(this.zipCode);
		element.sendKeys(zipCode);
	}

	public void setPhoneNo(String phoneNo) {
		WebElement element=driver.findElement(this.phoneNo);
		element.sendKeys(phoneNo);
	}

	public void setSnn(String snn) {
		WebElement element=driver.findElement(this.snn);
		element.sendKeys(snn);
	}

	public void setUserName(String userName) {
		WebElement element=driver.findElement(this.userName);
		element.sendKeys(userName);
	}

	public void setPass(String pass) {
		WebElement element=driver.findElement(this.pass);
		element.sendKeys(pass);
	}
	
	public void confPass(String pass) {
		WebElement element=driver.findElement(this.confPass);
		element.sendKeys(pass);  
	}
	
	public void registerBtn() {
		WebElement element=driver.findElement(register);
		element.click();
	}
	
	public String getRegistretionStatus() {
		
		if (!driver.findElements(registerErrorMsg).isEmpty()
	            && driver.findElement(registerErrorMsg).isDisplayed()) {

	        return driver.findElement(registerErrorMsg).getText();
	    }

	    if (!driver.findElements(successRegisterMsg).isEmpty()
	            && driver.findElement(successRegisterMsg).isDisplayed()) {

	        return driver.findElement(successRegisterMsg).getText();
	    }

	    return "Registration status not found";
	}

}
