package Pages;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import EnumPack.ElectronicPageEnum;
    public class ElectronicPageEnm {
        WebDriver driver;
        WebDriverWait wait;
        int number;
        Properties prop;

         String ClickOnComputer = "//a[text()='%s ']";
         String Checkout = "//button[@name='%s']";
        String Enterfandlastname = "(//input[@name='%s'])";
       String ClickOnDateYM = "(//select[@name='%s'])";
       String ChooseContry = "(//option[contains(text(),'%s')])[%d]";
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
        public ElectronicPageEnm(WebDriver driver) {
            this.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        public void ClickOnComputerHyperlinkAndAddItems123() throws InterruptedException {
            driver.findElement(By.xpath(String.format(ClickOnComputer, ElectronicPageEnum.Computers.getResourcesName()))).click();//enum
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
        public void AddItemsToCartAndClickOnShoppingCart123() {
            driver.findElement(Addtocartbutton).click();
            driver.findElement(Shoppingcartbutton).click();
        }
        public void ClickOnCheckboxAndCheckoutbuttonAndAddDetails123() {
            driver.findElement(ClickonCheckbox).click();
            driver.findElement(By.xpath(String.format(Checkout, ElectronicPageEnum.checkout.getResourcesName()))).click();
            driver.findElement(REgisterButton).click();
            driver.findElement(GenderRadiobutton).click();
            try {
                prop = new Properties();
                FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//TestData//Resource.Properties");
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            WebElement firstName = driver.findElement(By.xpath(String.format(Enterfandlastname, ElectronicPageEnum.firstName.getResourcesName())));
            firstName.sendKeys(prop.getProperty("FName"));//enum
            driver.findElement(By.xpath(String.format(Enterfandlastname, ElectronicPageEnum.lastName.getResourcesName()))).sendKeys(prop.getProperty("LName"));//enum
            driver.findElement(By.xpath(String.format(ClickOnDateYM, ElectronicPageEnum.DOB.getResourcesName()))).click();
            driver.findElement(ClickOndate).click();
            driver.findElement(By.xpath(String.format(ClickOnDateYM, ElectronicPageEnum.DOBM.getResourcesName()))).click();
            driver.findElement(ClickOndateofbirth).click();
            driver.findElement(By.xpath(String.format(ClickOnDateYM, ElectronicPageEnum.DOBY.getResourcesName()))).click();
            driver.findElement(ClickOnYear).click();
            driver.findElement(By.xpath(String.format(Enterfandlastname, ElectronicPageEnum.email.getResourcesName()))).sendKeys(alen+"@gmail.com");
            driver.findElement(By.xpath(String.format(Enterfandlastname, ElectronicPageEnum.company.getResourcesName()))).sendKeys(prop.getProperty("CompanyN"));
            driver.findElement(By.xpath(String.format(Enterfandlastname, ElectronicPageEnum.password.getResourcesName()))).sendKeys(prop.getProperty("Pwd"));
             WebElement ConfirmPAss= driver.findElement(By.xpath(String.format(Enterfandlastname,ElectronicPageEnum.confrmpass.getResourcesName())));
             ConfirmPAss.sendKeys(prop.getProperty("ConfPass"));//storing value in webelment
            driver.findElement(FinalRegisterButton).click();
            driver.findElement(ContinueButton).click();
            driver.findElement(IncreasingQuantity).clear();
            driver.findElement(IncreasingQuantity).sendKeys("4");
            WebElement AgreeCheck=driver.findElement(By.xpath(String.format(Enterfandlastname,ElectronicPageEnum.Agree.getResourcesName())));
            AgreeCheck.click();
            driver.findElement(Checkoutbutton).click();
           WebElement contryclick = driver.findElement(By.xpath(String.format(ClickOnDateYM,ElectronicPageEnum.ChoseContry.getResourcesName())));
                   contryclick.click();
                   driver.findElement(By.xpath(String.format(ChooseContry, "India",2))).click();
          WebElement stateclick=  driver.findElement(By.xpath(String.format(ClickOnDateYM, ElectronicPageEnum.Choosestate.getResourcesName())));
            stateclick.click();
            driver.findElement(ChoosingState).click();
        }
    }

