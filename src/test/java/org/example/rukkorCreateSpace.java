package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class rukkorCreateSpace extends rukkor_login {

    @Test
    public void CreateSpace() throws InterruptedException, IOException {

//        Create space functionaolity
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String rndName1 = RandomUtils.randomAlpha(5);
        String rndFileName1 = rndName1 + ".png";
        String rndName2 = RandomUtils.randomAlpha(5);
        String rndFileName2 = rndName2 + ".png";
        String rndName3 = RandomUtils.randomAlpha(5);
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

        Thread.sleep(500);


    }

    @Test (dependsOnMethods = {"CreateSpace"})
    public void Chat() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String rndName4 = RandomUtils.randomAlpha(5);
        String rndFileName4 = rndName4 + ".png";
        String rndName5 = RandomUtils.randomAlpha(5);
        String rndFileName5 = rndName5 + ".png";

        Actions actions = new Actions(driver);
        WebElement selectSpace = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[1]/div/div/span/div/span")));
        actions.moveToElement(selectSpace).pause(Duration.ofSeconds(1)).perform();
        selectSpace.click();

        Thread.sleep(500);

        File shot4 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest4 = new File(rndFileName4);

        FileHandler.copy(shot4,dest4);
        System.out.println("Screenshot Saved : " + dest4.getAbsolutePath());

        Thread.sleep(500);

        WebElement Flow = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[1]/div/div/div[2]/div/div[3]/div/div/div/div[1]/span[3]")));
        actions.moveToElement(Flow).pause(Duration.ofSeconds(1)).perform();
        Flow.click();

        WebElement Inputbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        actions.moveToElement(Inputbox).pause(Duration.ofSeconds(1)).perform();
        Inputbox.click();
        Inputbox.sendKeys("Good morning");

        Thread.sleep(500);

        File shot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest5 = new File(rndFileName5);

        FileHandler.copy(shot5,dest5);
        System.out.println("Screenshot Saved : " + dest5.getAbsolutePath());

        Thread.sleep(500);

        WebElement Inputbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        Inputbox1.sendKeys(Keys.ENTER);

        WebElement Attachment = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"call-container\"]/div[2]/div/div[2]/div[2]/button[3]")));
        Attachment.click();

        WebElement UploadPic = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[type='file']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", UploadPic);
        UploadPic.sendKeys("C:\\Users\\Pavan Marathe\\Desktop\\tiger123.jpg");

//        Wait for upload file
        Thread.sleep(5000);

        WebElement upload1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        upload1.sendKeys(Keys.ENTER);


        File shot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest6 = new File("NewFile.png");

        FileHandler.copy(shot6,dest6);
        System.out.println("Screenshot Saved : " + dest6.getAbsolutePath());

        Thread.sleep(1000);

    }
}
