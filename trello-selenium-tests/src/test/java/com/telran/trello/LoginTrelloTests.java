package com.telran.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTrelloTests {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://trello.com/");

        //logIn
        wd.findElement(By.cssSelector("[href=\"/login\"]")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("siesto4ka@yandex.ua");

        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("53340717");

        wd.findElement(By.id("login")).click();
    }

    @Test
    public void createBoard(){


    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }

}
