package testNg;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestNgcase {
  @Test
  public void testcase() {
	  String str="Hello here is TestNg";
	  	assertEquals("Hello here is TestNg",str);
  }
}
