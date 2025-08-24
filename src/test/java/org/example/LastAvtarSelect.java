package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LastAvtarSelect extends rukkor_login {

    @Test
    public void SelectCatTree() throws InterruptedException {

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

        Thread.sleep(1000);

        List<WebElement> categories = driver.findElements(By.cssSelector("div.spaceTreeWrapper .ant-tree-treenode"));

        //        Pick last category here
        if (!categories.isEmpty()) {
            WebElement lastOption = categories.get(categories.size() - 1); // last element
            // Hover over the avatar
//            Actions actions = new Actions(driver);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior : 'smooth', block : 'center'});", lastOption);
            ((JavascriptExecutor) driver).executeScript("arguments[0].focus();" , lastOption);
            Actions actions = new Actions(driver);
            actions.moveToElement(lastOption).perform();
            lastOption.click();
            actions.contextClick(lastOption).perform();
        } else {
            System.out.println("No categories found!");
        }

        List<WebElement> CatOpt = driver.findElements(
                By.cssSelector("body > div.ant-dropdown.spaceTreeContextMenu.css-7tbn6o.ant-dropdown-placement-rightTop > ul"));
        WebElement catOptionsCreateFlow = driver.findElement(By.xpath("//span[contains(text(),'Create Flow')]"));
        catOptionsCreateFlow.click();

        String rndFlowName = RandomUtils.randomAlpha(10);
        WebElement FlowName = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("formflow_name")));
        FlowName.sendKeys(rndFlowName);

        System.out.println("Created Flow name : " + rndFlowName );

        WebElement pvtFlowToggle = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"formflow\"]/div/div[3]/div[1]/button")));
        pvtFlowToggle.click();

        WebElement flowDesc = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("formflow_desc")));
        flowDesc.sendKeys("Description is here. Good morning team");

        WebElement CreateBtnFlow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='button']//span[contains(text(),'Create')]")));
        CreateBtnFlow.click();



    }

}
