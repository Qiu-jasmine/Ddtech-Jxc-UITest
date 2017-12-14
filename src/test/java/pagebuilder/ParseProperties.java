package pagebuilder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ParseProperties {
	private Properties pro = new Properties();
	String value = null;
	
	public ParseProperties(String propertiespath) throws IOException{
		 this.loadProperties(propertiespath);
	 }
	 
	 private void loadProperties(String propertiespath) throws IOException{
		 
		 try {
			InputStream in = new FileInputStream(propertiespath);
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(inr);
			pro.load(br);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	 public String getValue(String keyname){
		 value = pro.getProperty(keyname).trim();		 
		 try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return value;
	 }
	 
/*	 public String getValue(String ffwb){
		 value = pro.getProperty(ffwb);		 
		 try {
			value = new String(value.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return value;
	 }
	*/
	 public static void main(String[] args) throws IOException{
		 ParseProperties a = new ParseProperties(System.getProperty("user.dir")+"/tool/test.properties");
		// ParseProperties a = new ParseProperties("D:\\eclipseworkplace\\learnS\\tool\\test.properties");
		 System.out.println(a.getValue("ZMchid"));
	 }
}
