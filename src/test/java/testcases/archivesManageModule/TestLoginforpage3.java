package testcases.archivesManageModule;

import java.io.IOException;

import libs.Browsers;
import libs.BrowsersType;
import libs.Do;
import libs.ParseProperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilders.LoginHomepage3;

public class TestLoginforpage3 {
	private WebDriver driver;
	//private Do du;
	private ParseProperties td;
	@BeforeClass
	public void inialize() throws IOException{
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		td = new ParseProperties(System.getProperty("user.dir")+"/data/test.properties");
		//du =new Do(driver);
		driver.manage().window().maximize();
	}
	//使用parseProperties参数化
	@Test
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver,15);
		LoginHomepage3 loginpage = new LoginHomepage3(driver); 
		loginpage.navigateToJxc(td.getValue("baseUrl"));
		loginpage.setMerchantId(td.getValue("ZMchid"));
		loginpage.setLoginName(td.getValue("ZUser"));
		loginpage.setpasswd(td.getValue("passwd"));
		loginpage.submitLogin();
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		Assert.assertEquals(loginpage.getloginname().isDisplayed(), true);
	}
	/*@AfterClass
	public void releaseBrowser(){
		driver.quit();
	}*/
	
}
