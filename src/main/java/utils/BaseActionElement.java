package utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class BaseActionElement {

    public boolean isElementExisting(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch ( NoSuchElementException e){
            return false;
        }
    }
}
