package Hator;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public abstract class CartButtonAndCount {

    @FindBy (how = How.XPATH, using = (".//a [@class='c-customlocation']"))
    SelenideElement cartButton;

    @FindBy (how = How.XPATH, using = (".//span [@class='cartCount']"))
    SelenideElement cartCount;

    public void cartButtonClick(){
        cartButton.click();
    }

    public void assertThatCartContains1Item(){
        cartCount.shouldHave(Condition.text("1"));
    }

    public void assertThatCartContains2Item(){
        cartCount.shouldHave(Condition.text("2"));
    }

    public void assertThatCartContains3Item(){
        cartCount.shouldHave(Condition.text("3"));
    }

    public void assertThatCartIsEmpty(){
        cartCount.shouldHave(Condition.text("0"));
    }



}
