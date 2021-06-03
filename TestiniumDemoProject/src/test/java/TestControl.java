
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestControl extends BaseTest{

    public static String username = "knkarci";
    public static String password = "gods0019";
    public static String searchText = "bilgisayar";

    Boolean pass, mail = false;

    @Test
    @Order(1)
    public void setEmailTest() {
        practiceFormPage.setEmail(username);
        Assertions.assertEquals(username, PracticeFormPage.getUsername(), "Girilen ve girilmek istenen kullanıcı adı aynı değil!");
        mail = true;
    }

    @Test
    @Order(2)
    public void setPasswordTest() {
       practiceFormPage.setPassword(password);
       Assertions.assertEquals(password, PracticeFormPage.getPassword(), "Girilen ve girilmek istenen şifre aynı değil!");
       pass = true;
    }

    @Test
    @Order(3)
    public void loginTest(){
        if (mail && pass){
            Log4j.info("Giriş yapılıyor.");
            PracticeFormPage.loginButton();
            Log4j.info("Giriş yapıldı.");

        }
        else {
            Log4j.info("Giriş yapılamadı.");
        }
    }

    @Test
    @Order(4)
    public void searchTest(){
        Search.setSearchText(searchText);
        Assertions.assertEquals(searchText, Search.getSearchText(), "Geçersiz kelime girişi!");
        Log4j.info("Aranan ürün: "+ searchText);
    }

    @Test
    @Order(5)
    public void searchButtonTest(){
        Search.searchButton();
        Log4j.info("Ürün aranıyor.");
    }

    @Test
    @Order(6)
    public void secondPageTest(){
        Log4j.info("2. sayfa açılıyor..");
        Search.secondPage();
    }

    @Test
    @Order(7)
    public void secondPageControlTest(){
        Log4j.info("2. sayfa açıldı");
        CheckControls.checkSecondPageOpen(driver);
    }

    @Test
    @Order(8)
    public void selectProductTest(){
        Log4j.info("Ürün seçimi yapılıyor.");
        Search.selectProduct();
    }

    @Test
    @Order(9)
    public void addBasketTest(){
        Basket.addBasket();
        Log4j.info("Ürün sepete eklendi.");
    }

    @Test
    @Order(10)
    public void comparePriceTest(){

        String pagePrice = Search.getProductPricePage();
        String basketPrice = Basket.getBasketPrice();
        if(basketPrice.equals(pagePrice)){
            Log4j.info("Fiyatlar eşit. Ürün Fiyatı= " + pagePrice);
        }
        else {
            Log4j.info("Fiyatlar eşit değildir!. Sepette olan fiyat: "+ basketPrice + "Kontrol edilen fiyat: "+ pagePrice);
        }
    }

    @Test
    @Order(11)
    public void goBasketTest(){
          Log4j.info("Sepete giriş yapılıyor.");
        Basket.inBasket();
    }

    @Test
    @Order(12)
    public void increaseProductTest(){
           Log4j.info("Ürün sayısı arttırılıyor.");
        Basket.upItem();

    }

    @Test
    @Order(13)
    public void productCountTest(){
        Log4j.info("Ürün sayısı kontrolü başlatıldı.");
        Basket.itemCount();
    }

    @Test
    @Order(14)
    public void deleteProductTest(){
        Log4j.info("Sepetten silme işlemi başlatıldı.");
        Basket.deleteItem();
    }

    @Test
    @Order(15)
    public void checkBasketTest(){
        Log4j.info("Sepet kontrolü başlatıldı.");
        CheckControls.checkBasket(driver);
    }
}
