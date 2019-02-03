package pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;
    public PageFactory(WebDriver driver)
    {
        this.driver = driver;
    }

    public HomePage getHomePage()
    {
       return new HomePage(driver);

    }
    public CompareProductsPage getCompareProducts()
    {
        return new CompareProductsPage(driver);

    }
}
