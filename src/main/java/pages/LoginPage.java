package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "error-message")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открыть страницу логина")
    public void open() {
        driver.get("https://example.com/login");
    }

    @Step("Ввести логин: {username}")
    public void enterUsername(String username) {
        sendKeys(usernameField, username);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        clickElement(loginButton);
    }

    @Step("Выполнить вход с логином {username} и паролем {password}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Step("Получить текст ошибки")
    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

    @Step("Проверить, что сообщение об ошибке отображается")
    public boolean isErrorMessageDisplayed() {
        return isElementVisible(errorMessage);
    }
}