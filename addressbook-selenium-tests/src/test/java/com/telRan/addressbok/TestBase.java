package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        wd.get("http://localhost/addressbook");

        login("admin", "secret");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        wd.findElement(By.cssSelector("[type='submit']")).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToGroupsPage() {
        wd.findElement(By.cssSelector("i [href='group.php']")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(String groupName, String groupHeader, String groupFooter) {
        type(By.name("group_name"), groupName);
        type(By.name("group_header"), groupHeader);
        type(By.name("group_footer"), groupFooter);
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void openGroupPage() {
        wd.findElement(By.cssSelector("[href='group.php']")).click();
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }

    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification() {
        wd.findElement(By.cssSelector("[name=edit]:last-child")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void openAddNewPage() {
        wd.findElement(By.cssSelector("[href='edit.php']")).click();
    }

    public void returnToHomeGage() {
        wd.findElement(By.cssSelector("[href='./']")).click();
    }

    public void submitAddNewContact() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillEditForm(String firstName, String lastName, String adress, String mobile, String email) {
        type(By.name("firstname"), firstName);
        type(By.name("lastname"), lastName);
        type(By.name("address"), adress);
        type(By.name("mobile"), mobile);
        type(By.name("email"), email);

    }

    public void selectContact() {
        wd.findElement(By.id("2")).click();
    }

    public void updateContactModification() {
        wd.findElement(By.name("update")).click();
    }

    public void modifyContact() {
        wd.findElement(By.cssSelector("[href='edit.php?id=2']")).click();
    }
}
