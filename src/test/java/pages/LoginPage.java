package pages;


import libs.DBOp;
import libs.Do;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pages.locators.HomeLoc;

public class LoginPage {
	private WebDriver driver;
	private DBOp dbsession = new DBOp("LoginPage");
	private Do du ;
	public  LoginPage(WebDriver driver){
		this.driver=driver;
		du = new Do(driver);
		dbsession.conn(System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
	}
	//配置进销存登录地址
	public LoginPage navigateToJxc(String url){
		driver.get(url);
		return this;
	}
	//输入商户号/账号、密码： WebElementName：数据库中对应的元素名称,inputvalue，需要输入的值
	public LoginPage setValue(String WebElementName,String inputvalue){
		WebElement passwd1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(WebElementName)));
		 passwd1.clear();
		 passwd1.sendKeys(inputvalue);
		return this;
	}
	public LoginPage checkremenberpw(String checkboxWbName){
		WebElement  checkbox=driver.findElement(By.xpath(dbsession.getLocatorXpath(checkboxWbName)));
		if(!checkbox.isSelected()){
			checkbox.click();
		}else
		{
			System.out.println("已记住密码了，请往下一步");
		}	
		return this;
	}
	//提交登录：loginbuttonWe：数据库中对应的元素名称
	public LoginPage submitLogin(String loginbuttonWe){
		driver.findElement(By.xpath(dbsession.getLocatorXpath(loginbuttonWe))).click();
		return this;
	}
	//获取数据库元素名对应的xpath元素值
	public String getValue(String WebElementName){
		return dbsession.getLocatorXpath(WebElementName);
	}
/*	public WebElement getvalue(String WebElementName){
		return du.what(dbsession.getLocatorXpath(WebElementName));
	}*/

}
