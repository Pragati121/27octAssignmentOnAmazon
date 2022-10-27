package Pages;
import org.openqa.selenium.WebDriver;

public class PageFactory
{
   private addTOCartPage CartMethod;

   WebDriver driver;

    public PageFactory(WebDriver driver)
    {
        this.driver = driver;
    }

   public addTOCartPage getCartPage() {
        if (CartMethod == null) {
            CartMethod = new addTOCartPage(driver);
       }
       return CartMethod;
    }

}

