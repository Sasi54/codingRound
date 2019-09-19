import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class FlightBookingTest extends TestBase{

    @Test
    public void testThatResultsAppearForAOneWayJourney() {      
        super.launchbrowser();
        driver.get("https://www.cleartrip.com/");
        waitFor(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, 15);
        
        driver.findElement(By.id("OneWay")).click();

       
        WebElement from=driver.findElement(By.id("FromTag"));
        from.clear();
        from.sendKeys("Bangalore");
     
        //wait for the auto complete options to appear for the origin
        waitFor(5000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        wait.until(ExpectedConditions.visibilityOf(originOptions.get(0))); 
        originOptions.get(0).click();

        WebElement to=driver.findElement(By.id("ToTag"));
        to.clear();
        to.sendKeys("Delhi");

        //wait for the auto complete options to appear for the destination
        waitFor(5000);
        //select the first item from the destination auto complete list
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();

        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']")).click();
        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[4]/a")).click();

        //all fields filled in. Now click on search
        driver.findElement(By.id("SearchBtn")).click();

        waitFor(5000);
        //verify that result appears for the provided journey search
        Assert.assertTrue(isElementPresent(By.className("searchSummary")));

        //close the browser
        driver.quit();

    }	
}
