package org.example;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeLoop extends driverSetup {

    @Test

    public void performLogin() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
/*
        for (int i = 0; i < emails.size(); i++) {
            try {
                container = wait.until(ExpectedConditions
                        .presenceOfElementLocated(By.cssSelector(".contact_bar_image")));

                // 👉 Do your main logic here

            } catch (TimeoutException e) {
                System.out.println("❌ No request container found for iteration " + i);

                // clear storage + refresh
                ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
                driver.navigate().refresh();

                // 👉 Go to next loop iteration (skip rest of current loop)
                continue;
            }


        }*/
    }
}
