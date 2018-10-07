package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WikiSearchJava extends TestWindow {

    @Test
    public void testSearchingJavaInWikipedia(){
        wd.navigate().to("https://www.wikipedia.org/");
        wd.findElement(By.name("search")).sendKeys("Java");
        wd.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();


         String currentUrl = wd.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://en.wikipedia.org/wiki/Java");
    }


}
