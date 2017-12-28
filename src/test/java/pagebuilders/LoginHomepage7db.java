package pagebuilders;


import libs.DBOp;
import libs.Do;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.locators.HomeLoc;

public class LoginHomepage7db {
	private WebDriver driver;
	private Do du;
	private DBOp dbsession = new DBOp("LoginPage");
	
	public  LoginHomepage7db(WebDriver driver){
		this.driver=driver;
		//du = new Do(driver);
		dbsession.conn(System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
	}
	
	public LoginHomepage7db navigateToJxc(String url){
		//driver.findElement(By.cssSelector(dbsession.getLocatorCSS("")))
		driver.get(url);
		return this;
	}
	public LoginHomepage7db setMerchantId(String merchantId){
		WebElement merchantId1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(merchantId)));
		merchantId1.clear();
		merchantId1.sendKeys(dbsession.getWebelementValue(merchantId));
		/*du.whatCSS(HomeLoc.merchantId).clear();
		du.whatCSS(HomeLoc.merchantId).sendKeys(merchantId);*/
		 return this;
	}
	public LoginHomepage7db setLoginName(String loginname){
		WebElement loginname1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(loginname)));
		loginname1.clear();
		loginname1.sendKeys(dbsession.getWebelementValue(loginname));
		/*du.whatCSS(HomeLoc.loginName).clear();
		du.whatCSS(HomeLoc.loginName).sendKeys(loginname);*/
		return this;
	}
	public LoginHomepage7db setValue(String WebElementName,String inputvalue){
		WebElement passwd1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(WebElementName)));
		//sendValue(driver.findElement(By.cssSelector(dbsession.getLocatorCSS(passwd))),"admin");
		 passwd1.clear();
		 passwd1.sendKeys(inputvalue);
	/*	du.whatCSS(HomeLoc.passwd).clear();
		du.whatCSS(HomeLoc.passwd).sendKeys(passwd);*/
		return this;
	}
	public LoginHomepage7db setpasswd(String WebElementName,String inputvalue){
		WebElement passwd1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(WebElementName)));
		//sendValue(driver.findElement(By.cssSelector(dbsession.getLocatorCSS(passwd))),"admin");
		 passwd1.clear();
		 passwd1.sendKeys(inputvalue);
	/*	du.whatCSS(HomeLoc.passwd).clear();
		du.whatCSS(HomeLoc.passwd).sendKeys(passwd);*/
		return this;
	}
	public LoginHomepage7db submitLogin(String loginbutton){
		/*du.whatclassname(HomeLoc.loginbutton).click();*/
		driver.findElement(By.xpath(dbsession.getLocatorXpath(loginbutton))).click();
		return this;
	}
/*	public  void sendValue(WebElement element,String value){
		//driver.findElement(By.cssSelector(dbsession.getLocatorCSS("")))
		element.clear();
		element.sendKeys(value);
		//return this;
	}*/
/*	public WebElement getloginname(){
		return du.what(HomeLoc.oagh);
	}*/
	//动态元素的校验方式
/*	public WebElement getWebElement(String wn,String accountname){
		return du.what(String.format(wn,accountname));
	}*/

//	@AfterClass
//		public void release(){
//		ffwb.quit();
//	}
}
