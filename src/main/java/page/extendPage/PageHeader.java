package page.extendPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.ActionOnPage.ActionOnPage;

public class PageHeader {
    WebDriver driver;


    public PageHeader(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[contains(text(),'МАГАЗИН')]")
    private WebElement buttonStore;

    @FindBy(xpath="//*[@id='noteworthy_tab']/span")
    private WebElement newAndNoteworthy;

    @FindBy(xpath="//*[@class='tab  flyout_tab focus ']")
    private WebElement isVisiblyMenu;

    @FindBy(xpath = "//a[contains(text(),'Лидеры продаж')][1]")
    private WebElement buttonTopSellers;



    public void goMainPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(buttonStore)
                .click()
                .build()
                .perform();

    }
    public void hoverCursorToNew(){
        Actions actions=new Actions(driver);
        actions.moveToElement(newAndNoteworthy).build().perform();
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions
//                .presenceOfElementLocated(By.xpath("//*[@class='tab  flyout_tab focus ']")));
//        System.out.println("@&^(#Q!");
    }
    public void selectTopSellers(){
        ActionOnPage.selectItem(buttonTopSellers);
    }

}
