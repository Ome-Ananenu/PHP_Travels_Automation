package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

class DemoPageTest {
    private ChromeDriver driver;
    private DemoPage demoPage;


    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
    }


    @Test
    public void whenRequestForDemoWithValidDetails_ShouldPass() throws InterruptedException {
        demoPage = new DemoPage(driver);
        demoPage.fillRequestDemoForm("Lori","Evan","MBI","evanlori@gmail.com");

        assertEquals(demoPage.getSuccessMessage(),"Thank you!");
    }

    @AfterEach
    void tearDown() {
                driver.quit();
    }
}