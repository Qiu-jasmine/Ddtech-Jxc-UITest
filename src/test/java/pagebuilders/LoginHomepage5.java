package pagebuilders;


import libs.Do;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.locators.HomeLoc;

public class LoginHomepage5 {
	private WebDriver driver;
	private Do du;
	
	public  LoginHomepage5(WebDriver driver){
		this.driver=driver;
		du = new Do(driver);
	}
	
	public LoginHomepage5 navigateToJxc(String url){
		driver.get(url);
		return this;
	}
	public LoginHomepage5 setMerchantId(String merchantId){
		du.whatCSS(HomeLoc.merchantId).clear();
		du.whatCSS(HomeLoc.merchantId).sendKeys(merchantId);
		 return this;
	}
	public LoginHomepage5 setLoginName(String loginname){
		du.whatCSS(HomeLoc.loginName).clear();
		du.whatCSS(HomeLoc.loginName).sendKeys(loginname);
		return this;
	}
	public LoginHomepage5 setpasswd(String passwd){
		du.whatCSS(HomeLoc.passwd).clear();
		du.whatCSS(HomeLoc.passwd).sendKeys(passwd);
		return this;
	}
	public LoginHomepage5 submitLogin(){
		du.whatclassname(HomeLoc.loginbutton).click();
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
