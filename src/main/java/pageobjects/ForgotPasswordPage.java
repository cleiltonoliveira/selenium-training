package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseActionElement;
import utils.Browser;

public class ForgotPasswordPage extends BaseActionElement {

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button")
    public WebElement retrievePasswordBtn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/p")
    public WebElement messageLabel;

    public ForgotPasswordPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void clickRetrievePasswordBtn() {
        retrievePasswordBtn.click();
    }

    public void sendKeysToEmailInput(String value) {
        emailInput.sendKeys(value);
    }

    public boolean messageLabelHasMessage(String message) {
        return messageLabel.getText().contains(message);
    }
}
