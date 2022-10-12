package Pages;
import gherkin.lexer.Th;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
public class ElectronicPage {
    WebDriver driver;
    int number;
    Properties prop;
    private static String Click = "//a[text()='%s ']";
    private static String checkout = "(//button[@type='%s'])[%d]";
    private static String Enterfandlastname = "(//input[@name='%s'])";
    private static String ClickOnDateYM = "(//select[@name='%s'])";
    private static String ChooseContry = "(//option[contains(text(),'%s')])[%d]";
    String alen = RandomStringUtils.randomAlphabetic(8);
    By NotebookHyperlink  = By.xpath("//a[text()=' Notebooks ']");
    By Pricedropdown = By.xpath("//select[@name='products-orderby']");
    By SortingByPrice  =By.xpath("//option[@value='10']");
    By ClickOnProduct = By.xpath("//a[contains(text(),'Asus N551JK-XO076H Laptop')]");
    By Addtocartbutton = By.xpath("//button[@id='add-to-cart-button-5']");
    By Shoppingcartbutton = By.xpath("//a[@class='ico-cart']");
    By ClickonCheckbox = By.xpath("//input[contains(@name,'termsofservice')]");
    By REgisterButton = By.xpath("//button[text()='Register']");
    By GenderRadiobutton = By.xpath("//input[@id='gender-female']");
    By ClickOndate = By.xpath("//option[@value='2']");
    By ClickOndateofbirth = By.xpath("//option[contains(text(),'January')]");
    By ClickOnYear = By.xpath("//option[@value='2022']");
    By FinalRegisterButton =By.xpath("//button[@name='register-button']");
    By ContinueButton=By.xpath("//a[contains(text(),'Continue')]");
    By IncreasingQuantity =By.xpath("(//input[@type='text'])[2]");
    By Checkoutbutton = By.xpath("//button[@name='checkout']");
    By ChoosingState = By.xpath("//option[contains(text(),'Other')]");
    public ElectronicPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ElectronicsUser() {
    }
    public void ClickOnComputerHyperlinkAndAddItems() throws InterruptedException {
        driver.findElement(By.xpath(String.format(Click,"Computers"))).click();
        driver.findElement(NotebookHyperlink).click();
        driver.findElement(Pricedropdown).click();
        driver.findElement(SortingByPrice).click();
        List<WebElement> objectDetails = driver.findElements(By.xpath("//div[@class='product-item']"));
        number = objectDetails.size();
        Assert.assertEquals(number, 6);
        Thread.sleep(1000);
        driver.findElement(Pricedropdown).click();
        driver.findElement(SortingByPrice).click();
        driver.findElement(ClickOnProduct).click();
    }
    public void AddItemsToCartAndClickOnShoppingCart() {
        driver.findElement(Addtocartbutton).click();
        driver.findElement(Shoppingcartbutton).click();
    }
    public void ClickOnCheckboxAndCheckoutbuttonAndAddDetails() {
        driver.findElement(ClickonCheckbox).click();
        driver.findElement(By.xpath(String.format(checkout, "submit", 6))).click();
        driver.findElement(REgisterButton).click();
        driver.findElement(GenderRadiobutton).click();
        try {
            prop = new Properties();
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//TestData//Resource.Properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath(String.format(Enterfandlastname, "FirstName"))).sendKeys(prop.getProperty("FName"));
        driver.findElement(By.xpath(String.format(Enterfandlastname, "LastName"))).sendKeys(prop.getProperty("LName"));
        driver.findElement(By.xpath(String.format(ClickOnDateYM, "DateOfBirthDay"))).click();
        driver.findElement(ClickOndate).click();
        driver.findElement(By.xpath(String.format(ClickOnDateYM, "DateOfBirthMonth"))).click();
        driver.findElement(ClickOndateofbirth).click();
        driver.findElement(By.xpath(String.format(ClickOnDateYM, "DateOfBirthYear"))).click();
        driver.findElement(ClickOnYear).click();
        driver.findElement(By.xpath(String.format(Enterfandlastname,"Email"))).sendKeys(alen+"@gmail.com");
        driver.findElement(By.xpath(String.format(Enterfandlastname, "Company"))).sendKeys(prop.getProperty("CompanyN"));
        driver.findElement(By.xpath(String.format(Enterfandlastname, "Password"))).sendKeys(prop.getProperty("Pwd"));
        driver.findElement(By.xpath(String.format(Enterfandlastname, "ConfirmPassword"))).sendKeys(prop.getProperty("ConfPass"));
        driver.findElement(FinalRegisterButton).click();
        driver.findElement(ContinueButton).click();
        driver.findElement(IncreasingQuantity).clear();
        driver.findElement(IncreasingQuantity).sendKeys("4");
        driver.findElement(By.xpath(String.format(Enterfandlastname, "termsofservice"))).click();
        driver.findElement(Checkoutbutton).click();
        driver.findElement(By.xpath(String.format(ClickOnDateYM, "BillingNewAddress.CountryId"))).click();
        driver.findElement(By.xpath(String.format(ChooseContry, "India",2))).click();
        driver.findElement(By.xpath(String.format(ClickOnDateYM, "BillingNewAddress.StateProvinceId"))).click();
        driver.findElement(ChoosingState).click();
    }
}