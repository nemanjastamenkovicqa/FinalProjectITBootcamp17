package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Base {
    public String firstNameString = "testFirstName";
    public String lastNameString = "testLastName";
    public String postalCodeString = "10000";
    public CheckOutPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    WebElement firstNameBox;
    @FindBy(id = "last-name")
    WebElement lastNameBox;
    @FindBy(id = "postal-code")
    WebElement postalCodeBox;
    @FindBy(id = "continue")
    WebElement continueBtn;
    @FindBy(id = "cancel")
    WebElement cancelBtn;
    @FindBy(css = ".error-message-container.error")
    public WebElement errorMessage;

//-   -   -   -   -   -   -

    public void enterFirstName(String firstNameString){
        firstNameBox.clear();
        firstNameBox.sendKeys(firstNameString);
    }
    public void enterLastName(String lastNameString){
        lastNameBox.clear();
        lastNameBox.sendKeys(lastNameString);
    }
    public void enterPostalCode(String postalCodeString){
        postalCodeBox.clear();
        postalCodeBox.sendKeys(postalCodeString);
    }
    public void clickOnContinueBtn(){
        continueBtn.click();
    }
    public void clickOnCancel(){
        cancelBtn.click();
    }

}
