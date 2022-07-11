package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PricingPage {
    private ChromeDriver driver;
    private String pricingPageBtnId = "/html/body/header/div/nav/a[2]";
    private String buyNowBtnId = "//*[@id=\"Main\"]/div[6]/div/div[1]/section/div[2]/div[1]/div/a";
    private String checkOut = "checkout";
    private SignUpPage signUpPage;
    private String completeOrderBtnId = "btnCompleteOrder";

    public PricingPage(ChromeDriver driver) {
        this.driver = driver;
    }
    public void visitBuyNowPage(String firstName, String lastName, String email, String companyName, String streetAddress,
                                String city, String state, String postCode, String mobileNumber, String password, String confirmPassword) throws InterruptedException {
        visitPricingPage();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement buyNowBtn = driver.findElementByXPath(buyNowBtnId);
        buyNowBtn.click();

        WebElement checkOutBtn = driver.findElementById(checkOut);
        checkOutBtn.click();

        signUpPage.fillFormDetails(firstName,lastName,email,companyName,streetAddress,city,state,postCode,mobileNumber,password,confirmPassword);
    }

    private void enableCompleteOrderBtn() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Object enableSubmitBtn = js.executeScript("document.querySelector('#btnCompleteOrder').disabled = false");

        Thread.sleep(3000);
        WebElement completeOrderBtn = driver.findElementById(completeOrderBtnId);
        completeOrderBtn.click();
    }

    private void visitPricingPage() {
        WebElement pricingPageBtn = driver.findElementByXPath(pricingPageBtnId);
        pricingPageBtn.click();
    }
}
