package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test01 {

        WebDriver driver;  // ✅ Declare it globally

        @BeforeTest
        public void setup() {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }


        @Test
        public void testWikipedia() throws InterruptedException {

        driver.get("https://www.wikipedia.org/");

            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("Mahabharat");

            WebElement searchButton = driver.findElement(By.cssSelector(".pure-button"));
            searchButton.click();

            Thread.sleep(4000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");

            Thread.sleep(1000);

            js.executeScript("window.scrollBy(0,2000)");

            Thread.sleep(1000);

            js.executeScript("window.scrollBy(0,3000)");

            Thread.sleep(1000);

            js.executeScript("window.scrollBy(0,4000)");

            Thread.sleep(1000);

            js.executeScript("window.scrollBy(0,-10000)");

            Thread.sleep(4000);


        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }
    }



