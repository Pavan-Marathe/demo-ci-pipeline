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

        FileHandler.copy(shot1, dest1);
        System.out.println("Screenshot Saved : " + dest1.getAbsolutePath());

        Thread.sleep(500);

        WebElement CreateSpace = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-cy='create-space-menu-item']")));
        CreateSpace.click();

        WebElement Community = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-cy='community-space-content'] p[class='option-description']")));
        Community.click();

        WebElement RealID = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div[data-cy='real-id-content'] p[class='option-description']")));
        RealID.click();

        WebElement Upload = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("span.ant-upload")));
        Upload.click();

        Thread.sleep(500);
        WebElement UploadPic = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[type='file']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", UploadPic);
        UploadPic.sendKeys("C:\\Users\\Pavan Marathe\\Desktop\\tiger123.jpg");

        WebElement UploadOK = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".ant-modal-footer > button:nth-child(2)")));
        UploadOK.click();

        String rndSpaceName = "Jay" + rndName1;
        WebElement spaceName = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("spaceName")));
        spaceName.sendKeys(rndSpaceName);

        Thread.sleep(500);

        File shot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest2 = new File(rndFileName2);

        FileHandler.copy(shot2, dest2);
        System.out.println("Screenshot Saved : " + dest2.getAbsolutePath());

        Thread.sleep(500);

        WebElement createSpace = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.ant-btn-primary:nth-child(2)")));
        createSpace.click();

//        Actions action = new Actions(driver);
        WebElement Skip = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/div[2]/div/div[3]/button")));
//        action.moveToElement(Skip).pause(Duration.ofSeconds(1)).perform();
        Skip.click();

    }

    @Test (dependsOnMethods = {"CreateSpace"})
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
//                By.xpath("//button[@type='button']//span[contains(text(),'Create')]")));
                By.xpath("/html/body/div[6]/div/div[2]/div/div[1]/div/div[3]/button[2]")));
//        By.xpath("/html/body/div[7]/div/div[2]/div/div[1]/div/div[3]/button[2]")));

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

    @Test (dependsOnMethods = {"SelectCatTree"})
    public void chatMediaAttach() throws InterruptedException,IOException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions actions = new Actions(driver);
        WebElement Inputbox = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        actions.moveToElement(Inputbox).pause(Duration.ofSeconds(1)).perform();
        Inputbox.click();
        Inputbox.sendKeys("Good morning! Have a nice day today......");

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
        UploadPic.sendKeys("D:\\SetProfileImage\\0c8e446907e7153c94d4c1ffb1df1343.jpg");
        UploadPic.sendKeys("D:\\SetProfileImage\\fc1d01bb-5d2b-4422-bdb0-276ff7252e6e.jpg");
        UploadPic.sendKeys("D:\\SetProfileImage\\pexels-cottonbro-5378700.jpg");

//        Wait for upload file
        Thread.sleep(10000);

        WebElement upload1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"call-container\"]/div[2]/div/div[3]/div[2]/button[4]")));
        upload1.click();

        //*[@id="call-container"]/div[2]/div/div[3]/div[2]/button[4]
//        WebElement upload1 = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
//        upload1.sendKeys(Keys.ENTER);

        WebElement Inputbox2 = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"tiptapcontent\"]/div/p")));
        Inputbox2.sendKeys("All the files are uploaded");
        Inputbox2.sendKeys(Keys.ENTER);

        String rndFileName6 = RandomUtils.randomAlpha(5);
        File shot6 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest6 = new File(rndFileName6 + ".png");

        FileHandler.copy(shot6,dest6);
        System.out.println("Screenshot Saved : " + dest6.getAbsolutePath());

        Thread.sleep(1000);


    }


}
