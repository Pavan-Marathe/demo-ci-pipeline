
///This method run normally (Without looping)
package org.example;

import org.junit.runners.model.TestTimedOutException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.sql.Time;
import java.time.Duration;
import java.util.List;

public class DemoRequest extends rukkor_login {

    @Test
    public void AcceptContact() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.navigate().refresh();
// Wait inside the request layout
        WebElement container = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".contact_bar_image")));

        Thread.sleep(500);

// Then find children inside
        List<WebElement> requests = container.findElements(By.tagName("span"));
        if (!requests.isEmpty()) {
            requests.get(0).click(); // first request
        }

        Thread.sleep(2000);

// Wait for Accept button (target the <button>, not span)
        WebElement acceptBtn;
        try {
            acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@id,'r')]/div/div[5]/button[2]")));

        } catch (TimeoutException e) {
            acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@id,'r')]//button[2][span[normalize-space()='ACCEPT_REAL_ID_GROUP']]")));
        }
        acceptBtn.click();

// Click using Actions to avoid overlay issues
        Actions actions = new Actions(driver);
        actions.moveToElement(acceptBtn).pause(Duration.ofMillis(500)).click().perform();

        Thread.sleep(1000);

    }
    @Test
    public void AcceptContact1() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.navigate().refresh();
// Wait inside the request layout
        WebElement container = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".contact_bar_image")));

        Thread.sleep(500);

// Then find children inside
        List<WebElement> requests = container.findElements(By.tagName("span"));
        if (!requests.isEmpty()) {
            requests.get(0).click(); // first request
        }

        Thread.sleep(2000);

// Wait for Accept button (target the <button>, not span)
        WebElement acceptBtn;
        try {
            acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@id,'r')]/div/div[5]/button[2]")));

        } catch (TimeoutException e) {
            acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@id,'r')]//button[2][span[normalize-space()='ACCEPT_REAL_ID_GROUP']]")));
        }
        acceptBtn.click();


// Click using Actions to avoid overlay issues
        Actions actions = new Actions(driver);
        actions.moveToElement(acceptBtn).pause(Duration.ofMillis(500)).click().perform();

    }

}