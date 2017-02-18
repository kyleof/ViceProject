package vice.test;

import org.testng.annotations.Test;

public class testClass {
	
	
  @Test
  public void thetest() {
	  
	  testPage page = new testPage();
	  page.openMenu();
	  page.openFollow();
	  page.checkColour();
	  page.closeMenu();
  }
}
