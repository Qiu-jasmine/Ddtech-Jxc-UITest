package archivesManageModule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilder.Browsers;
import pagebuilder.BrowsersType;
import pagebuilder.Do;
import pagebuilder.Wait;
import pages.LoginHomepage;
import pages.UnitSetPage;

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
