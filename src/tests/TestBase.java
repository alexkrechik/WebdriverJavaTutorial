package tests;

import java.util.Properties;
import java.io.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pom.GoogleSearchPage;

public class TestBase {

    protected static WebDriver driver;
    private WebDriver dr;
    protected Properties Config = new Properties();
    protected GoogleSearchPage pageSearch;

    @BeforeTest
    public void SetUp() throws IOException {

        //Get config
        InputStream istream = new FileInputStream("src/selenium.properties");
        Config.load(istream);

        //Get driver
        GetDriver(Config.getProperty("driver"));
        long timeout = Long.parseLong(Config.getProperty("defaultTimeout"));

        //Set up our driver properties
        driver = new EventFiringWebDriver(dr);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Get our locators page
        pageSearch = PageFactory.initElements(driver, GoogleSearchPage.class);

    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }

    private void GetDriver(String name){

        if (name.equals("Firefox")) {
            dr = new FirefoxDriver();
            driver = dr;
        }

    }


}
