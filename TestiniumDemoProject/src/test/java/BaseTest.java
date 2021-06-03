
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    protected WebDriver driver ;
    PracticeFormPage practiceFormPage ;

    Search search ;
    Basket basket ;

    @BeforeAll
    public void setUp(){
      System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, SECONDS);
      driver.manage().timeouts().pageLoadTimeout(200, SECONDS);
      driver.manage().window().maximize();
      Log4j.startLog("Test otomasyonu başlatılıyor.");
      CheckControls.checkPageOpen(driver);
      practiceFormPage = new PracticeFormPage(driver);
      search = new Search(driver);
      basket = new Basket(driver);
    }

    @AfterAll
    public void tearDown () {
        Log4j.endLog("Test bitti");
        driver.quit();
    }
}
