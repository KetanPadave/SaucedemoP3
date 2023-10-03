package Tests;

import TestPages.Page;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestCase extends BaseTest {

    @Test
    public void VerifyLoginAndLogOut() throws IOException {
        Page page = new Page(driver);
        page.Login();
        page.Logout();
    }
    @Test
    public void LoginWithOrderSingleProduct() throws IOException {
        Page page = new Page(driver);
        page.Login();
        page.AddSingleProduct();
        page.VerifyCart();
        page.VerifyCheckoutPage();
        page.FillCheckoutOrderComplete();
        page.ClickOnBackHome.click();
        page.Logout();
    }
    @Test
    public void LoginWithOrderMultipleProduct() throws IOException {
        Page page = new Page(driver);
        page.Login();
        page.AddMultipleProduct();
        page.VerifyCart();
        page.VerifyCheckoutPage();
        page.FillCheckoutOrderComplete();
        page.ClickOnBackHome.click();
        page.Logout();
    }
    @Test
    public void LoginWithAddAndRemoveMultipleProduct() throws IOException {
        Page page = new Page(driver);
        page.Login();
        page.AddMultipleProduct();
        page.VerifyCart();
        page.RemoveMultipleProduct();
        page.Logout();
    }
    @Test
    public void AddAndRemoveProductAgainAddProduct() throws IOException {
        Page page = new Page(driver);
        page.Login();
        page.AddMultipleProduct();
        page.VerifyCart();
        page.RemoveMultipleProduct();
        page.ClickOnContinueShopping.click();
        page.AddMultipleProduct();
        page.Logout();
    }
    @Test
    public void AboutPageFunctionality() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Login();
        page.AboutPageFunctionality();
        driver.navigate().back();
        Thread.sleep(5000);
        page.Logout.click();
    }
    @Test
    public void VerifyResetAppState() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Login();
        page.AddMultipleProduct();
        page.VerifyCart();
        page.ResetAppStateFunction();
        page.Logout.click();
    }

    @Test
    public void VerifyAtoZSorting() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Login();
        page.AtoZSorting();
        page.Logout();
    }
    @Test
    public void VerifyZtoASorting() throws IOException, InterruptedException {
        Page page = new Page(driver);
        page.Login();
        page.ZtoASorting();
        page.Logout();
    }
}