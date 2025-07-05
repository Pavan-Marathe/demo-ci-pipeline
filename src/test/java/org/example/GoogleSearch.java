package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class GoogleSearch {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com/");

        // Generate random inputs
        String randAlpha  = RandomUtils.randomAlphanumeric(8);
        String randName  = RandomUtils.randomName();
        // Example usage: pick one to send to Google
        String toSend = randName +"-"+ randAlpha;

        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBox.sendKeys(toSend);

        System.out.println("Added random text to Google search: " + toSend);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
