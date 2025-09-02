package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class looping_ContactRequest extends rukkor_login {

    @Test
    public void contactRequests() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // List of test emails
        String[] emails = {
//                Email reg. users
                "john815@yopmail.com",
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

            // Click on "Connect as" dropdown
            WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
            connectAs.click();

            // Select "Real Id"
            WebElement dropDn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
            dropDn.click();
            Thread.sleep(500);

            // Enter email
            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.name("userName")));
            email.sendKeys(emailId);

            // Click Add button
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@type='submit']")));
            addBtn.click();

            Thread.sleep(1500);
        }
    }


}
