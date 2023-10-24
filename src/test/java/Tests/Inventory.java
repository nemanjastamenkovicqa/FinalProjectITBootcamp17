package Tests;

import Base.Base;
import com.google.common.base.CharMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory extends Base  {

    @AfterMethod
    public void quitBrowserAfterMetod(){
       driver.quit();

    }
    @AfterClass
    public void quitBrowserAfterClass(){

    }


    @Test(priority = 15)
    public void addingItemToShopingCartTest(){
        loginAsStandardUser();
        Assert.assertTrue(inventoryPage.shopingCartIcon.isDisplayed());
        elementIsDisplayed(inventoryPage.shopingCartBage);
        inventoryPage.clickOnAddBtnLabsBackpack();


        Assert.assertTrue(inventoryPage.removeBtnSauceLabsBackpack.isDisplayed());
        Assert.assertTrue(inventoryPage.shopingCartBage.isDisplayed());
    }

    @Test (priority = 25)
    public void testingCheckoutWithoutEnteringData() {
        loginAsStandardUser();

        inventoryPage.clickOnAddBtnLabsBackpack();
        inventoryPage.clickOnShopingCartIcon();
        cartPage.clickOnCheckoutBtn();
        checkOutPage.clickOnContinueBtn();

        String expectedURL = "https://www.saucedemo.com/checkout-step-one.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertTrue(checkOutPage.errorMessage.isDisplayed());
    }

    @Test (priority = 45)
    public void productSortActiveContainerHighToLow(){
        loginAsStandardUser();
        select = new Select(inventoryPage.dropdownElement);
        select.selectByValue("hilo");

        priceAssertAllItemsHighToLow();
    }

    @Test (priority = 50)
    public void productSortActiveContainerLowToHigh(){
        loginAsStandardUser();
        select = new Select(inventoryPage.dropdownElement);
        select.selectByValue("lohi");

        priceAssertAllItemsLowToHigh();
    }

    @Test (priority = 55)
    public void productSortAssertFromAToZ(){
        loginAsStandardUser();
        select = new Select(inventoryPage.dropdownElement);
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.className("inventory_item_name"));

        select.selectByValue("az");

        for(WebElement j:elementList){
            obtainedList.add(j.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>(obtainedList);
        Collections.sort(sortedList);
        Assert.assertEquals(sortedList, obtainedList);
    }

    @Test (priority = 60)
    public void productSortAssertFromZToA(){
        loginAsStandardUser();
        select = new Select(inventoryPage.dropdownElement);
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.className("inventory_item_name"));

        for(WebElement j:elementList){
            obtainedList.add(j.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>(obtainedList);
        Collections.reverse(sortedList);


        select.selectByValue("za");

        ArrayList<String> obtainedList2 = new ArrayList<>();
        List<WebElement> elementList2= driver.findElements(By.className("inventory_item_name"));

        for(WebElement j:elementList2){
            obtainedList2.add(j.getText());
        }
        Assert.assertEquals(sortedList, obtainedList2);
    }

//******************************
    //Methods
    //Method takes the value of items in descending order
    public void priceAssertAllItemsHighToLow(){
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItemsList = inventoryList.findElements(By.className("inventory_item_price"));
        String stringSaver = "";
        int priceSaver = Integer.MAX_VALUE;
        // For loop for extracting prices from the items and asserting them
        for (WebElement j : inventoryItemsList){

            stringSaver = j.getText();
            String theDigits = CharMatcher.inRange('0', '9').retainFrom(stringSaver);
            int price = Integer.parseInt(theDigits);

            if (price <= priceSaver){
                priceSaver = price;
                Assert.assertTrue(true);
            } else{
                Assert.fail();
            }
        }
    }
    ////Method takes the value of items in ascending order
    public void priceAssertAllItemsLowToHigh() {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItemsList = inventoryList.findElements(By.className("inventory_item_price"));
        String stringSaver = "";
        int priceSaver = Integer.MIN_VALUE;


        for (WebElement j : inventoryItemsList) {
            stringSaver = j.getText();
            String theDigits = CharMatcher.inRange('0', '9').retainFrom(stringSaver);
            int price = Integer.parseInt(theDigits);

            if (price >= priceSaver) {
                priceSaver = price;
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
        }
    }



}