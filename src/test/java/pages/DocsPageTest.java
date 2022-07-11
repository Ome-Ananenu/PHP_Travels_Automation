package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

class DocsPageTest {
    private ChromeDriver driver;
    private DocsPage docsPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
    }


    @Test
    public void whenRequestForDocsPage_ShouldPass() throws InterruptedException {
        docsPage = new DocsPage(driver);
        docsPage.visitDocPage();

//        assertEquals(docsPage.getSuccessMessage(),"Thank you!");
    }

    @AfterEach
    void tearDown() {
//        driver.quit();
    }

}