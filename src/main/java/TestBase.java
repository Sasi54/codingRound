import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.sun.javafx.PlatformUtil;

public class TestBase 
{
	public WebDriver driver;
	
	public WebDriver launchbrowser()
	{
		 setDriverPath();
	        ChromeOptions options=new ChromeOptions();
	        Map<String, Object> prefs=new HashMap<String,Object>();
	        prefs.put("profile.default_content_setting_values.notifications", 1);
	        //1-Allow, 2-Block, 0-default
	        
	        options.setExperimentalOption("prefs",prefs);
	        driver = new ChromeDriver(options);
		return driver;
	}
	private void setDriverPath()
	{
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_77.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
	
	  public void waitFor(int durationInMilliSeconds) {
	        try {
	            Thread.sleep(durationInMilliSeconds);
	        } catch (InterruptedException e) {
	            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
	        }
	    }
	  
	  public boolean isElementPresent(By by) {
	        try {
	            driver.findElement(by);
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
}
