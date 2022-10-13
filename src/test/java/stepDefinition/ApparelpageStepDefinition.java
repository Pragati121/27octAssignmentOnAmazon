package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ApparelpageStepDefinition extends BaseCLass{
    @Given("Go to the Home Page")
    public void go_to_the_home_page() {
       setUpDriver("Chrome");
    }
    @And("Click On Apparel and then shoes")
    public void click_on_apparel_and_then_shoes() {
       pageFactory.getApparel().clickOnAparelOption();
    }
    @And("Sort Shoes According To Price and add any shoes")
    public void sort_shoes_according_to_price_and_add_any_shoes() {
     pageFactory.getApparel().clickOnPricedropdownOption();
    }
}
