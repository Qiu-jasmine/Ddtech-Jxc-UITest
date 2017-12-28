package testcases.archivesManageModule;

import libs.Browsers;
import libs.BrowsersType;
import libs.Do;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestManageArea {
	private WebDriver driver;
	private Do du;
	
	@BeforeClass
	public void inialize(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		du =new Do(driver);
		driver.manage().window().maximize();
	}
	@Test
	public void newManageArea(){
		
	}
	
}
