package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
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
import pagebuilder.Wait;

public class LoginHomepage3 {
	
	private WebDriver driver;
	//Wait wait = new Wait(driver);
	@FindBy(css="input[placeholder='商户号']")
	private WebElement merchantId;
	
	@FindBy(css="input[placeholder='工号']")
	private WebElement loginName;
	
	@FindBy(css="input[placeholder='密码']")
	private WebElement passWord;
	
	@FindBy(className="login-buttom")
	private WebElement submitBtn;
	
/*	@FindBy(xpath="//section[@id='container']/descendant::span[3]")
	private WebElement oagh;*/
	@FindBy(xpath="//span[contains(text(),'admin')]")
	private WebElement oagh;
	
	public LoginHomepage3(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void navigateToJxc(String url){
		driver.get(url);
	}
	public void setMerchantId(String merchantId){
		this.merchantId.clear();
		this.merchantId.sendKeys(merchantId);
	}
	public void setLoginName(String loginname){
		loginName.clear();
		loginName.sendKeys(loginname);
	}
	public void setpasswd(String passwd){
		passWord.clear();
		passWord.sendKeys(passwd);
	}
	public void submitLogin(){
		submitBtn.click();
		//submitBtn.submit();
	}
	public WebElement getloginname(){
		return oagh;
	}
	/*
	@Test
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
