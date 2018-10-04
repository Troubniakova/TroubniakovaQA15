package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenChromeWikipedia {
    WebDriver wd;

    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void openSiteTest(){
        wd.navigate().to("https://www.wikipedia.org");
    }

    @AfterMethod
    public void tearDown(){

        wd.quit();
    }
}
