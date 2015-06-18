package tests.search;

import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pom.*;
import tests.*;

public class GoogleTest {

    public static void main(String[] args) {
        //Create New Test Base object
        TestBase testBase = new TestBase();

        //Create new Firefox driver
        WebDriver driver = testBase.GetCurrentDriver();

        //Create Google search page using PageFactory
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        //Set implicitly Wait for webdriver - wi will wait 30 second for element appear
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Open google.com
        driver.get("http://google.com");

        // Search for "Hello World"
        page.searchFor("Hello World");

        assertTrue(page.txtFirstHeader.getText().toLowerCase().contains("world"));

        //Close driver
        testBase.TearDown();


    }
}