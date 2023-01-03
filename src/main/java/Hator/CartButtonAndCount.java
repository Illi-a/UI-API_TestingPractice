package Hator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class CartButtonAndCount {

    @FindBy(how = How.CSS, using = ("[class = 'c-customlocation']"))
    SelenideElement cartButton;

    @FindBy(how = How.CSS, using = ("[class = 'customCart 222']"))
    SelenideElement cartCount;

    public void cartButtonClick() {
        cartButton.click();
    }

    public void assertThatCartContains1Item() {
        cartCount.shouldHave(Condition.text("1"));
    }

    public void assertThatCartIsEmpty() {
        cartCount.shouldHave(Condition.text("0"));
    }
}
