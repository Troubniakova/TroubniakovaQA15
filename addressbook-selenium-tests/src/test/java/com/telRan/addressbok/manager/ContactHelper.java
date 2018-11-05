package com.telRan.addressbok.manager;

import com.telRan.addressbok.model.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase{
    WebDriver wd;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void openAddNewPage()
    {
        click(By.cssSelector("[href='edit.php']"));
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
        click(By.xpath("//input[@value='Delete']"));
        //click(By.cssSelector("[onclick=\"DeleteSel()\"]"));
       // wd.switchTo().alert().accept();

    }


    public boolean isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact() {
        openAddNewPage();
        fillEditForm(new Contact().setFirstName("Vasya")
                .setLastName("Pupkin")
                .setAdress("Gogolya 5")
                .setMobile("fghj@mail.ru")
                .setEmail("fghj@mail.ru"));
        submitAddNewContact();

    }

    public NavigationHelper getNavigationHelper() {
        NavigationHelper navigationHelper = new NavigationHelper(wd);
        return navigationHelper;
    }
}
