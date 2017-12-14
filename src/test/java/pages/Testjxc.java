package pages;

import static org.testng.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testjxc {
	String baseUrl ="http://test2.diandianwaimai.com:6030";
	String ZMchid = "10068";
	String ZUser ="admin";
	String passwd ="admin";
	WebDriver driver =new FirefoxDriver();
	@Before
	public void testLogin(){
		//登录进销存界面		
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
		System.out.println("跳转到档案管理界面成功");
		//进入单位设置
		WebElement Unit = driver.findElement(By.xpath("//li[text()='单位设置']"));
		Unit.click();
		WebDriverWait wait2 = new WebDriverWait(driver,3);
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='新建']")));
		//新增
		driver.findElement(By.xpath("//span[text()='新建']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='单位信息']")));
				
	}
	@Test
	public void testArchivesManage(){
			//单位新增
		WebElement newUnit =driver.findElement(By.cssSelector(".//*[@id='contentArea']/section/div[1]/div[1]/span"));
		String newText = newUnit.getText();
		assertEquals("新建",newText);
		newUnit.click();
		//新增角色
		//driver.findElement(By.xpath("//*[@id='contentArea']/section/div[1]/div[1]/span")).click();
		}
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
}
