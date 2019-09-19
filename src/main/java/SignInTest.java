import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInTest extends TestBase{
    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {    
        super.launchbrowser();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        driver.manage().window().maximize();
        
        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        
        waitFor(2000);
      
        driver.switchTo().frame("modal_window");       
        WebElement element = driver.findElement(By.id("signInButton"));
        element.click();
        		
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

}
