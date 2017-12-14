package Testcases_archivesManageModule;

import libs.Browsers;
import libs.BrowsersType;
import libs.Do;
import libs.Wait;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilders.LoginHomepage;
import pagebuilders.UnitSetPage;

public class TestUnitSet {
	private WebDriver driver;
	private Do du;
	//private  Wait wait;
	@BeforeClass
	public void inialize(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		du = new Do(driver);
		driver.manage().window().maximize();
	}
	@Test
	public void newUnit(){
		
		LoginHomepage login = new LoginHomepage();	
		UnitSetPage unitset = new UnitSetPage(driver);		
		Wait wait = new Wait(driver);
		login.testLogin();
		wait.waitForElementPresent("Unit");
		unitset.newUnit();		
	//	WebElement code= driver.findElement(By.xpath(locators.getValue("unitCode")));
//		Unit.click();
//		WebDriverWait wait2 = new WebDriverWait(ffwb,3);
//		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getValue("newUnit"))));

	}
	@AfterClass
	public void release(){
	driver.quit();
	}
}
