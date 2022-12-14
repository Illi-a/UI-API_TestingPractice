package Hator;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage extends CurrencyAndLanguageDropDownMenus {
    @FindBy(how = How.CSS, using = "[alt = 'Магазин HATOR логотип']")
    SelenideElement homeButton;

    @FindBy(how = How.CLASS_NAME, using = "remove")
    SelenideElement removeItemFromCartButton;


    public void removeItemFromCart() {
        removeItemFromCartButton.click();
    }


}
