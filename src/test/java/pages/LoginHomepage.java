package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pagebuilder.Browsers;
import pagebuilder.BrowsersType;
import pagebuilder.ParseProperties;

public class LoginHomepage {
/*	String baseUrl ="http://test2.diandianwaimai.com:6030";
	String ZMchid = "10068";
	String ZUser ="admin";
	String passwd ="admin";*/
	protected static WebDriver ffwb = null;
	private FirefoxProfile firefoxfile = null;
	private String projectpath = System.getProperty("user.dir");
	
	private ParseProperties data;
	private ParseProperties locator;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void startFirefox(@Optional("data") String da,@Optional("loc1") String loc) throws IOException{
		
		data = new ParseProperties(projectpath+da);
		locator = new ParseProperties(System.getProperty("user.dir")+loc);
		Browsers browser = new Browsers(BrowsersType.firefox);
		ffwb = browser.driver;
	}	
	@Test
	public void testLogin(){	
		//Wait wait = new Wait(ffwb);
		//登录进销存界面	
		ffwb.get(data.getValue("baseUrl"));
		WebElement merchantId =ffwb.findElement(By.cssSelector(locator.getValue("merchantId")));
		merchantId.clear();
		merchantId.sendKeys(data.getValue("ZMchid"));
		
		WebElement loginName =ffwb.findElement(By.cssSelector(locator.getValue("loginName")));
		loginName.clear();
		loginName.sendKeys(data.getValue("ZUser"));
		
		WebElement passwd =ffwb.findElement(By.cssSelector(locator.getValue("passwd")));
		passwd.clear();
		passwd.sendKeys(data.getValue("passwd"));
		
		ffwb.findElement(By.className(locator.getValue("loginbutton"))).click();
		
		//显示等待页面加载
		WebDriverWait wait = new WebDriverWait(ffwb,15);
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		System.out.println("跳转到档案管理界面成功");
				
	}
//	@Test
//	public void testArchivesManage(){
//		//进入单位设置
//		WebElement Unit = ffwb.findElement(By.xpath(locator.getValue("Unit")));
//		Unit.click();
//		WebDriverWait wait2 = new WebDriverWait(ffwb,3);
//		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getValue("newUnit"))));
//		//新增单位
//		ffwb.findElement(By.xpath(locator.getValue("newUnit"))).click();
//		WebDriverWait wait1 = new WebDriverWait(ffwb,5);
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getValue("unitInfo"))));
//		
//		//新增角色
//		//driver.findElement(By.xpath("//*[@id='contentArea']/section/div[1]/div[1]/span")).click();
//		}
	/*@Test
	public void testRolemanage(){
		//登录进销存界面
		WebDriver driver =new FirefoxDriver();
		driver.get(baseUrl);
		WebElement merchantId = driver.findElement((By.cssSelector("input[placeholder='商户号']")));
		merchantId.clear();
		merchantId.sendKeys(ZMchid);
		WebElement loginName = driver.findElement(By.cssSelector("input[placeholder='工号']"));
		loginName.clear();
		loginName.sendKeys(ZUser);
		driver.findElement(By.cssSelector("input[placeholder='密码']")).sendKeys(passwd);
		driver.findElement(By.className("login-buttom")).click();
		//显示等待页面加载
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.urlContains("archivesManage"));
		WebElement select = driver.findElement(By.xpath("//*[@id='nav']/li[1]/div/span"));
		wait.until(ExpectedConditions.elementToBeSelected(select));
		System.out.println("跳转到档案管理界面");
		//定位到角色管理界面,断言是否页面正确
		//driver.get("http://test2.diandianwaimai.com:6030/systemMaintenance#/roleManage");
		//driver.findElement(By.xpath("//*[@id='nav']/li[7]/div/span")).click();
		
		//String roleManageTitle = driver.findElement(By.xpath("//*[@id='nav']/li[7]/ul/li[1]")).getText();
		//assertEquals("角色管理",roleManageTitle);
		//新增角色
		//driver.findElement(By.xpath("//*[@id='contentArea']/section/div[1]/div[1]/span")).click();
	}
*/
//	@AfterClass
//		public void release(){
//		ffwb.quit();
//	}
}
