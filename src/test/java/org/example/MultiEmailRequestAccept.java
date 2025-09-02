package org.example ;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MultiEmailRequestAccept extends driverSetup {

        @Test

        public void performLogin() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // List of test emails
            String[] emails = {
//                Email reg. users
//                    "john815@yopmail.com",
                    "smith217@yopmail.com",
                    "sunny007@yopmail.com",
                    "sunil008@yopmail.com",
                    "first@yopmail.com",
                    "jack010@yopmail.com",
                    "jiten013@yopmail.com",
                    "amar014@yopmail.com",
                    "martin015@yopmail.com",
                    "julie016@yopmail.com"
            };

            for (String emailId : emails) {

            // Step 1: Open Login Page
            driver.get("https://dev.app.rukkor.com/login");

            Thread.sleep(1000);

            // Step 2: Enter login credentials
            WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginForm_email")));
            username.sendKeys(emailId);

            WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginForm_password")));
            pass.sendKeys("Demo@12345");

            WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            signIn.click();

            // Step 3: Wait for OTP screen to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='OTP Input 1']")));

            // Step 4: Open YOPmail in new tab to get OTP
            driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
            driver.get("https://yopmail.com/en/");

            String yopmailUser = emailId;
            driver.findElement(By.id("login")).sendKeys(yopmailUser);
            driver.findElement(By.id("refreshbut")).click();

            // Wait for inbox
            driver.switchTo().frame("ifinbox");
            WebElement latestEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m")));
            latestEmail.click();

            // Switch to email content
            driver.switchTo().defaultContent();
            driver.switchTo().frame("ifmail");

            // Extract OTP from the email text
            String emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail"))).getText();
            System.out.println("Email Content:\n" + emailBody);

            // Assuming OTP is 6 digits in email text
            String otp = emailBody.replaceAll("[^0-9]", "").substring(0, 6);
            System.out.println("Fetched OTP: " + otp);

            // Step 5: Switch back to your app tab
            var tabs = driver.getWindowHandles().toArray();
            driver.switchTo().window((String) tabs[0]);

            // Step 6: Enter OTP automatically
            for (int i = 0; i < otp.length(); i++) {
                WebElement otpInput = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@aria-label='OTP Input " + (i + 1) + "']")));
                otpInput.sendKeys(Character.toString(otp.charAt(i)));
            }
            System.out.println("✅ OTP entered successfully");

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

                ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
                driver.switchTo().newWindow(WindowType.WINDOW);


        }

    }
}




