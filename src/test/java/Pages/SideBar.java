package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar extends Base {

    public SideBar(){PageFactory.initElements(driver, this);}

    @FindBy(id = "inventory_sidebar_link")
    WebElement allItems;
    @FindBy(id = "about_sidebar_link")
    WebElement about;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logout;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppState;
    @FindBy(id = "react-burger-cross-btn")
    WebElement xBtnSidebar;

    //-   -   -   -   -   -

    public void clickOnAllItems(){
        allItems.click();
    }
    public void  clickOnAbout(){
        about.click();
    }
    public void clickOnLogout(){
        logout.click();
    }
    public void clickOnResetAppState(){
        resetAppState.click();
    }
    public void clickOnXBtn(){
        xBtnSidebar.click();
    }
}
