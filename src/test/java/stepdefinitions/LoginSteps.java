package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User opens the login page")
    public void user_opens_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "/Users/riapuspita/Documents/chromedriver"); // ganti path jika perlu
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/"); // Ganti dengan URL aplikasi asli
        loginPage = new LoginPage(driver);
    }

    @When("User inputs valid username and password")
    public void user_inputs_valid_credentials() {
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPass");
    }

    @When("User inputs invalid username and password")
    public void user_inputs_invalid_credentials() {
        loginPage.enterUsername("wrongUser");
        loginPage.enterPassword("wrongPass");
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_see_dashboard() {
        String expectedUrl = "https://example.com/dashboard";
        assertEquals(expectedUrl, driver.getCurrentUrl());
        driver.quit();
    }

    @Then("User should see an error message")
    public void user_should_see_error_message() {
        // Misalnya ada teks error di halaman
        boolean errorDisplayed = driver.getPageSource().contains("Invalid username or password");
        assertTrue(errorDisplayed);
        driver.quit();
    }
}
