package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ElectronicPageStepdefintion extends BaseCLass {
    @Given("User is in Home Page")
       public void user_in_the_home_page() throws IOException {
       setUpDriver("Chrome");
       pageFactory.getElectronic().ElectronicsUser();
    }
    @When("click on electronics")
      public void click_on_electronics() {
      pageFactory.getElectronic().ElectronicsUser();
    }
    @When("add product")
      public void add_product() throws InterruptedException {
      pageFactory.getElectronic().ClickOnComputerHyperlinkAndAddItems();
    }
    @When("go to shopping cart page")
      public void go_to_shopping_cart_page() {
      pageFactory.getElectronic().AddItemsToCartAndClickOnShoppingCart();
    }
    @When("click on checkout and add user details")
     public void click_on_checkout_and_add_user_details() {
     pageFactory.getElectronic().ClickOnCheckboxAndCheckoutbuttonAndAddDetails();
     //driver.close();
    }
}
