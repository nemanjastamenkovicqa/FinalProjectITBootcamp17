package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Base {
    public CartPage(){PageFactory.initElements(driver, this);}

    @FindBy(id = "checkout")
    WebElement checkoutBtn;
    @FindBy(id = "continue-shopping")
    WebElement continueShopingBtn;
    //@FindBy(className = "inventory_item_name")
    //WebElement inventoryItemName;
    @FindBy(className = "shopping_cart_badge")
    WebElement shopingCartBadge;

// -   -   -   -   -   -   -
    public void clickOnCheckoutBtn(){
        checkoutBtn.click();
    }








}
