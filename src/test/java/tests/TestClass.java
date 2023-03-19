package tests;

import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Optional;


public class TestClass extends BaseTest {


    @BeforeMethod
    // @Parameters
    // ({"BROWSER","BROWSER_VERSION","WAIT","ENV"})


    public void setUp() throws Exception {
        setUpTest("CHROME", "100", 30);
        startTestAplication("QA");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        quite();
    }

    @Test
    @Description("Opis testa")
    public void test()  {

        System.out.println("Run test from suite in Runner.xml file");
    }


}
