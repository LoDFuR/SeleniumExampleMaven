package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            WebDriverFactory.quitDriver();
        }
    }

    @Step("Сделать скриншот")
    protected byte[] takeScreenshot() {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return new byte[0];
    }

    // Метод для сохранения скриншота в файл (опционально)
    protected void saveScreenshot(String name) {
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Path path = Paths.get("screenshots", name + ".png");
                Files.createDirectories(path.getParent());
                Files.copy(screenshot.toPath(), path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}