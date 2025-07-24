package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class syntax extends driverSetup {

    @Test

    public void test() throws InterruptedException, IOException {

        WebElement Demo = driver.findElement(By.xpath("Example"));
        Actions action = new Actions(driver);
        action.moveToElement(Demo).pause(Duration.ofSeconds(1)).perform();

//        For smooth scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior : 'smooth', block : 'center'});", Demo);
        js.executeScript("arguments[0].focus();" , Demo);

//        For autofocus on element to scrolling.
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Demo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", Demo);

//        For mouse hovering
        Actions actions = new Actions(driver);
        actions.moveToElement(Demo).pause(Duration.ofSeconds(1)).click().perform();

//        For zoom in zoom out syntax.
        js.executeScript("document.body.style.zoom='80%'");
        js.executeScript("document.body.style.zoom='100%'");

//        Screen Reload
        driver.navigate().refresh();

//        For continue run script with fail running script.
        Assert.fail("Intentional fail");

//        For driver manage window resize.
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(2300,720));
        driver.manage().window().fullscreen();
//        For set position
        driver.manage().window().setPosition(new Point(0, 0)); // Move to top-left
        driver.manage().window().setSize(new Dimension(2300, 720)); // Resize

//       assertions
        Assert.assertNotNull(driver, "WebDriver is not initialized.");
        Assert.assertEquals(driver.getTitle(), "Expected Page Title", "Page title does not match.");

//        For scroll by pixel method
        js.executeScript("window.scrollBy(0, 500);");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

//        Scroll to bottom of the page.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

//        Take Screenshots
        File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("Capture_03.png");

        FileHandler.copy(shot,dest);
        System.out.println("Screenshot taken at destination folder :-" + dest.getAbsolutePath());


//         Assert
        try {
            /* Script*/

//	   Intentionally fail this test case to verify the report
        	Assert.assertTrue(false, "Intentional failure for testing report");
            Assert.assertTrue(true, "Intentional failure for testing report");

        } catch (Exception e) {
            System.err.println("❌ demoQATest execution failed: " + e.getMessage());
            throw e; // Ensure TestNG marks the test as failed
        }

//      Step 4: Open YOPmail in new tab to get OTP
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB); // Open new tab window.
        driver.get("https://yopmail.com/en/");




    }

}
