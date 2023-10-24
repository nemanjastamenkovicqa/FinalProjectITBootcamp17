package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckOutStepTwoPage extends Base {
    public CheckOutStepTwoPage(){
        initElements(driver, this);
    }

    @FindBy(id = "finish")
    public WebElement finishBtn;
    @FindBy(id = "cancel")
    WebElement cancelBtn;

    @FindBy(className = "summary_subtotal_label")
    public WebElement totalPriceElement;
// -   -   -   -   -   -

    public void clickOnFinishBtn(){
        finishBtn.click();
    }
    public void clickOnCancelBtn(){
        cancelBtn.click();
    }

}
