package pagebuilder;

import org.openqa.selenium.NoSuchElementException;

public class CustomException extends NoSuchElementException{

	public CustomException(String args){
		super(args);
	}
	
	//................
	
}
