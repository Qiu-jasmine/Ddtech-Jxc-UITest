package archivesManageModule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilder.Browsers;
import pagebuilder.BrowsersType;
import pagebuilder.Do;

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
