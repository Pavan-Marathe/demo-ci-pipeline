package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ChatFlow extends rukkor_login {

    @Test /*(dependsOnMethods = {"CreateSpace"})*/
    public void SelectCatTree() throws InterruptedException, IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//      Locate all avatars inside the nav list
        List<WebElement> avatars = driver.findElements(By.cssSelector(".ant-tabs-nav-list .ant-tabs-tab-btn"));

//        Pick last avtar here
        if (!avatars.isEmpty()) {
            WebElement lastAvatar = avatars.get(avatars.size() - 1); // last element
            // Hover over the avatar
            Actions actions = new Actions(driver);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior : 'smooth', block : 'center'});", lastAvatar);
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();" , lastAvatar);
            actions.moveToElement(lastAvatar).perform();
            lastAvatar.click();
        } else {
            System.out.println("No avatars found!");
        }

        WebElement SpaceMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".svg-inline--fa.fa-angle-down")));
        SpaceMenu.click();

        List<WebElement> SpaceArrowContent = driver.findElements(By.cssSelector("body > div:nth-child(4) > div"));
        WebElement CreateCat = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(text(),'Create Category')]")));
        CreateCat.click();

        String rndCatName = RandomUtils.randomAlpha(10);
        String catNameEnter = "Cat" + rndCatName;
        WebElement CatName = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("formcategory_name")));
        CatName.sendKeys(catNameEnter);

        System.out.println("Created Category name is :- " + catNameEnter);

        WebElement Createbtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='button']//span[contains(text(),'Create')]")));
        Createbtn.click();

        List<WebElement> categories = driver.findElements(By.cssSelector("div.spaceTreeWrapper .ant-tree-treenode"));

        if (!categories.isEmpty()) {
            Actions actions = new Actions(driver);
        WebElement CatMenu = driver.findElement(By.xpath("//span[contains(text(),'" + catNameEnter + "')]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior : 'smooth', block : 'center'});", CatMenu);
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();" , CatMenu);
            actions.moveToElement(CatMenu).perform();
            CatMenu.click();
            actions.contextClick(CatMenu).perform();
        } else {
            System.out.println("No categories found!");
        }

        Thread.sleep(500);

        Actions actions = new Actions(driver);
        List<WebElement> CatOpt = driver.findElements(
                By.cssSelector("body > div.ant-dropdown.spaceTreeContextMenu.css-7tbn6o.ant-dropdown-placement-rightTop > ul"));
        WebElement catOptionsCreateFlow = driver.findElement(By.xpath("//span[contains(text(),'Create Flow')]"));
//        Click event is not woking here
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", catOptionsCreateFlow);

        Thread.sleep(1000);

// Click to open dropdown
        WebElement catdropDown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='formflow']/div/div[1]/div")));
        catdropDown.click();

// Now select the option (Ant Design renders options as div/span inside dropdown)
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'ant-select-item-option-content') and text()='" + catNameEnter + "']")));
        // Scroll into view and click
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
        option.click();

        String rndFlowName = RandomUtils.randomAlpha(10);
        WebElement FlowName = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("formflow_name")));
        FlowName.sendKeys("Flow" + rndFlowName);

        System.out.println("Created Flow name : " + "Flow" + rndFlowName );

        WebElement pvtFlowToggle = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"formflow\"]/div/div[3]/div[1]/button")));
        pvtFlowToggle.click();

        WebElement flowDesc = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("formflow_desc")));
        flowDesc.sendKeys("Description is here. Good morning team");

        Thread.sleep(1000);

        WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='button']//span[contains(text(),'Create')]")));
        //button[@type='button']//span[contains(text(),'Create')]
        createBtn.click();

        WebElement Inputbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        actions.moveToElement(Inputbox).pause(Duration.ofSeconds(1)).perform();
        Inputbox.click();
        Inputbox.sendKeys("Good morning");

        Thread.sleep(500);

        String rndFileName5 = RandomUtils.randomAlpha(5);
        File shot5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest5 = new File(rndFileName5 + ".png");

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

        String rndFileName6 = RandomUtils.randomAlpha(5);
        File shot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest6 = new File(rndFileName6 + ".png");

        FileHandler.copy(shot6,dest6);
        System.out.println("Screenshot Saved : " + dest6.getAbsolutePath());

        Thread.sleep(1000);



    }

}
