package TestPages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Utilities.DriverManager.driver;

public class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@name, 'user-name')]")
    public WebElement Username;
    @FindBy(xpath = "//input[contains(@name, 'password')]")
    public WebElement Password;
    @FindBy(xpath = "//input[contains(@name, 'login-button')]")
    public WebElement Login;
    @FindBy(xpath = "(//button[contains(@name, 'add-to-cart')])[1]")
    public WebElement Product1Add;
    @FindBy(xpath = "(//button[contains(@name, 'add-to-cart')])[2]")
    public WebElement Product2Add;
    @FindBy(xpath = "(//button[contains(@name, 'add-to-cart')])[3]")
    public WebElement Product3Add;
    @FindBy(xpath = "//span[contains(@class, 'shopping_cart_badge')]")
    public WebElement Cart;
    @FindBy(xpath = "//span[contains(text(),'Your Cart')]")
    public WebElement VerifyCart;
    @FindBy(xpath = "//button[contains(@name, 'continue-shopping')]")
    public WebElement ClickOnContinueShopping;
    @FindBy(xpath = "//button[contains(text(),'Checkout')]")
    public WebElement ClickOnCheckout;
    @FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
    public WebElement VerifyCheckout;
    @FindBy(xpath = "//input[contains(@name, 'firstName')]")
    public WebElement FirstName;
    @FindBy(xpath = "//input[contains(@name, 'lastName')]")
    public WebElement LastName;
    @FindBy(xpath = "//input[contains(@name, 'postalCode')]")
    public WebElement PostalCode;
    @FindBy(xpath = "//input[contains(@name, 'continue')]")
    public WebElement ClickOnContinue;
    @FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]")
    public WebElement VerifyCheckoutOverview;
    @FindBy(xpath = "//button[contains(text(),'Finish')]")
    public WebElement ClickOnFinish;
    @FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
    public WebElement VerifyOrderComplete;
    @FindBy(xpath = "//button[contains(text(),'Back Home')]")
    public WebElement ClickOnBackHome;
    @FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    public WebElement ClickOnMenu;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    public WebElement Logout;
    @FindBy(xpath = "(//button[contains(text(),'Remove')])[1]")
    public WebElement RemoveFirstProduct;
    @FindBy(xpath = "(//button[contains(text(),'Remove')])[2]")
    public WebElement RemoveSecondProduct;
    @FindBy(xpath = "(//button[contains(text(),'Remove')])[3]")
    public WebElement RemoveThirdProduct;
    @FindBy(xpath = "//a[contains(text(),'About')]")
    public WebElement ClickOnAbout;
    @FindBy(xpath = "//button[contains(text(),'OK')]")
    public WebElement AcceptCoockies;
    @FindBy(xpath = "(//img[contains(@alt, 'Saucelabs')])[1]")
    public WebElement VerifyAbout;
    @FindBy(xpath = "//a[contains(text(),'Reset App State')]")
    public WebElement ClickResetApp;
    @FindBy(xpath = "//a[contains(@class, 'shopping_cart_link')]")
    public WebElement ResetCart;
    @FindBy(xpath = "//div[contains(@class, 'inventory_item_name')]")
    public List<WebElement> productList;
    @FindBy(xpath = "//select[contains(@class, 'product_sort_container')]")
    public WebElement ClickOnSort;
    @FindBy(xpath = "//option[contains(text(),'Name (A to Z)')]")
    public WebElement SortAtoZ;
    @FindBy(xpath = "//option[contains(text(),'Name (Z to A)')]")
    public WebElement SortZtoA;










    public void Login() throws IOException {
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\SaucedemoProject3\\src\\test\\resources\\Project3.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String username = row.getCell(1).getStringCellValue();
            String password = row.getCell(2).getStringCellValue();
            Username.sendKeys(username);
            Password.sendKeys(password);
            Login.click();
        }
    }
    public void Logout() throws IOException {
        ClickOnMenu.click();
        Logout.click();
        boolean displayed = Login.isDisplayed();
        Assert.assertEquals(displayed, true);
    }
    public void AddSingleProduct() throws IOException {
        Product1Add.click();
        String actualQty = Cart.getText();
        Assert.assertEquals("1", actualQty);
    }
    public void AddMultipleProduct() throws IOException {
        Product1Add.click();
        Product2Add.click();
        Product3Add.click();
        String actualQty = Cart.getText();
        Assert.assertEquals("3", actualQty);
    }
    public void RemoveMultipleProduct() throws IOException {
        RemoveFirstProduct.click();
        RemoveFirstProduct.click();
        RemoveFirstProduct.click();
    }
    public void VerifyCart() throws IOException {
        Cart.click();
        boolean displayed = VerifyCart.isDisplayed();
        Assert.assertEquals(displayed, true);
    }
    public void VerifyCheckoutPage() throws IOException {
        ClickOnCheckout.click();
        boolean displayed = VerifyCheckout.isDisplayed();
        Assert.assertEquals(displayed, true);
    }
    public void FillCheckoutOrderComplete() throws IOException {
        String excelFilePath = "C:\\Users\\Admin\\IdeaProjects\\SaucedemoProject3\\src\\test\\resources\\Project3.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String firstname = row.getCell(3).getStringCellValue();
            String lastname = row.getCell(4).getStringCellValue();
            double numericValue = row.getCell(5).getNumericCellValue();
            int intValue = (int) numericValue;
            String postalCode = String.valueOf(intValue);
            FirstName.sendKeys(firstname);
            LastName.sendKeys(lastname);
            PostalCode.sendKeys(postalCode);
            ClickOnContinue.click();
            boolean displayed = VerifyCheckoutOverview.isDisplayed();
            Assert.assertEquals(displayed, true);
            ClickOnFinish.click();
            boolean displayed1 = VerifyOrderComplete.isDisplayed();
            Assert.assertEquals(displayed1, true);
        }
    }
    public void AboutPageFunctionality() throws InterruptedException {
        ClickOnMenu.click();
        ClickOnAbout.click();
        Thread.sleep(15000);
        AcceptCoockies.click();
        boolean displayed = VerifyAbout.isDisplayed();
        Assert.assertEquals(displayed, true);
    }
    public void ResetAppStateFunction() throws IOException, InterruptedException {
        ClickOnMenu.click();
        ClickResetApp.click();
        String actualQty = ResetCart.getText();
        Assert.assertNotEquals("3", actualQty);
    }
    public void AtoZSorting() throws IOException, InterruptedException {
        ClickOnSort.click();
        SortAtoZ.click();
        List<String> productNames = new ArrayList<>();
        for (WebElement productElement : productList) {
            productNames.add(productElement.getText());
        }
        boolean isSorted = isSortedAlphabetically(productNames);
        Assert.assertTrue(isSorted, "The array is not sorted alphabetically.");
    }

    public static boolean isSortedAlphabetically(List<String> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1).compareTo(arr.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public void ZtoASorting() throws IOException, InterruptedException {
        ClickOnSort.click();
        SortZtoA.click();
        List<String> productNames = new ArrayList<>();
        for (WebElement productElement : productList) {
            productNames.add(productElement.getText());
        }
        boolean isSorted = isSortedReverseAlphabetically(productNames);
        Assert.assertTrue(isSorted, "The array is not sorted Reverse_alphabetically.");
    }
    public static boolean isSortedReverseAlphabetically(List<String> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1).compareTo(arr.get(i)) < 0) {
                return false;
            }
        }
        return true;
    }



}