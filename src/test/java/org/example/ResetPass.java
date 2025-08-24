package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class ResetPass extends driverSetup {

    @Test
    public void resetPassword() throws InterruptedException, IOException, AWTException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        1st window is opened.
        driver.get("https://dev.app.rukkor.com/login");

        Thread.sleep(1000);

        WebElement chooseresetPass = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"loginForm\"]/div[2]/button[2]")));
        chooseresetPass.click();

        WebElement EnterEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ResetPassword_email")));
        EnterEmail.sendKeys("samhoxwc@yopmail.com");

        WebElement ResetBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        ResetBtn.click();

        Thread.sleep(500);


// Store the main window (login page)
        String firstWindow = driver.getWindowHandle();

// ---- 1st window: login page done ----


// ---- 2nd window: open yopmail ----
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://yopmail.com/en/");

// Store second window handle
        String secondWindow = "";
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(firstWindow)) {
                secondWindow = win;
            }
        }

// Perform yopmail actions
        String yopmailUser = "samhoxwc@yopmail.com";
        driver.findElement(By.id("login")).sendKeys(yopmailUser);
        driver.findElement(By.id("refreshbut")).click();

// Wait inbox
        driver.switchTo().frame("ifinbox");
        WebElement latestEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.m")));
        latestEmail.click();

// Switch to email body
        driver.switchTo().defaultContent();
        driver.switchTo().frame("ifmail");

        WebElement ResetpassLinkText = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Reset Password")));
        ResetpassLinkText.click();


// ---- 3rd window: reset password tab ----
        String thirdWindow = "";
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(firstWindow) && !win.equals(secondWindow)) {
                thirdWindow = win;
            }
        }
        driver.switchTo().window(thirdWindow);

// Enter new password
        WebElement NewPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resetpassword_password")));
        NewPass.sendKeys("Demo@12345");

        WebElement confPass = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resetpassword_confirmpassword")));
        confPass.sendKeys("Demo@12345");

        WebElement SetNewPass = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"resetpassword\"]/div[3]/button[1]")));
        SetNewPass.click();

// Wait for OTP input
        WebElement OTPfetch = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@aria-label='OTP Input 1']")));


// ---- Switch back to Yopmail (2nd window) ----
        driver.switchTo().window(secondWindow);
        driver.navigate().refresh();

// Extract OTP
        driver.switchTo().frame("ifmail");
        String emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail"))).getText();
        System.out.println("Email Content:\n" + emailBody);

// Assuming OTP is 6 digits
        String otp = emailBody.replaceAll("[^0-9]", "").substring(0, 6);
        System.out.println("Fetched OTP: " + otp);


// ---- Switch again to Reset Pass (3rd window) ----
        driver.switchTo().window(thirdWindow);

// Enter OTP
        for (int i = 0; i < otp.length(); i++) {
            WebElement otpInput = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@aria-label='OTP Input " + (i + 1) + "']")));
            otpInput.sendKeys(Character.toString(otp.charAt(i)));
        }

        System.out.println("✅ OTP entered successfully");
    }
}