package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StaysPage extends BasePage {
    WebDriver driver;

    public StaysPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id=':Ra9:']")
    WebElement location;
    @FindBy(xpath = "//button[@data-testid='date-display-field-end']")
    List<WebElement> dates;
    @FindBy(xpath = "//button[@data-testid='occupancy-config']")
    WebElement guestCount;
    @FindBy(xpath = "//*[@id=\'indexsearch\']/div[2]/div/div/form/div[1]/div[3]/div/div/div/button")
    WebElement done;
    @FindBy(xpath = "//span[@class='b6dc9a9e69 e25355d3ee']")
    WebElement minAdult;
    @FindBy(xpath = "//*[@id=\'indexsearch\']/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[1]/div[2]/button[2]")
    WebElement maxAdult;
    @FindBy(xpath = "//button[@type='submit']/span[@class='e57ffa4eb5']")
    WebElement search;

    public void addLocation(String locPlase) throws InterruptedException {
        typeText(location, locPlase);
    }


    public void checkInOut(String checkIn, String checkOut) throws InterruptedException {

        //ostalo ne dovrseno
        clickElement(dates.get(0));

        clickElement(driver.findElement(By.xpath("//span[@data-date='" + checkIn + "']")));
        clickElement(driver.findElement(By.xpath("//span[@data-date='" + checkOut + "']")));
    }

    public void addOccupancyInformation(String adultcNum,String childNum,String childAge,String roomNum) throws InterruptedException {

        clickElement(guestCount);
        Thread.sleep(1000);
       aadAdults(adultcNum);
       addChildren(childNum,childAge);
       addRooms(roomNum);
       clickElement(done);
    }

    public void aadAdults(String numAdults) throws InterruptedException {
        if (numAdults.equals("2")) {
            // Do nothing
        } else if (Integer.parseInt(numAdults) < 2) {
                // click minus
           clickElement(minAdult);
        } else {
            // click plus
            for (int i = 3; i <= Integer.parseInt(numAdults); i++) {
             clickElement(maxAdult);
            }
        }
    }

    public void addChildren(String childNum,String childAge) throws InterruptedException {

        if (childNum.equals("0")) {
            // Do nothing
        } else if (Integer.parseInt(childNum) < 2) {
      /*      clickElement(driver.findElement(By.xpath("//*[@id=\'indexsearch\']/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[2]/div[2]/button[2]")));
            Thread.sleep(1000);
            selectByValue(driver.findElement(By.cssSelector(" #\\:rm\\: > option:nth-child(1)")),childAge );
         */
        } else {

            for (int i = 2; i <= Integer.parseInt(childNum); i++) {
                    System.out.println("not done for 2 and more children");
            }
        }

    }

    public void addRooms(String numRooms) throws InterruptedException {

        for(int i=1;i < Integer.parseInt(numRooms);i++){
            clickElement(driver.findElement(By.xpath("//*[@id=\'indexsearch\']/div[2]/div/div/form/div[1]/div[3]/div/div/div/div/div[3]/div[2]/button[2]")));
        }

    }

    public void clickSearch() throws InterruptedException {

    clickElement(search);

    }

}
