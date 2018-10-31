package com.telran.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    WebDriver wd;

    public void logIn() {
        wd.findElement(By.cssSelector("class='global-header-section-button'")).click();
        type(By.name("user"), "siesto4ka@yandex.ua");
        type(By.name("password"), "53340717");
        wd.findElement(By.id("login")).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void submitBoardCreation() {
        wd.findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

    public void initBoardCreation() {
        wd.findElement(By.cssSelector("[placeholder=\"Добавить заголовок доски\"]")).click();
        wd.findElement(By.cssSelector("[placeholder=\"Добавить заголовок доски\"]")).sendKeys("New Board");
    }

    public void openBoardPage() {
        wd.findElement(By.cssSelector("[class=\"board-tile mod-add\"]")).click();
    }

    public void submitBoardModification() {
        wd.findElement(By.cssSelector("type=\"submit\"")).click();
    }

    public void fillBoardModification() {
        type(By.cssSelector("[class=\"placeholder\"]"), "new");
        type(By.cssSelector("[class=\"list-card-composer-textarea js-card-title\"]"), "smth written here");
    }

    public void openBoardModification() {
        wd.findElement(By.cssSelector("//openBoardModification")).click();
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
        logIn();
    }

    public void stop() {
        wd.quit();
    }
}
