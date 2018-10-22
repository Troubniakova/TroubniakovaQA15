package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        wd.get("http://localhost/addressbook");

        login("admin", "secret");
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("[type='submit']"));
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i [href='group.php']"));
    }

    public void submitGroupCreation()
    {
        click(By.name("submit"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void openGroupPage() {
        click(By.cssSelector("[href='group.php']"));
    }

    public void stop() {
        wd.quit();
    }

    public void submitGroupModification()

    {
        click(By.name("update"));
    }

    public void initGroupModification()

    {
        click(By.cssSelector("[name=edit]:last-child"));
    }

    public void selectGroup()

    {
        click(By.name("selected[]"));
    }

    public void deleteGroup()
    {
        click(By.name("delete"));
    }

    public void openAddNewPage()
    {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void returnToHomeGage()
    {
        click(By.cssSelector("[href='./']"));
    }

    public void submitAddNewContact()
    {
        click(By.name("submit"));
    }

    public void fillEditForm(Contact contact) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAdress());
        type(By.name("mobile"), contact.getMobile());
        type(By.name("email"), contact.getEmail());
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void updateContactModification() {
        click(By.name("update"));
    }

    public void modifyContact() {
        click(By.cssSelector("[title='Edit']"));
    }

    public void deleteContact() {
        click(By.cssSelector("[onclick=\"DeleteSel()\"]"));
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

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
