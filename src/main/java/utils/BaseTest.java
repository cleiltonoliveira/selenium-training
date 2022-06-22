package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static utils.Browser.getCurrentDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    @BeforeAll
    public void startTest() {
        getCurrentDriver();
    }

    public String  getCurrentUrl(){
        return  getCurrentDriver().getCurrentUrl();
    }
}
