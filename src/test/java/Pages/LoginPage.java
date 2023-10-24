package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
    public String standartUserString = "standard_user";
    public String lockedOutUserString = "locked_out_user";
    public String problemUserString = "problem_user";
    public String performanceGlitchUserString = "performance_glitch_user";
    public String passWordString = "secret_sauce";


public LoginPage() {PageFactory.initElements(driver, this);}
    @FindBy(id = "user-name")
    public WebElement userNameBox;
    @FindBy(id = "password")
    public WebElement passWordBox;
    @FindBy(id = "login-button")
    public WebElement loginBtn;
    @FindBy(className = "error-button")
    public WebElement errorMessage;

//-   -   -   -   -   -   -   -
    public void enterUserName(String username){
        userNameBox.clear();
        userNameBox.sendKeys(username);
    }
    public void enterPassWord(String password){
        passWordBox.clear();
        passWordBox.sendKeys(password);
    }
    public void clickOnLoginBtn(){
        loginBtn.click();
    }

}
