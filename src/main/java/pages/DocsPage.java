package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class DocsPage {
    private ChromeDriver driver;
    private String docPageUrl = "/html/body/header/div/nav/a[3]";
    private String configurationBtn = "/html/body/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[1]/a/div[2]";


    public DocsPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void visitDocPage() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElementByXPath(docPageUrl).click();

        Thread.sleep(4000);
        scrollToPageBottom();

        Thread.sleep(3000);
        WebElement configurationButton = driver.findElementByXPath(configurationBtn);
        configurationButton.click();
    }

    private void scrollToPageBottom(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

    }
}
