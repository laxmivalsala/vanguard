package hooks;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public class ScenarioHooks {
    private WebDriver driver ;

    @Before
    public void initialise()
    {
        try {
            String browser = new PropertyReader().readProperty("browser");
            openBrowser(browser);
        }
        catch (Exception e)
        {

        }

    }

    @After
    public void cleanUp()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }

    private void openBrowser(String browser) throws Exception {
        switch (browser.toUpperCase())
        {
            case "FIREFOX" :
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\lib\\Gecko\\geckodriver-23.exe");
                driver = new FirefoxDriver();
                break;
            case "CHROME" :
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\lib\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                throw new Exception(browser +"browser not supported");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();


    }

    /***
     * expose the webdriver
     * @return
     */
    public WebDriver getDriver()
    {
        return this.driver;
    }
}
