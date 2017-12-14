package pagebuilder;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Browsers {
	public WebDriver driver =null;
	private FirefoxProfile firefoxprofile = null;
	private static DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	public Browsers(BrowsersType browserstype){
	switch(browserstype){	
		case firefox:
			File firebug = new File(projectpath+"/tool/firebug.xpi");
			File firepath = new File(projectpath+"/tool/FireXPath.xpi");
			firefoxprofile = new FirefoxProfile();
			try{
				firefoxprofile.addExtension(firebug);
				firefoxprofile.addExtension(firepath);
				firefoxprofile.setPreference("webdriver.accept.untrusted.certs", true);
				firefoxprofile.setPreference("extensions.firebug.currentVersion", "2.0.19");
				//代理
				//firefoxprofile.setPreference("network.proxy.type", 0);
				//firefoxprofile.setPreference("network.proxy.http", "10.1.1.0");
				//firefoxprofile.setPreference("network.proxy.http_port", 3128);
			}catch(IOException e){
				e.printStackTrace();
			}
			driver = new FirefoxDriver(firefoxprofile);
			driver.manage().window().maximize();
			break;
		case ie:
			System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer_x64_2.53.1.exe");
			caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,false);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");	
			caps.setCapability("ignoreZoomSetting", true);
			driver = new InternetExplorerDriver(caps);
			driver.manage().window().maximize();
			break;
			
		case chrome:
			System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver1.exe");
			caps = DesiredCapabilities.chrome();
			caps.setCapability( "chrome.switches",Arrays.asList("--start-maximized"));	
			driver = new ChromeDriver(caps);
			//driver.manage().window().maximize();
			break;		
			
		}
	}
	
}
