package Tests;

import Base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base {
    @Test
    public void userCanLoginExcel(){
        String validUsername = excelReader.getStringData("Sheet1", 1, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1,1);

        loginPage.enterUserName(validUsername);
        loginPage.enterPassWord(validPassword);
        loginPage.clickOnLoginBtn();
    }

    @Test// This test goes through series of incorrect login data
    public void userEntersInvalidLoginData(){
        for (int i = 1; i < excelReader.getLastRow("Sheet1"); i++) {
            String validUsername = excelReader.getStringData("Sheet1", 1, 3);
            String validPassword = excelReader.getStringData("Sheet1", 1,2);

            loginPage.enterUserName(validUsername);
            loginPage.enterPassWord(validPassword);
            loginPage.clickOnLoginBtn();
            Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        }
    }

    @Test()
    public void userIsLockedOutTest(){
        String validUsername = excelReader.getStringData("Sheet1", 2, 0);
        String validPassword = excelReader.getStringData("Sheet1", 1,1);
        loginPage.enterUserName(validUsername);
        loginPage.enterPassWord(validPassword);
        loginPage.clickOnLoginBtn();

        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL );
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }


    @Test (priority = 10) //I am asserting that user is able to get from login to main inventory page correctly
    public void userCanLogIn(){

        Assert.assertEquals(driver.getCurrentUrl(), homeURL);
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());

        loginAsStandardUser();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        inventoryPage.clickOnMenuIcon();
        Assert.assertTrue(inventoryPage.menuIcon.isDisplayed());
        Assert.assertTrue(inventoryPage.shopingCartIcon.isDisplayed());
    }
}
