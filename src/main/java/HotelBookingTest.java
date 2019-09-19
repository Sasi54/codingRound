import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extends TestBase{

   

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(name = "from")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() 
    {
       super.launchbrowser();
       PageFactory.initElements(driver, this);
        
        driver.get("https://www.cleartrip.com/");
        hotelLink.click();

       waitFor(2000);
       Actions act=new Actions(driver);
       act.moveToElement(localityTextBox).sendKeys("Indiranagar, Bangalore");
        //localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }

}
