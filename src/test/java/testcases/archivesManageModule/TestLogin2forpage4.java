package testcases.archivesManageModule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import libs.Browsers;
import libs.BrowsersType;
import libs.Do;
import libs.ParseProperties;
import pagebuilders.LoginHomepage4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestLogin2forpage4 {
	private WebDriver driver;
//	private Do du;
	private LoginHomepage4 loginpage;
	private ParseProperties td;
	@BeforeClass
	public void inialize() throws IOException{
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		//du =new Do(driver);
		td = new ParseProperties(System.getProperty("user.dir")+"/data/test.properties");
		driver.manage().window().maximize();
		loginpage = new LoginHomepage4(driver);		
	}
	//使用parseProperties参数化及接口传元素
	@Test
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver,15);
		loginpage.navigateToJxc(td.getValue("baseUrl"));
		loginpage.setMerchantId(td.getValue("ZMchid"));
		loginpage.setLoginName(td.getValue("ZUser"));;
		loginpage.setpasswd(td.getValue("passwd"));
		loginpage.submitLogin();	
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		Assert.assertEquals(loginpage.getloginname().isDisplayed(), true);
	}
/*	@Test //用户加时间制造唯一值的通用写法
	public void register(){
		SimpleDateFormat sdf = new SimpleDateFormat();
		String layout ="yyyyMMddHHmmss";
		sdf.applyPattern(layout);
		Calendar c1 = Calendar.getInstance();
		String accountname = sdf.format(c1.getTime());
		//可以使用页面联合调用方法的方式
		//page.setAccountName("test"+accountname).setpasswd("passwd").sumbmit();
	}*/
	/*@Test //未参数化调试用
	public void login(){
		LoginHomepage4 loginpage = new LoginHomepage4(driver); 
		loginpage.navigateToJxc(td.getValue("baseUrl"));
		loginpage.setMerchantId(td.getValue("ZMchid"));
		loginpage.setLoginName(td.getValue("ZUser"));
		loginpage.setpasswd(td.getValue("passwd"));
		loginpage.submitLogin();
		Assert.assertEquals(loginpage.getloginname().isDisplayed(), true);
	}*/
	/*@AfterClass //关闭浏览器
	public void releaseBrowser(){
		driver.quit();
	}*/
	
}
