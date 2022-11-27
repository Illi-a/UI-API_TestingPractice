package Hator;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends CurrencyAndLanguageDropDownMenus {

    public static final String HOME_PAGE_LINK  = "https://shop.hator.gg/";

    @FindBy (how = How.CSS, using = "[alt ='HATOR Shop logo']")
    SelenideElement HomePageButton;

    @FindBy (how = How.XPATH, using = ".//img [@src = 'https://shop.hator.gg/wp-content/uploads/2020/07/headsets.png']")
    SelenideElement headsetCategoryButton;

    @FindBy (how = How.XPATH, using = ".//img [@src = 'https://shop.hator.gg/wp-content/uploads/2020/07/ketboards.png']")
    SelenideElement keyboardCategoryButton;

    @FindBy (how = How.XPATH, using = ".//img [@src = 'https://shop.hator.gg/wp-content/uploads/2020/07/mice.png']")
    SelenideElement miceCategoryButton;

    @FindBy (how = How.XPATH, using = ".//img [@src = 'https://shop.hator.gg/wp-content/uploads/2020/07/surfaces.png']")
    SelenideElement surfaceCategoryButton;

    @FindBy (how = How.XPATH, using = ".//img [@src = 'https://shop.hator.gg/wp-content/uploads/2020/07/accessories.png']")
    SelenideElement accessoriesCategoryButton;

    @FindBy (how = How.XPATH, using = ".//img [@src = 'https://shop.hator.gg/wp-content/uploads/2020/07/chairs.png']")
    SelenideElement chairCategoryButton;



    @FindBy (how = How.XPATH, using = ".//a [@class = 'button product_type_simple add_to_cart_button ajax_add_to_cart']")
    SelenideElement addToCartAvailableProduct;





    public void headsetButtonClick(){
        headsetCategoryButton.click();
    }

    public void keyboardButtonClick(){
        keyboardCategoryButton.click();
    }

    public void miceButtonClick(){
        miceCategoryButton.click();
    }

    public void surfaceButtonClick(){
        surfaceCategoryButton.click();
    }

    public void accessoriesButtonClick(){
        accessoriesCategoryButton.click();
    }

    public void chairButtonClick(){
        chairCategoryButton.click();
    }

    public void addToCartAvailableProduct(){
        addToCartAvailableProduct.click();
    }
}
