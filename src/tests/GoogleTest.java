package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;


public class GoogleTest {

    public static void main(String[] args) {

        //Create new Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Set implicitly Wait for webdriver - we will wait 30 second for each element appear
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Go to the Google home page
        driver.get("http://www.google.com");

        // Enter the query string "Cheese"
        WebElement inputSearch = driver.findElement(By.name("q"));
        inputSearch.sendKeys("Hello World");

        //Press on "Search" button
        WebElement btnSearch = driver.findElement(By.name("btnG"));
        btnSearch.click();

        //Check, that first search result header contains "world" word
        WebElement txtFirstHeader = driver.findElement(By.xpath("//h3[@class='r']//a"));
        assertTrue(txtFirstHeader.getText().toLowerCase().contains("world"));

        //Close driver
        driver.close();


    }
}