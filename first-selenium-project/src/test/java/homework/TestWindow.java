package homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestWindow {
    WebDriver wd;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
