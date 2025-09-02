package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class syntax extends driverSetup {

    @Test

    public void test() throws InterruptedException, IOException {

///==========================================================================================================================================
//        For waitting time to catch elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Demo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Example")));
        Actions action = new Actions(driver);
        action.moveToElement(Demo).pause(Duration.ofSeconds(1)).perform();

///==========================================================================================================================================
//        For smooth scrolling
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior : 'smooth', block : 'center'});", Demo);
        js.executeScript("arguments[0].focus();", Demo);

///==========================================================================================================================================
//        For autofocus on element to scrolling.
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Demo);
        ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", Demo);

///==========================================================================================================================================
//        For mouse hovering
        Actions actions = new Actions(driver);
        actions.moveToElement(Demo).pause(Duration.ofSeconds(1)).click().perform();

///==========================================================================================================================================
//        For zoom in zoom out syntax.
        js.executeScript("document.body.style.zoom='80%'");
        js.executeScript("document.body.style.zoom='100%'");

///==========================================================================================================================================
//        Screen Reload
        driver.navigate().refresh();

///==========================================================================================================================================
//        For continue run script with fail running script.
        Assert.fail("Intentional fail");

///==========================================================================================================================================
//        For driver manage window resize.
        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(2300, 720));
        driver.manage().window().fullscreen();
//        For set position
        driver.manage().window().setPosition(new Point(0, 0)); // Move to top-left
        driver.manage().window().setSize(new Dimension(2300, 720)); // Resize

///==========================================================================================================================================
//       assertions
        Assert.assertNotNull(driver, "WebDriver is not initialized.");
        Assert.assertEquals(driver.getTitle(), "Expected Page Title", "Page title does not match.");

///==========================================================================================================================================
//        For scroll by pixel method
        js.executeScript("window.scrollBy(0, 500);");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500);");

///==========================================================================================================================================
//        Scroll to bottom of the page.
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

///==========================================================================================================================================
//        Take Screenshots
        File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("Capture_03.png");

        FileHandler.copy(shot, dest);
        System.out.println("Screenshot taken at destination folder :-" + dest.getAbsolutePath());



///==========================================================================================================================================
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


///==========================================================================================================================================
//      Step 4: Open YOPmail in new tab to get OTP
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB); // Open new tab window.
        driver.get("https://yopmail.com/en/");

//      Store the main window
        String firstWindow = driver.getWindowHandle();


///==========================================================================================================================================
//      Store second window handle
        String secondWindow = "";
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(firstWindow)) {
                secondWindow = win;
            }
        }
//        For switch on second window handle
        driver.switchTo().window(secondWindow);


///==========================================================================================================================================
//        For get copy syntax
        String emailBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail"))).getText();
        String otp = emailBody.replaceAll("[^0-9]", "").substring(0, 6);


///==========================================================================================================================================
//      Normally we can apply sendkeys to paste anything there.
        WebElement otpBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("otpInput")));
        otpBox.sendKeys(otp);

///==========================================================================================================================================
//        For use normal and incognito window with symuteniously
// Normal window (Account A) // Login Account A in driver1
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://yourapp.com/login");


///==========================================================================================================================================
// Incognito window (Account B) // Login Account B in driver2
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver2 = new ChromeDriver(options);
        driver2.get("https://yourapp.com/login");


///==========================================================================================================================================
//        For select a frame include selectable options
        List<WebElement> categories = driver.findElements(By.cssSelector("div.spaceTreeWrapper .ant-tree-treenode"));

///==========================================================================================================================================
//        Now Select any option with mention like "NzQSsnjGdb" included in frame
        WebElement category = driver.findElement(By.xpath("//span[contains(text(),'NzQSsnjGdb')]"));
        category.click();
///==========================================================================================================================================
//        For apply fast clicking event where clicking isn't working fine
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", category);


///==========================================================================================================================================
//        For Select any one xpath from the both we can set by this way
             WebElement createBtn;
        try {
            createBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[6]/div/div[2]/div/div[1]/div/div[3]/button[2]")));
        } catch (TimeoutException e) {
            createBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/div[7]/div/div[2]/div/div[1]/div/div[3]/button[2]")));
    }
        createBtn.click();

///==========================================================================================================================================
//Dropdown handling method for ant design
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

///==========================================================================================================================================
//        For validate multiple xpath there
        WebElement acceptBtn;
        try {
            // First XPath
            acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("OPtion 1"))
            );
        } catch (TimeoutException e1) {
            try {
                // Second XPath
                acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("OPtion 2"))
                );
            } catch (TimeoutException e2) {
                // Third XPath
                acceptBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("OPtion 3")));
            }
        }

        acceptBtn.click();
///==========================================================================================================================================
//        Same another way with looping method
        String[] xpaths = {
                "OPtion 1",
                "OPtion 2",
                "OPtion 3",
                "OPtion 4"
        };

        WebElement acceptBtn1 = null;
        for (String xpath : xpaths) {
            try {
                acceptBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
                break; // stop at first success
            } catch (TimeoutException e) {
                // try next
            }
        }

        if (acceptBtn1 != null) {
            acceptBtn1.click();
        } else {
            System.out.println("No Accept button found with any XPath.");
        }

///==========================================================================================================================================
//      For Clear local storage
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");

//        Clear cookies of current firstWindow
        driver.manage().deleteAllCookies();

//        Clear session storage
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear();");

///==========================================================================================================================================



    }

}
