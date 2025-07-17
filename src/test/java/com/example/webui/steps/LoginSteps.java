import io.cucumber.java.en.*;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    WebDriver driver;

    @Given("User opens the login page")
    public void user_opens_the_login_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("User inputs valid username and password")
    public void user_inputs_valid_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
    }

    @When("User inputs invalid username and password")
    public void user_inputs_invalid_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass");
    }

    @And("User clicks the login button")
    public void user_clicks_the_login_button() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String message = flash.getText();
        assertTrue(message.contains("You logged into a secure area!"));
    }

    @Then("User should see an error message")
    public void user_should_see_an_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String message = flash.getText();
        assertTrue(
                message.contains("Your username is invalid!") ||
                        message.contains("Your password is invalid!")
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

