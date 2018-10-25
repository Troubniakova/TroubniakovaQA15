package com.telRan.addressbok.manager;

import com.telRan.addressbok.model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private SessionHelper sessionHelper;
    WebDriver wd;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;


    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        navigationHelper.openSite("http://localhost/addressbook");
        sessionHelper = new SessionHelper(wd);

        sessionHelper.login("admin", "secret");

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);

    }



    public void stop() {
        wd.quit();
    }

    public void openAddNewPage()
    {
        groupHelper.click(By.cssSelector("[href='edit.php']"));
    }

    public void returnToHomeGage()
    {
        groupHelper.click(By.cssSelector("[href='./']"));
    }

    public void submitAddNewContact()
    {
        groupHelper.click(By.name("submit"));
    }

    public void fillEditForm(Contact contact) {
        groupHelper.type(By.name("firstname"), contact.getFirstName());
        groupHelper.type(By.name("lastname"), contact.getLastName());
        groupHelper.type(By.name("address"), contact.getAdress());
        groupHelper.type(By.name("mobile"), contact.getMobile());
        groupHelper.type(By.name("email"), contact.getEmail());
    }

    public void selectContact() {
        groupHelper.click(By.name("selected[]"));
    }

    public void updateContactModification() {
        groupHelper.click(By.name("update"));
    }

    public void modifyContact() {
        groupHelper.click(By.cssSelector("[title='Edit']"));
    }

    public void deleteContact() {
        groupHelper.click(By.cssSelector("[onclick=\"DeleteSel()\"]"));
        wd.switchTo().alert().accept();
    }

    public boolean isContactPresent(){
        return groupHelper.isElementPresent(By.name("selected[]"));
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

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
