package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    // Extended BasePage constructor for using BasePage methods
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    @FindBy(xpath = "//nav//a/span[contains(text(), 'Поиск')][1]")
    private WebElement searchBtn;

    //Methods
    @Step("Проверить, что поисковая строка отображается")
    public boolean issearchBtnDisplayed() {
        return isElementVisible(searchBtn);
    }

}
