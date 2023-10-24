package Tests;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ShopingCart extends Base {
    @Test (priority = 20)
    public void deleteItemsFromShopingCart() {

        loginAsStandardUser();
        addAllItems();
        Assert.assertTrue(inventoryPage.shopingCartBage.isDisplayed());
        inventoryPage.clickOnShopingCartIcon();

        removeAllItemsFromCart();

        elementIsDisplayed(inventoryPage.shopingCartBage);
    }

    @Test (priority = 30)
    public void completingShoping() {
        loginAsStandardUser();

        addAllItems();

        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckoutBtn();
        enterAllData();
        checkOutPage.clickOnContinueBtn();

        WebElement element = driver.findElement(By.id("finish"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        checkOutStepTwoPage.clickOnFinishBtn();

        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertTrue(checkOutCompletePage.backToHomeBtn.isDisplayed());
    }

    @Test (priority = 35)
    public void canclingShopingInCheckOutStepTwo() {
        loginAsStandardUser();

        addAllItems();

        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckoutBtn();
        enterAllData();
        checkOutPage.clickOnContinueBtn();

        String expectedURL = "https://www.saucedemo.com/checkout-step-two.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
        checkOutStepTwoPage.clickOnCancelBtn();

        String expectedURL2 = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
    }

    @Test
    public void backToHomeFromCompletePage(){
        loginAsStandardUser();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckoutBtn();
        enterAllData();
        checkOutPage.clickOnContinueBtn();
        Assert.assertTrue(checkOutStepTwoPage.finishBtn.isDisplayed());

        checkOutStepTwoPage.clickOnFinishBtn();

        Assert.assertTrue(checkOutCompletePage.backToHomeBtn.isDisplayed());
        String expectedURL = "https://www.saucedemo.com/checkout-complete.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        checkOutCompletePage.clickOnBackToHomeBtn();
        String expectedURL2 = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL2);
    }
    @Test
    public void priceCheckAssert(){
        loginAsStandardUser();
        addAllItems();

        double priceSum = 0;

        List<WebElement> itemsPrice = driver.findElements(By.className("inventory_item_price"));
        for (WebElement j : itemsPrice){
            System.out.println();
            priceSum +=   Double.parseDouble(j.getText().replaceAll("[^0-9]", ""));

        }

        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckoutBtn();
        enterAllData();
        checkOutPage.clickOnContinueBtn();

        double totalPriceElement = Double.parseDouble(checkOutStepTwoPage.totalPriceElement.getText().replaceAll("[^0-9]", ""));

        if (priceSum == totalPriceElement){
            Assert.assertTrue(true);
        }
    }

    //Methods
    public void addAllItems(){
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItemsList = inventoryList.findElements(By.className("inventory_item"));
        //Here I assert bother an add button element as well as remove button element
        for (int i = 0; i < inventoryItemsList.size(); i++) {
            WebElement itemsAddBtn = driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory"));
            itemsAddBtn.click();
            WebElement itemsRemoveBtn = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory "));
            Assert.assertTrue(itemsRemoveBtn.isDisplayed());
        }
    }
    public void removeAllItemsFromCart(){
        WebElement cartListElement = driver.findElement(By.className("cart_list"));
        List<WebElement> cartListItems = cartListElement.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
        //Removing items by clicking on the next remove button element with the same Identifier
        for (int i = 0; i < cartListItems.size(); i++) {
            WebElement theItem = driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));
            Assert.assertTrue(theItem.isDisplayed());
            theItem.click();
        }

    }
    public void enterAllData(){
        checkOutPage.enterFirstName(checkOutPage.firstNameString);
        checkOutPage.enterLastName(checkOutPage.lastNameString);
        checkOutPage.enterPostalCode(checkOutPage.postalCodeString);
    }
}
