package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Set;

public class Commands {

    private WebDriver driver;
    private WebDriverWait wait;
    private int timeOut = 30;
    public Commands(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver,timeOut);
    }

    public void navigateToUrl(String url)
    {
        driver.navigate().to(url);
    }

    public void clickByLink(String linkText) {
        try {
            driver.findElement(By.linkText(linkText)).click();
        }
        catch (Exception e)
        {
            System.out.println("cannot click on link "+linkText);
            throw e;

        }
    }

    public void waitForElementVisible(By element)
    {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        }
        catch (Exception e)
        {
            System.out.println("Element not visible "+element );
            throw e;

        }
    }
    public void forceWait(int timeOutInSecs)
    {
        try{
            Thread.sleep(timeOutInSecs*1000);

        }
        catch(Exception e)
        {

        }
    }
    public void click(By element)
    {
        driver.findElement(element).click();
    }

    public void switchToWindow(int win) {
        forceWait(3); //switch window fails in firefox hence wait
        int winCounter = 1;
        Set<String> windows =  driver.getWindowHandles();
        for(String window:windows)
        {
            if(winCounter==win) {
                System.out.println(window);
                driver.switchTo().window(window);
                System.out.println(driver.getTitle());
                return;
            }
            winCounter+=1;
        }


    }
    public void waitForPageLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        wait.until(pageLoadCondition);
    }
}
