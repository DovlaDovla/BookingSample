package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {
   public WebDriver driver;
    DriverManager driverManager;

  public void setUpTest(String browser,String version,int waitTime) throws Exception {

      driverManager = DriverManagerFactory.getDriverManager(browser);
      driver = driverManager.getWebDriver(version);
      driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);


  }
    public  void quite(){

        driverManager.quitWebDriver();
    }

  public  void takeScreenshot(String fileName) throws IOException {

      File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(file,new File("screenshoots/"+fileName+".png"));
  }
  public  void reportScreenshot(String fileName,String desc) throws IOException {
          takeScreenshot(fileName);
      Path content= Paths.get("screenshoots/"+fileName+".png");
      try(InputStream is= Files.newInputStream(content)) {
          Allure.addAttachment(desc,is);
      }catch (IOException e){
         e.printStackTrace();
      }
    }

    public  void startTestAplication(String env) throws Exception {
      switch (env){
          case"QA":{
           driver.get("https://booking.com/");
          }break;
          case"STG":{
              driver.get(" https://booking.com/");
          }break;
          case"PROD":{
              driver.get(" https://booking.com/");
          }break;

          default:throw new Exception("ENV: "+env+" Not supported!");



      }

    }

}
