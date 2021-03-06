package pagebuilders;


import libs.DBOp;
import libs.Do;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.locators.HomeLoc;

public class LoginHomepage6db {
	private WebDriver driver;
	private Do du;
	private DBOp dbsession = new DBOp("LoginHOmepage");
	
	public  LoginHomepage6db(WebDriver driver){
		this.driver=driver;
		du = new Do(driver);
		dbsession.conn(System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
	}
	
	public LoginHomepage6db navigateToJxc(String url){
		//driver.findElement(By.cssSelector(dbsession.getLocatorCSS("")))
		driver.get(url);
		return this;
	}
	public LoginHomepage6db setMerchantId(String merchantId){
		WebElement merchantId1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(merchantId)));
		merchantId1.clear();
		merchantId1.sendKeys(dbsession.getWebelementValue(merchantId));
		/*du.whatCSS(HomeLoc.merchantId).clear();
		du.whatCSS(HomeLoc.merchantId).sendKeys(merchantId);*/
		 return this;
	}
	public LoginHomepage6db setLoginName(String loginname){
		WebElement loginname1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(loginname)));
		loginname1.clear();
		loginname1.sendKeys(dbsession.getWebelementValue(loginname));
		/*du.whatCSS(HomeLoc.loginName).clear();
		du.whatCSS(HomeLoc.loginName).sendKeys(loginname);*/
		return this;
	}
	public LoginHomepage6db setpasswd(String passwd){
		WebElement passwd1=driver.findElement(By.cssSelector(dbsession.getLocatorCSS(passwd)));
		 passwd1.clear();
		 passwd1.sendKeys(dbsession.getWebelementValue(passwd));
	/*	du.whatCSS(HomeLoc.passwd).clear();
		du.whatCSS(HomeLoc.passwd).sendKeys(passwd);*/
		return this;
	}
	public LoginHomepage6db submitLogin(String loginbutton){
		/*du.whatclassname(HomeLoc.loginbutton).click();*/
		driver.findElement(By.xpath(dbsession.getLocatorXpath(loginbutton))).click();
		return this;
	}
	public WebElement getloginname(){
		return du.what(HomeLoc.oagh);
	}
	//动态元素的校验方式
/*	public WebElement getWebElement(String wn,String accountname){
		return du.what(String.format(wn,accountname));
	}*/

//	@AfterClass
//		public void release(){
//		ffwb.quit();
//	}
}
