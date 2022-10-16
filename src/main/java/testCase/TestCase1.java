package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 {
    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-private");
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com ");
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));

    }

    @Test
    public void Test1(){
        System.out.println("test run");
        Assert.assertTrue(true);
    }
}
