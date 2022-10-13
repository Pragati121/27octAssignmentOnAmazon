package stepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class ApparelPageandElectronicEnm extends  BaseCLass{
    @Given("User is in the Home Page")
    public void user_is_in_the_home_page() {
      setUpDriver("Chrome");
    }
    @And("click on the electronics")
    public void click_on_the_electronics() throws InterruptedException {
    pageFactory.getElectrEnm().ClickOnComputerHyperlinkAndAddItems123();
    }
    @And("add products")
    public void add_products() {
        pageFactory.getElectrEnm().AddItemsToCartAndClickOnShoppingCart123();
    }
    @And("go to the shopping cart page")
    public void go_to_the_shopping_cart_page() {
  pageFactory.getElectrEnm().ClickOnCheckboxAndCheckoutbuttonAndAddDetails123();
    }
//    @And("click on the checkout and add user details")
//    public void click_on_the_checkout_and_add_user_details() {
//
//    }

}
