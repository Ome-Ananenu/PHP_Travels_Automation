package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoPage {
    private ChromeDriver driver;
    private String firstNameSelector = "//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/input[1]";
    private String lastNameSelector = "input[name ='last_name']";
    private String businessNameSelector = "input[name='business_name']";
    private String emailSelector = "input[name='email']";
    private String submitBtnSelector ="demo";
    private String successMessageSelector = "//*[@id=\"Main\"]/section[1]/div/div/div[2]/div/div/div/div/div/div/div/div[3]/h1/strong";

    public DemoPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void fillRequestDemoForm(String firstName, String lastName, String businessName,String email) throws InterruptedException {
       Thread.sleep(3000);
        driver.findElementByXPath(firstNameSelector).sendKeys(firstName);
        driver.findElementByCssSelector(lastNameSelector).sendKeys(lastName);
        driver.findElementByCssSelector(businessNameSelector).sendKeys(businessName);
        driver.findElementByCssSelector(emailSelector).sendKeys(email);

        enableSubmitBtn();

    }

    private void enableSubmitBtn(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Object enableSubmitBtn = js.executeScript("document.querySelector('#demo').disabled = false");

        driver.findElementById(submitBtnSelector).click();
    }
    public String getSuccessMessage() throws InterruptedException {
        Thread.sleep(2000);
        WebElement successMssg = driver.findElementByXPath(successMessageSelector);
        return successMssg.getText();
    }

}
