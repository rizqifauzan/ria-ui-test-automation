package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Deklarasi locator
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By loginButton = By.id("login");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Action: isi username
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    // Action: isi password
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Action: klik tombol login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}

