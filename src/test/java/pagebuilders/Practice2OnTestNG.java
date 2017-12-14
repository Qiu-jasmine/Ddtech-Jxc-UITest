package pagebuilders;

import java.io.IOException;

import libs.Browsers;
import libs.BrowsersType;
import libs.ParseProperties;
import libs.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Practice2OnTestNG {

	protected static WebDriver ffwb = null;
	private FirefoxProfile firefoxfile = null;
	private String projectpath = System.getProperty("user.dir");
	
	private ParseProperties data;
	private ParseProperties locator;
	
	@Parameters({"data","locator"})
	@Test
	public void startFirefox(@Optional("data") String da,@Optional("loc1") String loc){
		try {
			data = new ParseProperties(System.getProperty("user.dir")+da);
			locator = new ParseProperties(System.getProperty("user.dir")+loc);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Browsers browser = new Browsers(BrowsersType.firefox);
		ffwb = browser.driver;
	}
	@Test
	public void accessJxc(){
		Wait wait = new Wait(ffwb);
		
		//ffwb.get(data.getValue(ffwb));
		ffwb.findElement(By.xpath(locator.getValue("username"))).clear();
		ffwb.findElement(By.xpath(locator.getValue("username"))).sendKeys(data.getValue("username"));
		ffwb.findElement(By.xpath(locator.getValue("passwd"))).sendKeys(data.getValue("passwd"));
		
		wait.waitForElementPresent(locator.getValue("homepage"));
		
		
	}
}
