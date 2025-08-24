package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class signup extends driverSetup {

    @Test
    public void signup() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        Take screenshots for proof
        String rndUserName = RandomUtils.randomAlpha(3);
        String FirstUser = "Sam" + rndUserName ;
        String rndUserName2 = RandomUtils.randomAlpha(3);
        String LastUser2 = "Den" + rndUserName2 ;

        String rndUserName4 = RandomUtils.rndSmallchar(5);
        String randUsername = "sam" + rndUserName4;
        String rndUserName3 = RandomUtils.rndSmallchar(5);
        String emailAdd = "sam" + rndUserName3 + "@yopmail.com" ;

        String rndName1 = RandomUtils.randomAlpha(8);
        String rndFileName1 = rndName1 + ".png";
        String rndName2 = RandomUtils.randomAlpha(8);
        String rndFileName2 = rndName2 + ".png";
        String rndName3 = RandomUtils.randomAlpha(8);
        String rndFileName3 = rndName3 + ".png";

        driver.get("https://dev.app.rukkor.com/signup");
        WebElement first = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupForm_first_name")));
        first.sendKeys(FirstUser);

        WebElement last = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupForm_last_name")));
        last.sendKeys(LastUser2);

        WebElement userName = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupForm_username")));
        userName.sendKeys(randUsername);

        WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupForm_email")));
        emailAddress.sendKeys(emailAdd);

        System.out.println("Random created email is :" + emailAdd);

        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupForm_password")));
        pass.sendKeys("Demo@12345");

        System.out.println("Your pass is :" + "Demo@12345");

        WebElement passConf = wait.until(ExpectedConditions.elementToBeClickable(By.id("signupForm_confirm_password")));
        passConf.sendKeys("Demo@12345");

        WebElement TermChk1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupForm_tos_accept")));
        TermChk1.click();

        WebElement privacyChk2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("signupForm_privacy_policy_accept")));
        privacyChk2.click();

        Thread.sleep(500);

        File shot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest1 = new File(rndFileName1);

        FileHandler.copy(shot1,dest1);
        System.out.println("Screenshot Saved : " + dest1.getAbsolutePath());

        Thread.sleep(500);

        WebElement Signup = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"signupForm\"]/div[10]/button")));
        Signup.click();

        // Step 3: Wait for OTP screen to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='OTP Input 1']")));

        // Step 4: Open YOPmail in new tab to get OTP
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        driver.get("https://yopmail.com/en/");

        String yopmailUser = emailAdd ;
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

        Thread.sleep(500);

        File shot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest2 = new File(rndFileName2);

        FileHandler.copy(shot2,dest2);
        System.out.println("Screenshot Saved : " + dest2.getAbsolutePath());

        Thread.sleep(500);

        System.out.println("✅ OTP entered successfully");
        Thread.sleep(1000);

//        ChooseWithEmail to get on app dashboard
        WebElement ChooseWithEmail = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/div/div[1]/button")));
        ChooseWithEmail.click();


        File shot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest3 = new File(rndFileName3);

        FileHandler.copy(shot3,dest3);
        System.out.println("Screenshot Saved : " + dest1.getAbsolutePath());

        Thread.sleep(500);

        WebElement SignupDone = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div/div[2]/button")));
        SignupDone.click();


    }

    @Test (dependsOnMethods = {"signup"})
    public void CreateSpace() throws InterruptedException, IOException {

//        Create space functionaolity
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        Takes screenshots
        String rndName1 = RandomUtils.randomAlpha(8);
        String rndFileName1 = rndName1 + ".png";
        String rndName2 = RandomUtils.randomAlpha(8);
        String rndFileName2 = rndName2 + ".png";
        String rndName3 = RandomUtils.randomAlpha(8);
        String rndFileName3 = rndName3 + ".png";

        WebElement AddcreateSpace = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-cy='create-space-button']")));
        AddcreateSpace.click();

        Thread.sleep(500);

        File shot1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest1 = new File(rndFileName1);

        FileHandler.copy(shot1,dest1);
        System.out.println("Screenshot Saved : " + dest1.getAbsolutePath());

        Thread.sleep(500);

        WebElement CreateSpace  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-cy='create-space-menu-item']")));
        CreateSpace.click();

        WebElement Community  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-cy='community-space-content'] p[class='option-description']")));
        Community.click();

        WebElement RealID  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-cy='real-id-content'] p[class='option-description']")));
        RealID.click();

        WebElement Upload  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span.ant-upload")));
        Upload.click();

        Thread.sleep(500);
        WebElement UploadPic  = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[type='file']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", UploadPic);
        UploadPic.sendKeys("C:\\Users\\Pavan Marathe\\Desktop\\tiger123.jpg");

        WebElement UploadOK  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".ant-modal-footer > button:nth-child(2)")));
        UploadOK.click();

        String rndSpaceName = "Jay" + rndName1;
        WebElement spaceName  = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("spaceName")));
        spaceName.sendKeys(rndSpaceName);

        Thread.sleep(500);

        File shot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest2 = new File(rndFileName2);

        FileHandler.copy(shot2,dest2);
        System.out.println("Screenshot Saved : " + dest2.getAbsolutePath());

        Thread.sleep(500);

        WebElement createSpace  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.ant-btn-primary:nth-child(2)")));
        createSpace.click();

//        Actions action = new Actions(driver);
        WebElement Skip  = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/button")));
//        action.moveToElement(Skip).pause(Duration.ofSeconds(1)).perform();
        Skip.click();

        Thread.sleep(500);

        File shot3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest3 = new File(rndFileName3);

        FileHandler.copy(shot3,dest3);
        System.out.println("Screenshot Saved : " + dest3.getAbsolutePath());

        Thread.sleep(2000);

    }

}
