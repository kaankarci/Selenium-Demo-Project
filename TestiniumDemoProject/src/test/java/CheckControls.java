
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CheckControls  {


    private static final By checkBasket =  By.cssSelector("div[class='product-group-box']");



    public static void checkPageOpen(WebDriver driver) {
        driver.get("https://www.gittigidiyor.com/");
        String expectedTitle = "GittiGidiyor";
        if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
            Log4j.info("www.gittigidiyor.com sayfası açıldı");
            driver.get("https://www.gittigidiyor.com/uye-girisi");
        }
        else{
            Log4j.info("Sayfa açılmadı!");
            driver.quit();
        }
    }

    public static void checkSecondPageOpen(WebDriver driver) {
        String expectedTitle = "Bilgisayar - GittiGidiyor - 2/100";
        if(driver.getTitle() != null && driver.getTitle().contains(expectedTitle)){
            Log4j.info("2. Sayfa açılmıştır.");
        }
        else{
            Log4j.info("2. Sayfa açılmadı!");
            driver.quit();
        }
    }

    public static void checkBasket(WebDriver driver) {
        WebElement nameSpace = driver.findElement(checkBasket);
        String value =  nameSpace.getAttribute("value");
        if(value == null || value.isEmpty()) {
              Log4j.info("Sepet boştur.");
        } else {
            Log4j.info("Sepet boş değildir!");
        }
    }
}
