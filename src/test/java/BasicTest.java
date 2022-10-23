import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import page.ActionOnPage.ActionOnPage;

public class BasicTest {
    protected WebDriver driver=ActionOnPage.initWebDriver();
    @BeforeTest
    void setUp(){

    }
    @AfterSuite
    void tearsDown(){
        driver.quit();
    }




}
