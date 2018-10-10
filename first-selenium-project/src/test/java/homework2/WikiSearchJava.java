package homework2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
