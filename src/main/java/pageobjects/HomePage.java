package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseActionElement;
import utils.Browser;

public class HomePage extends BaseActionElement {

    @FindBy(xpath = "//a[contains(text(),'Sign in') and @class=\"login\"]")
    public WebElement signin;

    @FindBy(id = "search_query_top")
    public WebElement search_query_top;

    @FindBy(name = "submit_search")
    public WebElement submit_search;

    public HomePage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void clickmenuLogin() {
        signin.click();
    }
}
