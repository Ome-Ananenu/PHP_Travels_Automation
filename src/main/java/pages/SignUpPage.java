package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPage {
    private ChromeDriver driver;
    private String signUpBtnId = "/html/body/header/div/nav/a[5]";
    private String firstNameId = "inputFirstName";
    private String lastNameId = "inputLastName";
    private String emailId = "inputEmail";
    private String companyNameId = "inputCompanyName";
    private String streetAddressId = "inputAddress1";
    private String cityId = "inputCity";
    private String stateId = "stateinput";
    private String postCodeId = "inputPostcode";
    private String mobileNumberId = "customfield2";
    private String passwordId = "inputNewPassword1";
    private String confirmPasswordId = "inputNewPassword2";
    private String registerBtnId = "input['value=Register']";


    public SignUpPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void fillSignUpForm(String firstName, String lastName, String email, String companyName, String streetAddress,
                               String city, String state, String postCode, String mobileNumber, String password, String confirmPassword) throws InterruptedException {

        visitSignUpPage();

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
        driver.findElementById(firstNameId).sendKeys(firstName);
        driver.findElementById(lastNameId).sendKeys(lastName);
        driver.findElementById(emailId).sendKeys(email);
        driver.findElementById(companyNameId).sendKeys(companyName);
        driver.findElementById(streetAddressId).sendKeys(streetAddress);
        driver.findElementById(cityId).sendKeys(city);
        driver.findElementById(stateId).sendKeys(state);
        driver.findElementById(postCodeId).sendKeys(postCode);
        driver.findElementById(mobileNumberId).sendKeys(mobileNumber);
        driver.findElementById(passwordId).sendKeys(password);
        driver.findElementById(confirmPasswordId).sendKeys(confirmPassword);

        enableSubmitBtn();
    }

    private void enableSubmitBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Object enableSubmitBtn = js.executeScript("document.querySelector('#login').disabled = false");

        Thread.sleep(3000);
        WebElement signUpBtn = driver.findElementById(signUpBtnId);
        signUpBtn.click();
    }
    private void visitSignUpPage() {
        WebElement signUpBtn = driver.findElementByXPath(signUpBtnId);
        signUpBtn.click();
    }
}
