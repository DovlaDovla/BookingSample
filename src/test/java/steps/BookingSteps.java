package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.CommonMethods;
import pages.SearchResultPage;
import pages.StaysPage;
import tests.BaseTest;
import java.util.ArrayList;

public class BookingSteps extends BaseTest {
    @Before
    public void setUp() throws Exception {
        setUpTest("CHROME", "100", 30);

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        quite();
    }
    @Given("I navigate to Booking")
    public void iNavigateToBooking() throws Exception {
        startTestAplication("QA");
    }
    @When("I add location")
    public void iAddLocation() throws InterruptedException {
        StaysPage staysPage = new StaysPage(driver);
        staysPage.addLocation("Zlatibor");
    }
    @And("I add check in and check out dates")
    public void iAddCheckInAndCheckOutDates() throws InterruptedException {
        StaysPage staysPage = new StaysPage(driver);
        staysPage.checkInOut("2023-04-10", "2023-04-25");
    }



    @And("I add ccupancy information")
    public void iAddCcupancyInformation() throws InterruptedException {
        StaysPage staysPage = new StaysPage(driver);
        staysPage.addOccupancyInformation("4","0","2","3");
    }

    @And("I  click search")
    public void iClickSearch() throws InterruptedException {
        StaysPage staysPage = new StaysPage(driver);
        staysPage.clickSearch();
        Thread.sleep(1500);
    }

    @Then("I verify search criteria")
    public void iVerifySearchCriteria() throws InterruptedException {

        SearchResultPage searchResultPage =new SearchResultPage(driver);
        searchResultPage.verifyLocation("Zlatibor");
        searchResultPage.verifyAdultChildRoom("4","0","3");
       //Without Dates
    }

    @And("I see availability")
    public void iSeeAvailability() throws InterruptedException {
        SearchResultPage searchResultPage =new SearchResultPage(driver);
        searchResultPage.clickFirstResult();
    }

    @And("I verify availability information")
    public void iVerifyAvailabilityInformation() throws InterruptedException {

        ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        SearchResultPage searchResultPage =new SearchResultPage(driver);
        searchResultPage.verifyLocation("Zlatibor");
        searchResultPage.verifyAdultChildRoom("4","0","3");

       // driver.switchTo().window(tabs.get(0));
    }
           //Frame example
    @Given("I open url")
    public void iOpenUrl() {
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
    }

    @And("I click insaide iframe")
    public void iClickInsaideIframe() throws InterruptedException {
        CommonMethods commonMethods=new CommonMethods(driver);
        commonMethods.scrollDownPixel("200");
        //pop-up problem
        Thread.sleep(3000);
        driver.switchTo().frame(driver.findElement(By.cssSelector("[title='W3Schools HTML Tutorial']")));
        commonMethods.clickElement(driver.findElement(By.xpath("//*[@title='Java Tutorial']")));
        //driver.switchTo().defaultContent();
    }
}
