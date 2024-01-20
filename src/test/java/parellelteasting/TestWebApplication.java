package parellelteasting;


import org.junit.After;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestWebApplication {
     WebDriver driver;


   // String browser = "edge";

    @Test(priority = 1)
    @Parameters("browser")
    public void setUp(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":

                driver = new ChromeDriver();
                break;

            case "edge":

                driver = new EdgeDriver();
                break;

            case "firefox":

                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser specified: " + browser);
        }
    }

    @Test(priority = 2)
    public void verifyTitle() {
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String expectedTitle = "Google" ;
         String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test(priority = 3)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
