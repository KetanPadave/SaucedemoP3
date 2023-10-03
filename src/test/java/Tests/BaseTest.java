package Tests;

import Utilities.DriverManager;
import Utilities.QaEnvPropReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {
    WebDriver driver;
    @BeforeClass
    public void setup() throws IOException {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        String url = QaEnvPropReader.getproperty("url");
        driver.get(url);
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

}
