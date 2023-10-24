package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InventoryPage extends Base {

    public InventoryPage(){PageFactory.initElements(driver, this);}

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addBtnSauceLabsBackpack;
        @FindBy(id = "remove-sauce-labs-backpack")
        public WebElement removeBtnSauceLabsBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBtnSauceLabsBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addBtnSauceLabsBoltTShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addBtnSauceLabsFleeceJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement addBtnSauceLabsOnesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    WebElement addBtnRedTshirtTest;

    @FindBy(id = "shopping_cart_container")
    public WebElement shopingCartIcon;
    @FindBy(className = "shopping_cart_badge")
    public WebElement shopingCartBage;


    @FindBy(className = "active_option")
    public WebElement activeOptionSortContainer;
    @FindBy(className = "product_sort_container")
    public  WebElement productSortContainerDropDown;


    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div/span/select")
    public WebElement selectDropDown;

    public String fromAtoZ = "Name (A to Z)";
    public String fromZtoA = "Name (Z to A)";
    public String fromLowToHigh = "Price (low to high)";
    public String fromHightToLow = "Price (high to low)";




    //-   -   -   -   -   -   -

    public void clickOnMenuIcon(){
        menuIcon.click();
    }
    public void clickOnShopingCartIcon() {shopingCartIcon.click();}

    public void clickOnAddBtnLabsBackpack(){addBtnSauceLabsBackpack.click();}
    public void clickOnAddBtnLiabsBikeLight(){
        addBtnSauceLabsBikeLight.click();
    }
    public void clickOnAddBtnLabsTShirt(){
        addBtnSauceLabsBoltTShirt.click();
    }
    public void clickOnAddBtnLabsFleeceJacket(){
        addBtnSauceLabsFleeceJacket.click();
    }
    public void clickOnAddBtnLabsOnsie(){
        addBtnSauceLabsOnesie.click();
    }
    public void clickOnAddBtnLabsRedShirt() {addBtnRedTshirtTest.click();}

        //dropdownmenu


    @FindBy(className = "product_sort_container")
    public WebElement dropdownElement;


    public void clickOnProductSortContainerDropDown(){
        productSortContainerDropDown.click();
    }
    public void dropdownOptionSortAtoZ(){
        select.selectByValue("az");
    }
    public void dropdownOptionSortZtoA(){
        select.selectByValue("za");
    }
    public void dropdownOptionSortHiLo(){
        select.selectByValue("lohi");
    }
    public void dropdownOptionSortLoHi(){
        select.selectByValue("hilo");
    }


}
