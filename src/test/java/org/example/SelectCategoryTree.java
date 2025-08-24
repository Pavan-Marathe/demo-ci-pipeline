package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectCategoryTree extends rukkor_login {

    @Test
    public void SelectCatTree() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


//      Locate all avatars inside the nav list
        List<WebElement> avatars = driver.findElements(By.cssSelector(".ant-tabs-nav-list .ant-tabs-tab-btn"));

// Pick the 3rd avatar (index 2)
        WebElement avatar = avatars.get(2);

// Hover over the avatar
        Actions actions = new Actions(driver);
        actions.moveToElement(avatar).perform();

// Wait for tooltip / hover name to appear
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".ant-tooltip-inner")));   // adjust selector if tooltip has a different class
        System.out.println("Avatar hover name: " + tooltip.getText());

// (Optional) Click avatar after hover
        avatar.click();

//        Select category tree there
//        WebElement treeWrapper = driver.findElement(By.cssSelector("div.spaceTreeWrapper"));

        List<WebElement> categories = driver.findElements(By.cssSelector("div.spaceTreeWrapper .ant-tree-treenode"));

        WebElement category = driver.findElement(By.xpath("//span[contains(text(),'NzQSsnjGdb')]"));
        category.click();
        actions.contextClick(category).perform();

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
        flowDesc.sendKeys("Description is here.");

        WebElement CreateBtnFlow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@type='button']//span[contains(text(),'Create')]")));
        CreateBtnFlow.click();

        Thread.sleep(2000);
        WebElement flow = driver.findElement(By.xpath("//span[contains(text(),'Flow_02')]"));
        flow.click();
        Thread.sleep(2000);
        WebElement branch = driver.findElement(By.xpath("//span[contains(text(),'Branch_02')]"));
        branch.click();
        Thread.sleep(2000);


//        public void clickTreeItem(String itemName) {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            WebElement item = wait.until(ExpectedConditions.elementToBeClickable(
//                    By.xpath("//span[contains(text(),'" + itemName + "')]")));
//            item.click();
//        }
//
//        clickTreeItem("NzQSsnjGdb");  // Category
//        clickTreeItem("Flow_02");     // Flow
//        clickTreeItem("Branch_02");   // Branch



    }

}
