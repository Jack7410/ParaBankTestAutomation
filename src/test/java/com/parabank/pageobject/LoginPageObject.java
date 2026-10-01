 package com.parabank.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPageObject {
	
	WebDriver driver;
	Wait<WebDriver> fwait;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoreAll(Arrays.asList(NoSuchElementException.class, NullPointerException.class));
	}
	
	
	private By userName=By.xpath("//input[@name='username']");
	private By userPass=By.xpath("//input[@name='password']");
	private By loginBtn=By.xpath("//input[@value='Log In']");
	
	public void setUserName(String userid) {
		WebElement element=driver.findElement(userName);
		element.clear();
		element.sendKeys(userid);
		
	}
	
	public void setUserPass(String pass) {
		WebElement element=driver.findElement(userPass);
		element.clear();
		
		element.sendKeys(pass);
	}
	
	
	public void clickLoginBtn() {
		WebElement element=driver.findElement(loginBtn);
		fwait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	
	
	

}
