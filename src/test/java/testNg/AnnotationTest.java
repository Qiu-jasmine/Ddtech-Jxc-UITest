package testNg;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {
  @Test
  public void testcase1() {
	  System.out.println("testcase1 is working");  
  }
  @Test
  public void testcase2() {
	  System.out.println("testcase2 is working");  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("worked before testcases");
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("在当前测试类的第一个测试方法开始调用前执行");  
  }
  @BeforeTest
  public void beforeTest() {
	  System.out.println("在测试类的test开始前执行");  
  }
  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("在当前测试集合中的所有测试程序开始执行之前执行");  
  }
  
}
