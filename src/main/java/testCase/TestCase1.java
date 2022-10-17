package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.PageAbout;
import page.PageStart;

import java.time.Duration;

public class TestCase1 {
    WebDriver driver;
    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-private");
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com ");
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));

    }

    @Test
    public void Test1(){
        PageStart ps=new PageStart(driver);
        ps.clickButtonABOUT();
        System.out.println("test run");
        String actualTittle=ps.driver.getTitle();
        Assert.assertEquals(actualTittle,"Steam — превосходная игровая Интернет-платформа");
        PageAbout pageAbout=new PageAbout(driver);

    }
}
