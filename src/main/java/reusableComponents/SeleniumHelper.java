package reusableComponents;

import managers.FileReaderManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumHelper {

    WebDriver driver;
    long explicitWait = FileReaderManager.getInstance().getConfigReader().getExplicitWait();
    WebDriverWait wait;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForTheElementToBeClickable(By loc) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
        wait.until(ExpectedConditions.elementToBeClickable(loc));
    }

    public void waitForElementToBeVisible(By loc) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
    }

    public void waitForVisibility(WebElement ele) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public void enterInputText(By loc, String text) {
        try {
            driver.findElement(loc).sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Unable to enter Input text");
        }
    }

    public void verifyText(By loc, String expectedText) {
        try {
            String actualText = driver.findElement(loc).getText();
            Assert.assertEquals(actualText.trim(), expectedText.trim());
        } catch (Exception e) {
            throw new RuntimeException("Unable to get Text Value");
        }
    }

    public void verifyLabel(By loc, String expectedText) {
        try {
            String actualText = driver.findElement(loc).getText();
            Assert.assertEquals(actualText.trim(), expectedText.trim());
        } catch (Exception e) {
            throw new RuntimeException("Unable to get Label Value");
        }
    }

    public void verifyExpectedAndActualResult(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }

    public void clearText(By loc) {
        try {
            driver.findElement(loc).clear();
        } catch (Exception e) {
            throw new RuntimeException("Unable to clear Text");
        }
    }

    public boolean isEnabled(By loc) {
        return driver.findElement(loc).isEnabled();
    }

    public boolean isDisplayed(By loc) {
        return driver.findElement(loc).isDisplayed();
    }

    public boolean isSelected(By loc) {
        return driver.findElement(loc).isSelected();
    }

    public void click(By loc) {
        try {
            driver.findElement(loc).click();
        } catch (Exception e) {
            throw new RuntimeException("Unable to clickable");
        }
    }

    public void clickUsingJavaScriptExecutor(By loc) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", driver.findElement(loc));
        } catch (Exception e) {
            throw new RuntimeException("Unable to click");
        }
    }

    public void selectValueByVisibleText(By loc, String visibleText) {
        try {
            WebElement ele = driver.findElement(loc);
            Select sel = new Select(ele);
            sel.selectByVisibleText(visibleText);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select");
        }
    }

    public void selectValueByIndex(By loc, int index) {
        try {
            WebElement ele = driver.findElement(loc);
            Select sel = new Select(ele);
            sel.selectByIndex(index);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select");
        }
    }

    public void selectByValue(By loc, String value) {
        try {
            WebElement ele = driver.findElement(loc);
            Select sel = new Select(ele);
            sel.selectByValue(value);
        } catch (Exception e) {
            throw new RuntimeException("Unable to select");
        }
    }

    public String getAttributeValue(By loc, String attribute) {
        try {
            return driver.findElement(loc).getAttribute(attribute);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get Attribute");
        }
    }

    public String getText(By loc) {
        try {
            String text = driver.findElement(loc).getText();
            return text;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get Text");
        }
    }

    public void windowScrollIntoView(By loc) {
        try {
            WebElement ele = driver.findElement(loc);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView()", ele);
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll to the view");
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void selectValueFromList(By loc, String expected) {
        List<WebElement> list = driver.findElements(loc);
        for (WebElement ele : list) {
            if (ele.getText().equalsIgnoreCase(expected)) {
                ele.click();
            }
        }
    }

    public void mouseHover(By loc) {
        Actions act = new Actions(driver);
        WebElement ele = driver.findElement(loc);
        act.moveToElement(ele).build().perform();
    }

    public String getRandomAlphabet(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public String getRandomNumeric(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public String getRandomAlphaNumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count);
    }

    public boolean isListSorted(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String current = list.get(i);
            String next = list.get(i + 1);
            if (current.compareTo(next) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isListSortedAsc(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String current = list.get(i);
            String next = list.get(i + 1);
            if (current.compareTo(next) < 0) {
                return false;
            }
        }
        return true;
    }

    public void clickTabKey(By loc) {
        driver.findElement(loc).sendKeys(Keys.TAB);
    }

    public void clickDeleteKey(By loc) {
        driver.findElement(loc).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return driver.getTitle();
    }

    public int getCountOfWindowOpened() {
        Set<String> allWindowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(allWindowHandles);
        return tabs.size();
    }

    public void switchToChildWindow(){
        String parent = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> itr = allWindowHandles.iterator();
        while (itr.hasNext()){
            String ChildWindow = itr.next();
            if (!parent.equalsIgnoreCase(ChildWindow)){
                driver.switchTo().window(ChildWindow);
            }
        }
    }

    public void switchToParentWindow(){
        String parent = driver.getWindowHandle();
        driver.switchTo().window(parent);
    }

    public String passwordValue(){
        return "Qwerty@123456";
    }
}
