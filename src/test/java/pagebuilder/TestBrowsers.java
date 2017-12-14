package pagebuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
public class TestBrowsers{
	private WebDriver driver;
	//private APIObject testlinkapi;
	//private String caseName;
	String baseUrl ="http://test2.diandianwaimai.com:6030";
	String ZMchid = "10068";
	String ZUser ="admin";
	String passwd ="admin";
	@BeforeClass
	public void beforeClass(){
		//String url = "http://localhost/testlink/testlink-1.9.3/lib/api/xmlrpc.php";
		/*String url = "http://test2.diandianwaimai.com:6030/";
		String devKey ="admin";
		String projectName ="dddmTest";
		String t1="webdriverLesson";
		String buildName="build001";
		String platform = "IE";*/
		
	 //   testlinkapi = new APIObject(url,devKey,projectName,t1,buildName,platform);
		Browsers browser=new Browsers(BrowsersType.chrome);
		driver = browser.driver;
	}
	@Test
	public void start(){
		//caseName = "DoOne";
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
	}
	/*@AfterMethod
	public void import2TestLink(ITestResult res){
		testlinkapi.getAPI();
		testlinkapi.getTestCases();
		testlinkapi.executeTestCase(caseName,res.getStatus(),"Luter does!");
	}*/
	@AfterClass
	public void quit(){
		driver.quit();
	}
}
