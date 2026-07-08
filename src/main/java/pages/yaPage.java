package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class yaPage extends BasePage {

    //Locators
    @FindBy(css = "div[class*='input'][class*='inner-container']")
    private WebElement searchInputContainer;

    @FindBy(xpath = "//textarea[@placeholder=\"Найдётся всё\"]")
    private WebElement searchInput;

    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    public yaPage(WebDriver driver) {
        super(driver);
    }

    // Methods
    @Step("Открыть главную страницу Яндекса")
    public void open() {
        driver.get("https://ya.ru");
    }

    @Step("Проверить, что поисковая строка отображается")
    public boolean isSearchInputDisplayed() {
        return isElementVisible(searchInputContainer);
    }

    @Step("Получить заголовок страницы")
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Step("Вводим в инпут данные")
    public void setSearchInputContainer(String someInput) {
        searchInput.click();
        searchInput.sendKeys(someInput);
        searchButton.click();
    }
}