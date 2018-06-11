package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen {

    private WebDriver androidDriver = null;
    private int timeOutInSeconds=0;

    //Locators
    private By txt_emailId=By.id("com.fitbit.FitbitMobile:id/login_email");
    private By txt_password=By.id("com.fitbit.FitbitMobile:id/login_password");
    private By btn_login=By.id("com.fitbit.FitbitMobile:id/login_button");

    public LoginScreen(WebDriver androidDriver) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=30;
    }

    public LoginScreen(WebDriver androidDriver, int timeOutInSeconds) {
        this.androidDriver = androidDriver;
        this.timeOutInSeconds=timeOutInSeconds;
    }


    void enterEmail(String emailUser) {
        try {
            WebElement emailElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(txt_emailId));
            System.out.println("emailElement.isDisplayed() [Explicit Waited] : "+emailElement.isDisplayed());
            emailElement.sendKeys(emailUser);
        } catch (Exception e) {
            System.out.println("Problem entering username ");
        }

    }
    void enterPassword(String passwd) {
        try {
            WebElement passwordElement = (new WebDriverWait(androidDriver, timeOutInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(txt_password));
            System.out.println("emailElement.isDisplayed() [Explicit Waited] : " + passwordElement.isDisplayed());
            passwordElement.sendKeys(passwd);
        } catch (Exception e) {
            System.out.println("Problem entering password ");
        }
    }

    void clickLoginBtn() {
        try {
            WebElement loginButton = (new WebDriverWait(androidDriver, 15))
                    .until(ExpectedConditions.presenceOfElementLocated(btn_login));
            System.out.println("loginButton.isDisplayed() : " + loginButton.isDisplayed());
            loginButton.click();
        } catch (Exception e) {
            System.out.println("Problem clicking login button");
        }
    }

    public DashboardScreen login(String username, String password) {
         enterEmail(username);
         enterPassword(password);
         clickLoginBtn();
         return new DashboardScreen(androidDriver);
    }

}
