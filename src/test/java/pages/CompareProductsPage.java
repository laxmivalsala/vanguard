package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareProductsPage {

    WebDriver driver;
    Commands command;
    public CompareProductsPage(WebDriver driver)
    {
        this.driver = driver;
        command = new Commands(driver);
    }
    By comparePageTitle = By.cssSelector("#fcImage h2");
    By addFundButton = By.id("addButton0");
    By CompareButton = By.id("compareFundBtn");


    public CompareProductsPage verifyFunds(String productType)
    {
        command.waitForPageLoad();
        command.waitForElementVisible(comparePageTitle);
        command.click(addFundButton);
        selectProductType(productType);

        selectRecordsBasedOnCategory("Equity Australia Large Blend",1);
        selectRecordsBasedOnCategory("Equity Australia Real Estate",1);
        selectRecordsBasedOnCategory("Multisector Moderate",1);
        selectRecordsBasedOnCategory("Multisector Growth",1);

        command.click(CompareButton);

        getAttributes("12 month yield");
        return this;
    }

    public void selectProductType(String productType)
    {
        By productTypeRadio = By.xpath("//input[@value='"+productType+"']");
        command.click(productTypeRadio);

    }


    /***
     * read the Compare funds table, and selects records based on the no :of selections supplied
     * @param category
     * @param noOfSelections
     */
    public void selectRecordsBasedOnCategory(String category,int noOfSelections)
    {
        By fundsTable = By.cssSelector("table.fundNameSelector");

        WebElement table = driver.findElement(fundsTable);
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        int counter=0;
        int clickCounter = 0;
        for (WebElement row:rows)
        {
            if(counter > 2) //to skip the header rows
            {
                WebElement c = row.findElements(By.tagName("td")).get(3);
                String categoryName = c.getText();
                List<String> values = new ArrayList<>();
                values.add(categoryName);

                System.out.println( "Category Cell : " +c.getText());
                if(categoryName.equalsIgnoreCase(category))
                {
                    if(clickCounter<=noOfSelections)   // to restrict the maximum no of selections
                    {
                        row.findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).click();
                    }
                    clickCounter+=1;
                   // break;
                }
            }
            counter+=1;

        }

    }



    public void getAttributes(String productName)
    {
        By productFact = By.xpath("//strong[text()='"+productName+"']//ancestor::tr//td");
        List <WebElement> e = driver.findElements(productFact);
        e.remove(0);
        ArrayList alist = new ArrayList();
        String s;
        for(WebElement e1 : e)
        {
            s=e1.getText().replace("%","").trim();
            System.out.println(e1.getText());
            alist.add(Double.parseDouble(s));
            ;


        }
        System.out.println("max value   "+Collections.max(alist));
    }

}
