package libs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class TestCSVdemo {
	private String filePath;
	private String nextLine[];
	List<String[]> approvalList = new ArrayList<String[]>();
	CSVReader reader;	
	private String value;	
	public TestCSVdemo(String filepath){
		this.filePath = filepath;
	}	
	public String getTestData(String columnName,String lineName){
		try {
			reader = new CSVReader(new FileReader(filePath));
			try {
				while ((nextLine= reader.readNext())!=null){
					approvalList.add(nextLine);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int count = 0;
			int index = 0;
			for(String j:approvalList.get(0)){
				count++;
				if(j.equals(columnName)){
					index = count-1;
				}
			}
			for (String[] i : approvalList){
				if(i[0].equals(lineName))
					value = i[index].toString();
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return value;
	}
	
	public static void main(String[] args){
		TestCSVdemo a = new TestCSVdemo(System.getProperty("user.dir")+"\\data\\userinfo.csv");
/*		for(int i=1;i<=3;i++){
			System.out.println(a.getTestData("username", "tc"+i)+","+a.getTestData("Url", "tc"+i));
		}*/
		System.out.println(a.getTestData("username", "tc2"));
	}
}
