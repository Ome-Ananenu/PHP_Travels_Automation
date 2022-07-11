package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class SignUpPageTest {
    private ChromeDriver driver;
    private SignUpPage signUpPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
    }

    @Test
    public void whenRequestToSignUp_ShouldPass() throws InterruptedException {
        signUpPage = new SignUpPage(driver);
        signUpPage.fillSignUpForm("lisa","mary","lisamary@gmail.com","NextUp","15, Okhouromi",
                "Benin City","Edo State","12098","903457833","1234","1234"
                );

//        assertEquals(docsPage.getSuccessMessage(),"Thank you!");
    }
    @AfterEach
    void tearDown() {
        //        driver.quit();
    }
}