package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearchPage {

    @FindBy ( name = "q")
    public WebElement inputSearch;

    @FindBy ( name = "btnG")
    public WebElement btnSearch;

    @FindBy( xpath = "//h3[@class='r']//a")
    public WebElement txtFirstHeader;

    public void searchFor (String text) {
        inputSearch.sendKeys(text);
        btnSearch.click();
    }

}
