package com.telran.qa15.sandbox.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInWiki {
    WebDriver wd;
    @BeforeMethod
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void openSiteTest()
    {
        wd.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
        wd.findElement(By.id("pt-login")).click();
        wd.findElement(By.name("wpName")).sendKeys("Troubniakova");
        wd.findElement(By.name("wpPassword")).sendKeys("53340717");
        wd.findElement(By.id("wpLoginAttempt")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4000);
        wd.quit();
    }


}
