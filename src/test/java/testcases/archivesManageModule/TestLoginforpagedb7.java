package testcases.archivesManageModule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import libs.Browsers;
import libs.BrowsersType;
import libs.Do;
import libs.ParseProperties;
import libs.TestCSVdemo;
import pagebuilders.LoginHomepage4;
import pagebuilders.LoginHomepage5;
import pagebuilders.LoginHomepage6db;
import pagebuilders.LoginHomepage7db;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestLoginforpagedb7 {
	private WebDriver driver;
//	private Do du;
	private LoginHomepage7db loginpage;
	//private ParseProperties td;
	@BeforeClass
	public void inialize() throws IOException{
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		//du =new Do(driver);
		//td = new ParseProperties(System.getProperty("user.dir")+"/data/test.properties");
		//TestCSVdemo a = new TestCSVdemo(System.getProperty("user.dir")+"\\data\\userinfo.csv");
		driver.manage().window().maximize();
		//loginpage = new LoginHomepage5(driver);		
	}
	@Test
	public void login(){
		loginpage = new LoginHomepage7db(driver);
		TestCSVdemo a = new TestCSVdemo(System.getProperty("user.dir")+"\\data\\userinfo.csv");
		WebDriverWait wait = new WebDriverWait(driver,15);
		loginpage.navigateToJxc(a.getTestData("URL", "tc1"));
		loginpage.setValue("merchantId", a.getTestData("mchid", "tc1"));
		loginpage.setValue("loginName", a.getTestData("username", "tc1"));
		loginpage.setValue("passwd", a.getTestData("passwd", "tc1"));
		//loginpage.setMerchantId("merchantId");
		//loginpage.setLoginName("loginName");
		//loginpage.setpasswd("passwd",a.getTestData("passwd", "tc1"));
		loginpage.submitLogin("loginbutton");
		
	}
/*	@Test
	public void login(){
		loginpage = new LoginHomepage6db(driver);
		WebDriverWait wait = new WebDriverWait(driver,15);
		loginpage.navigateToJxc("http://test2.diandianwaimai.com:6030/");
		loginpage.setMerchantId("merchantId");
		loginpage.setLoginName("loginName");
		loginpage.setpasswd("passwd");
		loginpage.submitLogin("loginbutton");
		
	}*/
	//页面接口元素与csv联合用,需要调试
/*	@Test
	public void login(){
		TestCSVdemo a = new TestCSVdemo(System.getProperty("user.dir")+"\\data\\userinfo.csv");
		loginpage = new LoginHomepage5(driver);	
		WebDriverWait wait = new WebDriverWait(driver,15);
		loginpage.navigateToJxc(a.getTestData("URL", "tc1"));
		loginpage.setMerchantId(a.getTestData("mchid", "tc1")).setLoginName(a.getTestData("username", "tc1")).setpasswd(a.getTestData("passwd", "tc1")).submitLogin();
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		Assert.assertEquals(loginpage.getloginname().isDisplayed(), true);
	}*/
	//如果是返回页面的形式，则可以连写方法
/*	@Test
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver,15);
		loginpage.navigateToJxc(td.getValue("baseUrl"));
		loginpage.setMerchantId(td.getValue("ZMchid")).setLoginName(td.getValue("ZUSer")).setpasswd(td.getValue("passwd")).submitLogin();
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		Assert.assertEquals(loginpage.getloginname().isDisplayed(), true);
	}*/
	//使用parseProperties参数化及接口传元素
/*	@Test
	public void login(){
		WebDriverWait wait = new WebDriverWait(driver,15);
		loginpage.navigateToJxc(td.getValue("baseUrl"));
		loginpage.setMerchantId(td.getValue("ZMchid"));
		loginpage.setLoginName(td.getValue("ZUser"));;
		loginpage.setpasswd(td.getValue("passwd"));
		loginpage.submitLogin();	
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		Assert.assertEquals(loginpage.getloginname().isDisplayed(), true);
	}*/
/*	@Test //用户加时间制造唯一值的通用写法
	public void register(){
		SimpleDateFormat sdf = new SimpleDateFormat();
		String layout ="yyyyMMddHHmmss";
		sdf.applyPattern(layout);
		Calendar c1 = Calendar.getInstance();
		String accountname = sdf.format(c1.getTime());
		//可以使用页面联合调用方法的方式
		//page.setAccountName("test"+accountname).setpasswd("passwd").sumbmit();
		 //动态xpath的验证
		//Assert.assertEquals(loginpage.getWebElement(HomeLoc.oagh1,"test"+accountname).isDisplayed(), true);
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
