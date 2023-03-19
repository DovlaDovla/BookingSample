package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends BasePage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id=':Rp5:']")
    WebElement location;
    @FindBy(xpath = "//button[@data-testid='occupancy-config'] [@class='d47738b911']")
    WebElement adultChildRoom;
    @FindBy(xpath = "//*[@id='group_adults']//parent::div/div[2]/span")
    WebElement adults;
    @FindBy(xpath = "//*[@id='group_children']//parent::div/div[2]/span")
    WebElement child;
    @FindBy(xpath = "//*[@id='no_rooms']//parent::div/div[2]/span")
    WebElement room;
    @FindBy(xpath = "//div[@data-testid='availability-cta']/a/span")
    List<WebElement> seeAvailability;


    public void verifyLocation(String locationName) {
        String locationElTxt = getValue(location);
        Assert.assertEquals(locationElTxt, locationName);
    }

    public void verifyAdultChildRoom(String numAdults,String numChild,String numRooms) throws InterruptedException {
      clickElement(adultChildRoom);
      String adultsNum = getText(adults);
      String childNum =getText(child);
      String  roomNum=getText(room);

        Assert.assertEquals(adultsNum, numAdults);
        Assert.assertEquals(childNum, numChild);
        Assert.assertEquals(roomNum, numRooms);
    }

    public void clickFirstResult() throws InterruptedException {
           clickElement(seeAvailability.get(0));

    }

}