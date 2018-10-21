package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
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

    public void submitGroupModification()
    {
        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification()
    {
        wd.findElement(By.cssSelector("[name=edit]:last-child")).click();
    }

    public void selectGroup()
    {
        wd.findElement(By.name("selected[]")).click();
    }

    public void deleteGroup()
    {
        wd.findElement(By.name("delete")).click();
    }

    public void openAddNewPage()
    {
        wd.findElement(By.cssSelector("[href='edit.php']")).click();
    }

    public void returnToHomeGage()
    {
        wd.findElement(By.cssSelector("[href='./']")).click();
    }

    public void submitAddNewContact()
    {
        wd.findElement(By.name("submit")).click();
    }

    public void fillEditForm(Contact contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAdress());
        type(By.name("mobile"), contact.getMobile());
        type(By.name("email"), contact.getEmail());
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void updateContactModification() {
        wd.findElement(By.name("update")).click();
    }

    public void modifyContact() {
        wd.findElement(By.cssSelector("[title='Edit']")).click();
    }

    public void deleteContact() {
        wd.findElement(By.cssSelector("[onclick=\"DeleteSel()\"]")).click();
        wd.switchTo().alert().accept();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent()
    {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    protected void createGroup() {
        initGroupCreation();
        fillGroupForm(new Group().setGroupName("QA 15")
                .setGroupHeader("jhggh")
                .setGroupFooter("footer"));
        submitGroupCreation();
        returnToGroupsPage();
    }

    protected void createContact() {
        openAddNewPage();
        fillEditForm(new Contact().setFirstName("Vasya")
                .setLastName("Pupkin")
                .setAdress("Gogolya 5")
                .setMobile("fghj@mail.ru")
                .setEmail("fghj@mail.ru"));
        submitAddNewContact();
        returnToHomeGage();
    }
}
