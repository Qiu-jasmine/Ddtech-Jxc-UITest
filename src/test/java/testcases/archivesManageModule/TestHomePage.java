package testcases.archivesManageModule;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import libs.Browsers;
import libs.BrowsersType;
import libs.DBOp;
import libs.ParseProperties;
import libs.TestCSVdemo;
import libs.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;


public class TestHomePage {
	private WebDriver driver;
	private LoginPage loginpage;
	private HomePage homepage;
	private TestCSVdemo userinfo;
	private Wait wait; 
	@BeforeClass
	public void inialize() throws IOException{
		//打开浏览器，初始化登录页面，初始化用户信息文件，初始化一个wait
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver=browser.driver;
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		userinfo = new TestCSVdemo(System.getProperty("user.dir")+"\\data\\userinfo.csv");
		wait = new Wait(driver);
		driver.manage().window().maximize();		
	}
	@Test
	public void login(){
		//读取csv文件给参数赋值
		loginpage.navigateToJxc(userinfo.getTestData("URL", "tc1"));
		loginpage.setValue("merchantId", userinfo.getTestData("mchid", "tc1"));
		loginpage.setValue("loginName", userinfo.getTestData("username", "tc1"));
		loginpage.setValue("passwd", userinfo.getTestData("passwd", "tc1"));
		loginpage.submitLogin("loginbutton");
		wait.waitForElementPresent(loginpage.getValue("archivesManage"));
	    Assert.assertEquals(driver.findElement(By.xpath(loginpage.getValue("archivesManage"))).isDisplayed(), true);
	}
	@Test(dependsOnMethods = { "login" })
	public void home() {
		homepage.clickModule("archivesManage");
		homepage.clickandWait("purchaseManage", "purchaseorder");
		homepage.logoff("dropdown", "logoff");
	}
	@AfterClass //关闭浏览器
	public void releaseBrowser(){
		driver.quit();
	}
	
}
