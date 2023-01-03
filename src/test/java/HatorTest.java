import Hator.CartPage;
import Hator.MainPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static Hator.MainPage.HOME_PAGE_LINK;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;

public class HatorTest {

    @BeforeClass
    public static void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        Configuration.browserCapabilities = capabilities;
    }

    @Test
    public void chooseUSDCurrencyTest() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseUSDCurrency();
        mainPage.assertThatUSDCurrencyIsChosen();
    }

    @Test
    public void chooseUAHCurrencyTest() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseUAHCurrency();
        mainPage.assertThatUAHCurrencyIsChosen();
    }

    @Test
    public void chooseEURCurrencyTest() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseEURCurrency();
        mainPage.assertThatEURCurrencyIsChosen();
    }

    @Test
    public void chooseENLanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseENLanguage();
        mainPage.assertThatENLanguageIsChosen();
    }

    @Test
    public void chooseUALanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseUALanguage();
        mainPage.assertThatUALanguageIsChosen();
    }

    @Test
    public void chooseDELanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseDELanguage();
        mainPage.assertThatDELanguageIsChosen();
    }

    @Test
    public void choosePLLanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.choosePLLanguage();
        mainPage.assertThatPLLanguageIsChosen();
    }

    @Test
    public void userCanAddItemInCart() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.assertThatCartIsEmpty();
        mainPage.addToCartAvailableProduct();
        mainPage.assertThatCartContains1Item();
    }

    @Test
    public void userCanDeleteItemFromCart() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.addToCartAvailableProduct();
        mainPage.assertThatCartContains1Item();
        mainPage.cartButtonClick();

        CartPage cartPage = page(CartPage.class);

        cartPage.removeItemFromCart();
        mainPage.assertThatCartIsEmpty();
    }

    @Test
    public void userCanOpenHeadsetsCategoryWithENLanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);

        mainPage.chooseENLanguage();
        mainPage.headsetButtonClick();

        String expectedURL = "https://shop.hator.gg/headsets/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, currentUrl);
    }

    @Test
    public void userCanOpenKeyboardsCategoryWithENLanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);
        mainPage.chooseENLanguage();

        mainPage.keyboardButtonClick();

        String expectedURL = "https://shop.hator.gg/keyboards/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, currentUrl);
    }

    @Test
    public void userCanOpenMiceCategoryWithUALanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);
        mainPage.chooseUALanguage();

        mainPage.miceButtonClick();

        String expectedURL = "https://shop.hator.gg/ua/mice/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, currentUrl);
    }

    @Test
    public void userCanOpenSurfaceCategoryWithUALanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);
        mainPage.chooseUALanguage();

        mainPage.surfaceButtonClick();

        String expectedURL = "https://shop.hator.gg/ua/mousepads/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, currentUrl);
    }

    @Test
    public void userCanOpenAccessoriesCategoryWithDELanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);
        mainPage.chooseDELanguage();

        mainPage.accessoriesButtonClick();

        String expectedURL = "https://shop.hator.gg/de/accessories/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, currentUrl);
    }

    @Test
    public void userCanOpenChairsCategoryWithPLLanguage() {
        MainPage mainPage = open(HOME_PAGE_LINK, MainPage.class);
        mainPage.choosePLLanguage();

        mainPage.chairButtonClick();

        String expectedURL = "https://shop.hator.gg/pl/chairs/";
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedURL, currentUrl);
    }
}
