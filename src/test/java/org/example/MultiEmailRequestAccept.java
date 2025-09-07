package org.example ;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultiEmailRequestAccept extends driverSetup {

        @Test

        public void performLogin() throws InterruptedException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // List of test emails
            String[] emails = {
//                Email reg. users
                    "alma047@yopmail.com",
                    "ralph062@yopmail.com"
            };

            outer:
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
                    WebElement UserLogin = driver.findElement(By.id("login"));
                    UserLogin.clear();
                    UserLogin.sendKeys(yopmailUser);
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

                    ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");

//                driver.navigate().refresh();

                    // Get all tab handles
                    Set<String> allTabs = driver.getWindowHandles();
                    List<String> tabs = new ArrayList<>(allTabs);

// Switch to the tab you want to close (example: second tab, index 1)
                    driver.switchTo().window(tabs.get(1));

// Close the selected tab
                    driver.close();

// Switch back to first tab (optional)
                    driver.switchTo().window(tabs.get(0));


//            driver.switchTo().window((String) tabs[0]);

                    // Step 6: Enter OTP automatically
                    for (int i = 0; i < otp.length(); i++) {
                        WebElement otpInput = wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//input[@aria-label='OTP Input " + (i + 1) + "']")));
                        otpInput.sendKeys(Character.toString(otp.charAt(i)));
                    }
                    System.out.println("✅ OTP entered successfully");

                    System.out.println("Email logged successfully :-- " + emailId);

                    Thread.sleep(2000);

                    // 🔄 Refresh once at start
                    driver.navigate().refresh();

//                    wait for load the screen
                    Thread.sleep(2000);

                    // Wait for request container
                    WebElement container;
                    try {
                        container = wait.until(ExpectedConditions
                                .presenceOfElementLocated(By.cssSelector(".contact_bar_image")));
                    } catch (TimeoutException e) {
                        System.out.println("❌ No request container found.");
//                        return;
                        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
                        driver.navigate().refresh();
                        continue;

                    }



            // Find all requests
            List<WebElement> requests = container.findElements(By.tagName("span"));
            if (requests.isEmpty()) {
                System.out.println("✅ No requests available.");

            }

            // Click first request
            requests.get(0).click();

            // Handle Accept button (contact OR group)

                    WebElement acceptBtn = null;

//                    Apply looping for accept multiple requests 1 by 1
// Example loop (replace 10 with your limit, or use while loop)
                    for (int a = 0; a < 10; a++) {
                        try {
                            // 🔹 Try Contact request
                            acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                                    By.xpath("//div[contains(@id,'r')]/div/div[5]/button[2]")));
                            System.out.println("Contact request found." + a);
                            Thread.sleep(1000);
                            Actions actions = new Actions(driver);
                            actions.moveToElement(acceptBtn)
                                    .pause(Duration.ofMillis(300))
                                    .click()
                                    .perform();
                            Thread.sleep(1000);

                        } catch (TimeoutException e1) {
                            try {
                                // 🔹 Try Group request
                                acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                                        By.xpath("//div[contains(@id,'r')]//button[2][span[normalize-space()='ACCEPT_REAL_ID_GROUP']]")));
                                System.out.println("Group request found." + a);
                                Thread.sleep(1000);
                                Actions actions = new Actions(driver);
                                actions.moveToElement(acceptBtn)
                                        .pause(Duration.ofMillis(300))
                                        .click()
                                        .perform();

                            } catch (TimeoutException e3) {
                                System.out.println("No request found in iteration " + a);
                                try {
                                    driver.navigate().refresh();
                                    requests.get(0).click();

                                }catch (Exception a1) {
                                    try {
                                        requests.get(1).click();
                                    }catch (Exception a2) {
                                        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
                                        driver.navigate().refresh();
                                        continue outer;
                            }
                        }


                              }
                          }
                        }
                    }

            }

        }

