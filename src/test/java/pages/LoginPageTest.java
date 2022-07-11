package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {
    private ChromeDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
    }


    @Test
    public void whenRequestToLoginPage_ShouldPass() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.visiLoginPage("lisa@gmail.com","1234");

//        assertEquals(docsPage.getSuccessMessage(),"Thank you!");
    }

    @AfterEach
    void tearDown() {
//        driver.quit();
    }

}