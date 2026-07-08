package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(css = ".welcome-message")
    private WebElement welcomeMessage;

    @FindBy(css = ".logout-button")
    private WebElement logoutButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить приветственное сообщение")
    public String getWelcomeMessage() {
        return getElementText(welcomeMessage);
    }

    @Step("Нажать кнопку 'Выйти'")
    public void clickLogout() {
        clickElement(logoutButton);
    }

    @Step("Проверить, что пользователь авторизован")
    public boolean isUserLoggedIn() {
        return isElementVisible(welcomeMessage);
    }
}