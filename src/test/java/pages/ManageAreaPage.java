package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pagebuilder.Wait;

public class ManageAreaPage {
	private WebDriver driver;
	Wait wait = new Wait(driver);
	@FindBy(xpath="//*[@id='contentArea']/section/div[2]/div[1]/div/div[1]/i[2]")
	private WebElement checkboxHeadaccount;
	
	@FindBy(xpath="//span[text()='新建']")
	private WebElement newManageArea;
	
	@FindBys(@FindBy(xpath="//label[text()='编码']/following-sibling::input|//label[text()='名称']/following-sibling::input"))
	private List<WebElement> codemessage;
	
	@FindBy(xpath="//div[text()='保存']")
	private WebElement areaSubmit;
	
	public ManageAreaPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
/*	public void setmanagearea(){
		checkboxHeadaccount.click();
		wait.waitFor(2);
		newManageArea.click();}*/
	public void choosecheckbox(){
		checkboxHeadaccount.click();
	}
	public void newarea(){
		newManageArea.click();
	}
	public void setAreaMessage(String codemsn){
		for(WebElement we:codemessage)
			we.sendKeys(codemsn);
	}
	public void areaSubmit(){
		areaSubmit.click();
	}
		
	
	
}
