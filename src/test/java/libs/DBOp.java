package libs;


import java.sql.*;

//import org.sqlite.JDBC;


public class DBOp {
	
	private Statement stat = null;
	private ResultSet rsq   = null;
	private String tablename = null;
	
	public DBOp(String tablename){
		this.tablename = tablename;
	}
    
	public void conn(String db){
		try {
			Class.forName("org.sqlite.JDBC");
			//不加参数的：Connection conn = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:"+db);
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String  getLocatorXpath(String locatorname){
		String xpath = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				xpath = rsq.getString("Xpath");
				

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xpath;
	}
	
	
	public String getLocatorCSS(String locatorname){
		String css = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				
				css=rsq.getString("CSS");

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return css;
	}
	
	public String getWebelementValue(String locatorname){
		String value = null;
		try {
			rsq =stat.executeQuery("select * from "+tablename+" where WebElementName = '"+locatorname+"';");
			while (rsq.next()) { 

				
				value=rsq.getString("WebElementValue");

				}
				rsq.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static void main(String[] args) {
		DBOp test = new DBOp("LoginHomepage");
		test.conn(System.getProperty("user.dir")+"\\data\\mydatabase2.sqlite");
		System.out.println(test.getLocatorXpath( "oagh"));
		System.out.print(test.getLocatorCSS( "loginName"));
		
	}
	
	
	
}
