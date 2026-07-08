package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import pages.yaPage;

import static org.assertj.core.api.Assertions.assertThat;

@Feature("Главная страница Яндекса")
@Owner("Anna")
class YaPageTest extends BaseTest {

    @Test
    @Story("Открытие главной страницы")
    @DisplayName("Проверка открытия главной страницы ya.ru")
    @Description("Тест проверяет, что главная страница Яндекса успешно открывается и содержит поисковую строку")
    @Severity(SeverityLevel.BLOCKER)
    public void testOpenYaPage() {
        // Arrange
        yaPage yaPage = new yaPage(driver);
        // Act
        yaPage.open();

        // Assert
        assertThat(yaPage.isSearchInputDisplayed())
                .as("Поисковая строка должна отображаться")
                .isTrue();


    }

    @Test
    @Story("Открытие главной страницы")
    @DisplayName("Проверка открытия главной страницы ya.ru")
    @Description("Тест проверяет, что главная страница Яндекса успешно открывается и содержит поисковую строку")
    @Severity(SeverityLevel.BLOCKER)
    public void testSearch() {
        // Arrange
        yaPage yaPage = new yaPage(driver);
        SearchPage sPage = new SearchPage(driver);
        // Act
        yaPage.open();

        // Assert
        assertThat(yaPage.isSearchInputDisplayed())
                .as("Поисковая строка должна отображаться")
                .isTrue();

        yaPage.setSearchInputContainer("Котики");
        sPage.issearchBtnDisplayed();


    }

}