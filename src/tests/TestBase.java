package tests;

import java.util.Properties;
import java.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

    protected static WebDriver driver;
    private WebDriver dr;
    private Properties Config = new Properties();

    public WebDriver GetCurrentDriver()   {

        try {

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("selenium.properties");
            Config.load(inputStream);
            GetDriver(Config.getProperty("driver"));
        } catch (IOException e) {
            GetDriver("Firefox");
        }
        return dr;
    }

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
