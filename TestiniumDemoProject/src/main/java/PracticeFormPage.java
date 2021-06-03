import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticeFormPage extends BasePage {


    private static final By username = By.id("L-UserNameField");
    private static final By password = By.id("L-PasswordField");
    private static final By button = By.id("gg-login-enter");


    public PracticeFormPage(WebDriver driver){
        super(driver);
        driver.get(baseUrl+"/uye-girisi");
    }


    public void setEmail(String usernameText) {
        write(username,usernameText);
    }

    public void setPassword(String passwordText) {
        write(password,passwordText);
    }

    public static String getUsername(){
        return find(username).getAttribute("value");
    }
    public static String getPassword(){
        return find(password).getAttribute("value");
    }

    public static void loginButton() {
        clickItem(button);
    }

}
