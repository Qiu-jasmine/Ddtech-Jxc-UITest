package archivesManageModule;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilder.Browsers;
import pagebuilder.BrowsersType;
import pagebuilder.Do;
import pages.LoginHomepage2;

public class TestLogin {
	private WebDriver driver;
	private Do du;
	String baseUrl ="http://test2.diandianwaimai.com:6030";
	String ZMchid = "10068";
	String ZUser ="admin";
	String passwd ="admin";
	@BeforeClass
	public void inialize(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		du =new Do(driver);
		driver.manage().window().maximize();
	}
	//PageFactory形式实现参数化
	@Test
	public void login(){
		LoginHomepage2 loginpage = new LoginHomepage2(driver); 
		loginpage.navigateToJxc(baseUrl);
		loginpage.setMerchantId(ZMchid);
		loginpage.setLoginName(ZUser);
		loginpage.setpasswd(passwd);
		loginpage.submitLogin();
	}
	
}
