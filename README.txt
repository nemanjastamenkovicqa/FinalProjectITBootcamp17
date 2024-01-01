
Automated Testing Framework

This comprehensive Java-based automated testing framework utilizes Selenium WebDriver and TestNG for efficient and structured test automation.
The framework is organized into the Base and Pages packages, providing a foundation for testing and encapsulating page-specific functionality.

Prerequisites
Java Development Kit (JDK)
TestNG
Selenium WebDriver
WebDriverManager
ExcelReader library (included in the project)
Base Package
Base Class
The Base class serves as the core of the testing framework, containing common setup and utility methods. It includes:

WebDriver initialization and setup using WebDriverManager.
ExcelReader for handling test data from an Excel file.
Methods for creating a new WebDriver instance before each test.
Methods for quitting the browser after each test.
Hardcoded login methods for quick verification in case of Excel data issues.
Method for asserting WebElement visibility before interaction.
Usage
Clone the repository.
Set up dependencies.
Configure Excel data path in the setUp method.
Set the homeURL variable to your application URL.
Pages Package
CheckOutCompletePage Class
Represents the "Checkout Complete" page with methods for interacting with elements on the page.

java
Copy code
package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends Base {
    // Page elements and methods
}


CheckOutPage Class
Represents the "Checkout" page with methods for entering user information and interacting with buttons.

java
Copy code
package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends Base {
    // Page elements and methods
}


CheckOutStepTwoPage Class
Represents the second step of the checkout process with methods for interacting with elements.

java
Copy code
package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckOutStepTwoPage extends Base {
    // Page elements and methods
}


InventoryPage Class
Represents the inventory page with methods for interacting with product elements and dropdown menus.

java
Copy code
package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends Base {
    // Page elements and methods
}


LoginPage Class
Represents the login page with methods for entering user credentials and clicking the login button.

java
Copy code
package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {
    // Page elements and methods
}


SideBar Class
Represents the sidebar with methods for navigating to different sections and interacting with buttons.

java
Copy code
package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar extends Base {
    // Page elements and methods
}


Test Execution
Customize login methods, test scenarios, and locators in the Base class.
Run test classes using TestNG.