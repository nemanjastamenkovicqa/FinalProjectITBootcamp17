package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends Base {
    public CheckOutCompletePage(){PageFactory.initElements(driver, this);}

    @FindBy(id = "back-to-products")
    public WebElement backToHomeBtn;

    public void clickOnBackToHomeBtn(){
        backToHomeBtn.click();
    }

}
