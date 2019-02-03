package pages;

import org.openqa.selenium.WebDriver;
import utils.Commands;
import utils.PropertyReader;

public class HomePage {
    WebDriver driver;
    Commands commands;
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        commands=new Commands(driver);
    }

    public void selectInvestType(String investType)
    {
        commands.clickByLink(investType);

    }

    public void clickFundCompare()
    {
        commands.clickByLink("Fund compare");
        commands.switchToWindow(2);

    }

    public HomePage navigateToHomePage()
    {
        commands.navigateToUrl(new PropertyReader().readProperty("url"));
        return this;
    }
}
