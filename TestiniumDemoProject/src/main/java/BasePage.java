import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected static WebDriver driver;  //child classların da kullanabilmesi için protected
    String baseUrl ="https://www.gittigidiyor.com";

    public  BasePage(WebDriver driver){
        this.driver=driver;
    }

    public static WebElement find(By locator){
        return driver.findElement(locator);
    }
    public static void clickItem(By locator){
        find(locator).click();
    }
    public void write(By locator, String type){
        find(locator).sendKeys(type);
    }
}
