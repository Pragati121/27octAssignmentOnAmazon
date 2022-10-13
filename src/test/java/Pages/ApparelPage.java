package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApparelPage {
    WebDriver driver;
     String priceDropDownAndDisplayItem =    "//select[@name='%s']";

     By clickOnApparel= By.xpath("(//li//a[contains(text(),'Apparel ')])[1]");
     By clickOnShoes  =By.xpath("//a[contains(text(),' Shoes ')]");
     By sortingWithName = By.xpath("//option[@value='10']");



ApparelPage(WebDriver driver)
{
this.driver=driver;
}
public void clickOnAparelOption()
        {
    driver.findElement(clickOnApparel).click();
            driver.findElement(clickOnShoes).click();
    }
    public void clickOnPricedropdownOption()
    {
        driver.findElement(By.xpath(String.format(priceDropDownAndDisplayItem,"products-orderby")));
        driver.findElement(sortingWithName).click();
    }
}