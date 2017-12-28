package pages;


import libs.DBOp;
import libs.Do;
import libs.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pages.locators.HomeLoc;

public class HomePage {
	private WebDriver driver;
	private DBOp dbsession = new DBOp("HomePage");
	private Do du ;
	private Wait wait;
	public  HomePage(WebDriver driver){
		this.driver=driver;
		du = new Do(driver);
		wait = new Wait(driver);
		dbsession.conn(System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
	}
	public HomePage clickModule(String locatorname){
		driver.findElement(By.xpath(dbsession.getLocatorXpath(locatorname))).click();
		return this;
	}
	public HomePage clickandWait(String locatorname,String waitWename){
		driver.findElement(By.xpath(dbsession.getLocatorXpath(locatorname))).click();
		wait.waitForElementPresent(dbsession.getLocatorXpath(waitWename));
		Assert.assertEquals(driver.findElement(By.xpath(dbsession.getLocatorXpath(waitWename))).isDisplayed(), true);
		return this;
	}
	public WebElement getWbbyxpath(String WebElementName){
		return du.what(dbsession.getLocatorXpath(WebElementName));
}
	public String getlocator(String WebElementName){
		return dbsession.getLocatorXpath(WebElementName);
	}
	public HomePage logoff(String dropdownWEname,String logoffWEname){
		driver.findElement(By.xpath(dbsession.getLocatorXpath(dropdownWEname))).click();
		wait.waitForElementClickable(dbsession.getLocatorXpath(logoffWEname));;
		driver.findElement(By.xpath(dbsession.getLocatorXpath(logoffWEname))).click();
		return this;
	}
	
}
