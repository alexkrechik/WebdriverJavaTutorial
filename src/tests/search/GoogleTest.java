package tests.search;

import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import tests.*;


public class GoogleTest extends TestBase{

    @Test
    public void PositiveSearch() {
        driver.get(Config.getProperty("url"));
        pageSearch.searchFor("Hello World");
        assertTrue(pageSearch.txtFirstHeader.getText().toLowerCase().contains("world"));
    }

}