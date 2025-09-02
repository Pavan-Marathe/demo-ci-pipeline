package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AcceptContGrpRequest extends rukkor_login {

        @Test
        public void AcceptContact() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            Thread.sleep(1000);

            // 🔄 Refresh once at start
            driver.navigate().refresh();

            // Wait for request container
            WebElement container;
            try {
                container = wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".contact_bar_image")));
            } catch (TimeoutException e) {
                System.out.println("❌ No request container found.");
                return;
            }

            // Find all requests
            List<WebElement> requests = container.findElements(By.tagName("span"));
            if (requests.isEmpty()) {
                System.out.println("✅ No requests available.");
                return;
            }

            // Click first request
            requests.get(0).click();

            // Handle Accept button (contact OR group)
            WebElement acceptBtn;
            boolean isGroup = false;
            try {
                // Contact request
                acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@id,'r')]/div/div[5]/button[2]")));
            } catch (TimeoutException e) {
                // Group Request
                acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[contains(@id,'r')]//button[2][span[normalize-space()='ACCEPT_REAL_ID_GROUP']]")));
                isGroup = true;
            }

            // Click using Actions (to avoid overlay issues)
            Actions actions = new Actions(driver);
            actions.moveToElement(acceptBtn).pause(Duration.ofMillis(300)).click().perform();

            // Wait until button disappears after clicking
            try {
                if (isGroup) {
                    wait.withTimeout(Duration.ofSeconds(15))
                            .until(ExpectedConditions.invisibilityOf(acceptBtn));
                } else {
                    wait.withTimeout(Duration.ofSeconds(5))
                            .until(ExpectedConditions.invisibilityOf(acceptBtn));
                }
                System.out.println("✅ Request accepted successfully.");
            } catch (TimeoutException e) {
                System.out.println("⚠️ Accept button did not disappear in time.");
            }
        }
    }




