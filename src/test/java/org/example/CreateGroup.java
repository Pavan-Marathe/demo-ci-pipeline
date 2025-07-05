package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CreateGroup {

        WebDriver driver;

        @BeforeTest

        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        //	Run First text case
        @Test

        public void test_CC_Channel() throws InterruptedException, IOException {

            driver.get("https://carecoordinations.com/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


            WebElement UserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
            UserName.sendKeys("joseph.sa@yopmail.com");

            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("Nexi$123");

            WebElement Logged = wait.until(ExpectedConditions.elementToBeClickable(By.id("FinalCommonLoginBtn")));
            Logged.click();

            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ccChannelListingsSection\"]/div[2]/div[2]/div[9]/div[2]/div"))).click();

            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("channelInputSearch"))).sendKeys("salina carpenter");
            //*[@id="channelInputSearch"]

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ccChannelListingsSection\"]/div[2]/div[2]/div/div[2]/div"))).click();

            Thread.sleep(3000);

        }

        //	Automate Second Step
        @Test (dependsOnMethods = {"test_CC_Channel"})

        public void test_CC_MoreMenu() throws InterruptedException, IOException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

//	    Error
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ccChannelListingsSection\"]/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div[4]/div[2]"))).click();

            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ccChannelMoreMenuCloneContainer\"]/div/span/div/div/div[2]"))).click();


            //*[@id="ccChannelMoreMenuCloneContainer"]/div/span/div/div/div[2]
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"channelInfoModal\"]"))).click();

            Thread.sleep(2000);
            //*[@id="channelInfoModal"]

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"channelModalContent6919\"]/div/div[1]/button"))).click();
            //*[@id="channelModalContent6919"]/div/div[1]/button

            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("channelInputSearch"))).clear();
            //*[@id="chat-search-clear-icon"]/label/svg/circle

            Thread.sleep(4000);

        }

        //	Automate Third text case
        @Test (dependsOnMethods = {"test_CC_MoreMenu"})

        public void test_CC_GroupChannel() throws InterruptedException, IOException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("createChannelButton"))).click();

            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"createChannelMenuContainer\"]/div[2]/div[2]/div"))).click();

            //*[@id="createChannelMenuContainer"]/div[2]/div[2]/div

            Thread.sleep(2000);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("patient_name"))).sendKeys("SmartGroup");

            //*[@id="checkbox-sa-MTE0NA=="]

            Thread.sleep(1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;

            //*[@id="checkbox-role-22"]
            js.executeScript("window.scrollBy(0,1300)");

            Thread.sleep(2000);

//		Select the users from a list.
//*[@id="checkbox-sa-MTAzMA=="]
//*[@id="checkbox-sa-MTAyNQ=="]

            wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-sa-MTAzMA=="))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-sa-MTAyNQ=="))).click();

            Thread.sleep(2000);

            js.executeScript("window.scrollBy(0,1000)");

            Thread.sleep(2000);

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            File destination = new File("CC_01.png");
            FileHandler.copy(source, destination);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-sa-MTA0Ng=="))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox-sa-MTE2OA=="))).click();

            //*[@id="checkbox-sa-MTE2OA=="]
            //*[@id="checkbox-sa-MTA0Ng=="]

            wait.until(ExpectedConditions.elementToBeClickable(By.id("createGroupBrodCastChannelBtn"))).click();

            Thread.sleep(4000);

            System.out.println("Multiple checkbox Selected" + driver.getTitle());


            //*[@id="createGroupBrodCastChannelBtn"]




        }

        @AfterTest

        public void tearDown() {

            if(driver != null);
            Assert.assertNotNull(driver);
            driver.quit();
        }


    }


