package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pagebuilder.Do;
import pages.locators.HomeLoc;

public class LoginHomepage4 {
	private WebDriver driver;
	private Do du;
	
	public  LoginHomepage4(WebDriver driver){
		this.driver=driver;
		du = new Do(driver);
	}
	
	public LoginHomepage4 navigateToJxc(String url){
		driver.get(url);
		return this;
	}
	public void setMerchantId(String merchantId){
		du.whatCSS(HomeLoc.merchantId).clear();
		du.whatCSS(HomeLoc.merchantId).sendKeys(merchantId);
	}
	public void setLoginName(String loginname){
		du.whatCSS(HomeLoc.loginName).clear();
		du.whatCSS(HomeLoc.loginName).sendKeys(loginname);
	}
	public void setpasswd(String passwd){
		du.whatCSS(HomeLoc.passwd).clear();
		du.whatCSS(HomeLoc.passwd).sendKeys(passwd);
	}
	public void submitLogin(){
		du.whatclassname(HomeLoc.loginbutton).click();
	}
	public WebElement getloginname(){
		return du.what(HomeLoc.oagh);
	}

//	@AfterClass
//		public void release(){
//		ffwb.quit();
//	}
}
