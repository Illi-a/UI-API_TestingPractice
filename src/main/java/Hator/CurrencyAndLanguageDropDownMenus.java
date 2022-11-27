package Hator;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class CurrencyAndLanguageDropDownMenus extends CartButtonAndCount {

    @FindBy(how = How.CLASS_NAME, using = "currencys")
    SelenideElement currencyChangeDropDownMenu;

    @FindBy (how = How.XPATH, using = ".//div[@class = 'currencys lang']")
    SelenideElement languageChangeDropDownMenu;

    public void chooseUALanguage(){
        languageChangeDropDownMenu.click();
        $(new ByText("UA")).click();
    }

    public void chooseENLanguage(){
        languageChangeDropDownMenu.click();
        $(new ByText("EN")).click();
    }

    public void chooseDELanguage(){
        languageChangeDropDownMenu.click();
        $(new ByText("DE")).click();
    }

    public void choosePLLanguage(){
        languageChangeDropDownMenu.click();
        $(new ByText("PL")).click();
    }

    public void assertThatUALanguageIsChosen(){
        $(By.xpath(".//span[@data-language = 'ua']")).shouldBe(visible);
        $(new ByText("Гарнітури")).click();
    }

    public void assertThatENLanguageIsChosen(){
        $(By.xpath(".//span[@data-language = 'en']")).shouldBe(visible);
        $(new ByText("Headsets")).click();
    }

    public void assertThatDELanguageIsChosen(){
        $(By.xpath(".//span[@data-language = 'de']")).shouldBe(visible);
        $(new ByText("Kopfhörer")).click();
    }

    public void assertThatPLLanguageIsChosen(){
        $(By.xpath(".//span[@data-language = 'pl']")).shouldBe(visible);
        $(new ByText("Zestawy słuchawkowe do gier")).click();
    }

    public void chooseUSDCurrency(){
        currencyChangeDropDownMenu.click();
        $(new ByText("USD")).click();
    }

    public void chooseUAHCurrency(){
        currencyChangeDropDownMenu.click();
        $(new ByText("UAH")).click();
    }

    public void chooseEURCurrency(){
        currencyChangeDropDownMenu.click();
        $(new ByText("EUR")).click();
    }

    public void assertThatUSDCurrencyIsChosen() {
        $(By.xpath(".//span[@class = 'dropItem']")).shouldHave(text("USD"));
    }

    public void assertThatUAHCurrencyIsChosen() {
        $(By.xpath(".//span[@class = 'dropItem']")).shouldHave(text("UAH"));
    }

    public void assertThatEURCurrencyIsChosen() {
        $(By.xpath(".//span[@class = 'dropItem']")).shouldHave(text("EUR"));
    }





}
