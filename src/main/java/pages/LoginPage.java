package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private ChromeDriver driver;
    private String loginPageBtnId = "/html/body/header/div/nav/a[4]";
    private String emailAddressId = "inputEmail";
    private String passwordId = "inputPassword";
    private String loginBtnId = "login";

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void visitLoginPage(String email, String password){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement loginBtn = driver.findElementByXPath(loginPageBtnId);
        loginBtn.click();

        fillLoginForm(email,password);
    }

    public void fillLoginForm(String email, String password){
        WebElement emailField = driver.findElementById(emailAddressId);
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElementById(passwordId);
        passwordField.sendKeys(password);

        enableLoginBtn();
    }

    private void enableLoginBtn(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object enableSubmitBtn = js.executeScript("document.querySelector('#login').disabled = false");

        WebElement loginBtn = driver.findElementById(loginBtnId);
        loginBtn.click();
    }
}
