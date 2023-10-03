package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    public static WebDriver driver;
    public static void init(){
        if (driver==null){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    public static WebDriver getDriver(){
        init();
        return driver;
    }
}
