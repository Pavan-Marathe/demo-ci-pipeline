package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearch1 {
    WebDriver driver;
    WebDriverWait wait;

    @Before
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

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

}
