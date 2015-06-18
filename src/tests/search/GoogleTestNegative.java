package tests.search;

import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;
import tests.*;


public class GoogleTestNegative extends TestBase{

    @Test
    public void NegativeSearch() {
        driver.get(Config.getProperty("url"));
        pageSearch.searchFor("This is Sparta");
        assertTrue(pageSearch.txtFirstHeader.getText().toLowerCase().contains("world"));
    }

}