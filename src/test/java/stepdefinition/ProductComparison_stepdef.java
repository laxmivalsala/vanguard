package stepdefinition;

import cucumber.api.java.en.Given;
import hooks.ScenarioHooks;
import pages.PageFactory;

public class ProductComparison_stepdef {
PageFactory pageFactory;
ScenarioHooks scenarioHooks;

    public ProductComparison_stepdef(ScenarioHooks scenarioHooks)
    {
        this.scenarioHooks = scenarioHooks;
        pageFactory=new PageFactory(scenarioHooks.getDriver());

    }

    @Given("^I open Vanguard website$")
    public void i_open_Vanguard_website() {
        pageFactory.getHomePage()
                .navigateToHomePage()
                .selectInvestType("Individual & SMSF investors");


    }

    @Given("^I navigate to Funds Compare page$")
    public void i_navigate_to_Funds_Compare_page()  {
        pageFactory.getHomePage().clickFundCompare();

    }

    @Given("^I compare \"([^\"]*)\" products$")
    public void i_compare_products(String productType)   {
        pageFactory.getCompareProducts().verifyFunds(productType);

    }

}
