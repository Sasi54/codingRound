import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit' and contains(.,'Sign in')])")));
        driver.findElement(By.xpath("//dd[@class='submit']")).click();

        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        driver.quit();
    }

}
