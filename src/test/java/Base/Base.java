package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Base {
    public static WebDriver driver;
    public static WebDriverWait waiter;
    public LoginPage loginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    public CheckOutStepTwoPage checkOutStepTwoPage;
    public CheckOutCompletePage checkOutCompletePage;
    public SideBar sideBar;
    public String homeURL = "https://www.saucedemo.com/";
    public Select select;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("C:\\Users\\neman\\IdeaProjects\\FinalProjectITBootcamp17\\src\\test\\java\\excel\\loginData.xlsx");
    }
    @BeforeMethod//Method to make sure all tests are done properly, otherwise I would get in conflict with cookies and compromise my other tests
    public void testWithSeparateWindow(){

        driver = new ChromeDriver();
        waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        cartPage = new CartPage();
        checkOutPage = new CheckOutPage();
        checkOutStepTwoPage = new CheckOutStepTwoPage();
        checkOutCompletePage = new CheckOutCompletePage();
        sideBar = new SideBar();

        driver.navigate().to(homeURL);
    }
    @AfterMethod
    public void quitBrowserAfterMethod(){
        driver.quit();
    }

    //-- Storage Methods

    //Hardcoded login methods in case there is something wrong with the Excel file and I need a fast check of certain code
    public void loginAsStandardUser(){
        loginPage.enterUserName(loginPage.standartUserString);
        loginPage.enterPassWord(loginPage.passWordString);
        loginPage.clickOnLoginBtn();
    }
    public void loginAsLockedOutUser(){
        loginPage.enterUserName(loginPage.lockedOutUserString);
        loginPage.enterPassWord(loginPage.passWordString);
        loginPage.clickOnLoginBtn();
    }
    public void loginAsProblemUser(){
        loginPage.enterUserName(loginPage.problemUserString);
        loginPage.enterPassWord(loginPage.passWordString);
        loginPage.clickOnLoginBtn();
    }
    public void loginAsPerformanceGlitchUser(){
        loginPage.enterUserName(loginPage.performanceGlitchUserString);
        loginPage.enterPassWord(loginPage.passWordString);
        loginPage.clickOnLoginBtn();
    }
    //Method for asserting an WebElement before it's visible
    public boolean elementIsDisplayed(WebElement element) {

        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception e) {
            System.out.println(e);
        }
        return isDisplayed;
    }
    //Manually added items with ID
    public void addAllItemsByID(){
        inventoryPage.clickOnAddBtnLabsBackpack();
        inventoryPage.clickOnAddBtnLiabsBikeLight();
        inventoryPage.clickOnAddBtnLabsFleeceJacket();
        inventoryPage.clickOnAddBtnLabsOnsie();
        inventoryPage.clickOnAddBtnLabsTShirt();
        inventoryPage.clickOnAddBtnLabsRedShirt();
    }
}
