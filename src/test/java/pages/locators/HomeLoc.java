package pages.locators;

public interface HomeLoc {
	String merchantId ="input[placeholder='商户号']";
	String	loginName = "input[placeholder='工号']";
	String	passwd ="input[placeholder='密码']";
	String loginbutton="login-buttom";
	String oagh="//span[contains(text(),'admin')]";
	String oagh1="//span[contains(text(),'%1$s')]";
	//String.format("//span[contains(text(),'%2$s 打印出 %1$s')]","admin","haha")
	////span[contains(text(),'haha 打印出 admin')]
}
