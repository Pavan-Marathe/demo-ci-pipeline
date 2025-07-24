package org.example;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SelectSpace extends rukkor_login {

    @Test /*(dependsOnMethods = {"CreateSpace"})*/
    public void inviteMember() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions actions = new Actions(driver);
        WebElement selectSpace = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[1]/div/div/span/div/span")));
        actions.moveToElement(selectSpace).pause(Duration.ofSeconds(1)).perform();
        selectSpace.click();

        WebElement Flow = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[1]/div/div/div[2]/div/div[3]/div/div/div/div[1]/span[3]")));
        actions.moveToElement(Flow).pause(Duration.ofSeconds(1)).perform();
        Flow.click();

        WebElement Inputbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        actions.moveToElement(Inputbox).pause(Duration.ofSeconds(1)).perform();
        Inputbox.click();
        Inputbox.sendKeys("Good morning");

        WebElement Inputbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        Inputbox1.sendKeys(Keys.ENTER);

        WebElement Attachment = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"call-container\"]/div[2]/div/div[2]/div[2]/button[3]")));
        Attachment.click();

        WebElement UploadPic  = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[type='file']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", UploadPic);
        UploadPic.sendKeys("C:\\Users\\Pavan Marathe\\Desktop\\tiger123.jpg");

//        Wait for upload file
        Thread.sleep(5000);

        WebElement upload1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        upload1.sendKeys(Keys.ENTER);


//        WebElement SelectRole = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[@id=\"rc_select_6\"]")));
//        actions.moveToElement(SelectRole).pause(Duration.ofSeconds(1)).perform();
//        SelectRole.click();
//
//
//        WebElement SelectRole1 = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[@id=\"rc_select_6\"]")));
//        actions.moveToElement(SelectRole1).pause(Duration.ofSeconds(1)).perform();
//        Select DropDown = new Select(SelectRole1);
//        DropDown.selectByVisibleText("Member");
//
//        WebElement Email = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[@id=\"rc_select_7\"]")));
//        actions.moveToElement(Email).pause(Duration.ofSeconds(1)).perform();
//        Email.sendKeys("smith217@yopmail.com");
//
//
//        WebElement AddMember = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[1]/div[1]/form/button[1]")));
//        actions.moveToElement(AddMember).pause(Duration.ofSeconds(1)).perform();
//        AddMember.click();



        File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("NewFile.png");

        FileHandler.copy(shot,dest);
        System.out.println("Screenshot Saved : " + dest.getAbsolutePath());

        Thread.sleep(1000);

    }
}
