package org.example;

import org.apache.hc.core5.http.io.SessionOutputBuffer;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class EmailIdTest extends driverSetup {
    @Test
    public void resetPassword() throws InterruptedException, IOException, AWTException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String[] emails = {
                "pavan815@yopmail.com",
                "john815@yopmail.com",
                "smith217@yopmail.com",
                "sunny007@yopmail.com",
                "sunil008@yopmail.com",
                "first@yopmail.com",
                "jack010@yopmail.com",
                "jiten013@yopmail.com",
                "amar014@yopmail.com",
                "martin015@yopmail.com",
                "julie016@yopmail.com",
                "colin018@yopmail.com",
                "tom021@yopmail.com",
                "Pm023@yopmail.com",
                "Pm025@yopmail.com",
                "Pm026@yopmail.com",
                "Pm027@yopmail.com",
                "brian028@yopmail.com",
                "romola030@yopmail.com",
                "ralph031@yopmail.com",
                "john032@yopmail.com",
                "firstnamelastname@yopmail.com",
                "nick034@yopmail.com",
                "pm037@yopmaill.com",
                "sadie038@yopmail.com",
                "binnie039@yopmail.com",
                "jeremy040@yopmail.com",
                "joseph041@yopmail.com",
                "amia042@yopmail.com",
                "jessy043@yopmail.com",
                "bobby044@yopmail.com",
                "alec046@yopmail.com",
                "alma047@yopmail.com",
                "helen048@yopmail.com",
                "ernest053@yopmail.com",
                "will054@yopmail.com",
                "tamsin055@yopmail.com",
                "peter056@yopmail.com",
                "juno058@yopmail.com",
                "robert060@yopmail.com",
                "ralph062@yopmail.com",
                "Chrissie063@yopmail.com",
                "susan064@yopmail.com"
        };


        for (String emailId : emails) {

//        1st window is opened.
        driver.get("https://dev.app.rukkor.com/login");

        Thread.sleep(1000);

        WebElement chooseresetPass = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"loginForm\"]/div[2]/button[2]")));
        chooseresetPass.click();

        WebElement EnterEmail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ResetPassword_email")));
        EnterEmail.sendKeys(emailId);

        System.out.println("Reset pass email sent" + " " + emailId);

        WebElement ResetBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        ResetBtn.click();

        Thread.sleep(1000);

        String rndAttach = RandomUtils.randomAlphanumeric(8);
            File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(rndAttach + ".png");

            FileHandler.copy(shot, dest);
            System.out.println("Screenshot taken at destination folder :-" + dest.getAbsolutePath());

            Thread.sleep(1000);

            ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");

        }
}}