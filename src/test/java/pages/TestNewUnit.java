package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pagebuilder.Browsers;
import pagebuilder.BrowsersType;
import pagebuilder.Do;

public class TestNewUnit {
	private WebDriver driver;
	private Do du;

	@BeforeClass
	public void inialize(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		du = new Do(driver);
		driver.manage().window().maximize();
	}
	@Test
	public void newUnit(){
		LoginHomepage login = new LoginHomepage();
	}
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
		//新增角色
		//driver.findElement(By.xpath("//*[@id='contentArea']/section/div[1]/div[1]/span")).click();
		//}
}
