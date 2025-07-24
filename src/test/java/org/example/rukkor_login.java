package org.example ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class rukkor_login extends driverSetup {

    @BeforeClass

    public void performLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Open Login Page
        driver.get("https://dev.app.rukkor.com/login");

        // Step 2: Enter login credentials
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginForm_email")));
        username.sendKeys("jessy.test@yopmail.com");

        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginForm_password")));
        pass.sendKeys("Demo@12345");

        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        signIn.click();

        // Step 3: Wait for OTP screen to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='OTP Input 1']")));

        // Step 4: Open YOPmail in new tab to get OTP
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://yopmail.com/en/");

        String yopmailUser = "jessy.test@yopmail.com";
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

    }
}
