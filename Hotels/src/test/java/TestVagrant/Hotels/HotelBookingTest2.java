package TestVagrant.Hotels;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HotelBookingTest2 extends DriverPath  {

    protected WebDriver driver;

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
   
        
  @BeforeClass
  public void initialize(){
	  DriverPath.setDriverPath();
	  driver = new ChromeDriver();
	  PageFactory.initElements(driver,this);
  }
  
    @Test
    public void shouldBeAbleToSearchForHotels() {
    	
    	driver.get("https://www.cleartrip.com/");
        waitFor(5000);
        hotelLink.click();
        waitFor(5000);
        
        localityTextBox.sendKeys("Indiranagar, Bangalore");

        new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        searchButton.click();

        driver.quit();

    }
       
}
