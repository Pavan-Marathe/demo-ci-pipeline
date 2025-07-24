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
        WebElement AddcreateSpace = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span[data-cy='create-space-button']")));
        AddcreateSpace.click();

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

        String rndName = RandomUtils.randomAlpha(5);
        WebElement spaceName  = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("spaceName")));
        spaceName.sendKeys("Jay" + rndName);

        WebElement createSpace  = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.ant-btn-primary:nth-child(2)")));
        createSpace.click();

//        Actions action = new Actions(driver);
        WebElement Skip  = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/button")));
//        action.moveToElement(Skip).pause(Duration.ofSeconds(1)).perform();
        Skip.click();


    }

}
