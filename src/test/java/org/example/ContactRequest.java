package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class ContactRequest extends rukkor_login {

    @Test
    public void contactRequest1() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("daniel217@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest2() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("michael217@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest3() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("ben005@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest4() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("sunny007@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest5() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("sunil008@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest6() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("first@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest7() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("jack010@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest8() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("jesica011@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest9() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("jatinp@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }
    @Test
    public void contactRequest10() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

// 2. Click on "Connect as" dropdown
        WebElement connectAs = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"Layout\"]/div/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/form/div[1]/div/div/div/div/div/div")));
        connectAs.click();

        WebElement DropDn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='ant-select-item-option-content' and text()='Real Id']")));
        DropDn.click();
        Thread.sleep(500);

        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(
                By.name("userName")));
        email.sendKeys("jiten013@yopmail.com");

        WebElement AddBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='submit']//span[@class='ant-btn-icon']//*[name()='svg']")));
        AddBtn.click();

        Thread.sleep(1000);

    }

}
