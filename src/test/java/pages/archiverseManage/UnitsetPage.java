package pages.archiverseManage;


import libs.DBOp;
import libs.Do;
import libs.Wait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import pages.locators.HomeLoc;

public class UnitsetPage {
	private WebDriver driver;
	private DBOp dbsession = new DBOp("UnitsetPage");
	private Do du ;
	private Wait wait;
	public  UnitsetPage(WebDriver driver){
		this.driver=driver;
		du = new Do(driver);
		wait = new Wait(driver);
		dbsession.conn(System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
	}
	//新建/修改/删除等按钮的点击。以参数WebElementName到数据库中取元素xpath定位表达式
	public UnitsetPage clickNMDbutton(String WebElementName){
		driver.findElement(By.xpath(dbsession.getLocatorXpath(WebElementName))).click();
		return this;
	}
	//勾选记录中第一行的值。没有第一行暂时不做处理，到时候再泡个异常。
	public UnitsetPage selectRecordone(String checkboxWename){
		WebElement checkbox= driver.findElement(By.xpath(dbsession.getLocatorXpath(checkboxWename)));
		checkbox.click();
		Assert.assertTrue(checkbox.isSelected());
		return this;
	}
	//鼠标悬停，展示修改或删除按钮
	public UnitsetPage MouseMove(String mousestayWE,String optWE){
		Actions actions= new Actions(driver);
		WebElement div_mouse_move =driver.findElement(By.xpath(dbsession.getLocatorXpath(mousestayWE)));
		WebElement opt= driver.findElement(By.xpath(dbsession.getLocatorXpath(optWE)));
		actions.moveToElement(div_mouse_move).build().perform();
		//perform moveToElement	
		//verify div_display_after_mouse_over is  displayed after moveToElement
		Assert.assertTrue(opt.isDisplayed());
		//opt.click();
		return this;
	}
	//元素输入框元素定位并输入值 WebElementName：输入框位置；inputMsn：要输入的值
	public UnitsetPage clearandsendkeys(String WebElementName,String inputMsn){
		WebElement inputbox =driver.findElement(By.xpath(dbsession.getLocatorXpath(WebElementName)));
		inputbox.sendKeys(inputMsn);
		return this;
	}
	
	//点击元素并等待界面中其他元素可见，可整体用于新增/修改
	public UnitsetPage clickandWait(String locatorname,String waitWename){
		driver.findElement(By.xpath(dbsession.getLocatorXpath(locatorname))).click();
		wait.waitForElementPresent(dbsession.getLocatorXpath(waitWename));
		Assert.assertEquals(driver.findElement(By.xpath(dbsession.getLocatorXpath(waitWename))).isDisplayed(), true);
		return this;
	}
	//确定或取消删除
	public UnitsetPage confirm(String delWe,Boolean ynflag){
		WebElement deletebutton =driver.findElement(By.xpath(dbsession.getLocatorXpath(delWe)));
		deletebutton.click();	
		//swith to confirm
		Alert confirm= driver.switchTo().alert();	
		//verify confirm msg
		//myModalLabel
		Assert.assertEquals(confirm.getText(), "提示：");
		//click ok on the confirm
		if(ynflag){
			confirm.accept();		
			WebElement yes = driver.findElement(By.id("confirmBtn"));
			Assert.assertEquals(yes.getText(), "确定");
			yes.click();
		}else{
			//cancle the confirm
			WebElement cancel = driver.findElement(By.id("closeBtn"));
			driver.switchTo().alert().dismiss();
			Assert.assertEquals(cancel.getText(), "取消");
			cancel.click();
		}
		return this;
	}
	//获取数据库中对应元素名称的元素，用于中转中转一些数据
	public WebElement getWbbyxpath(String WebElementName){
		return du.what(dbsession.getLocatorXpath(WebElementName));
}
	//获取数据库中元素名称对应的元素xpath表达式，用于中转一些数据
	public String getlocator(String WebElementName){
		return dbsession.getLocatorXpath(WebElementName);
	}

}
