package com.telRan.addressbok;

import org.testng.annotations.Test;

public class AddContact extends TestBase {

    @Test
    public void testAddContact(){
        app.openAddNewPage();
        app.fillEditForm(new Contact().setFirstName("Vasya")
                .setLastName("Pupkin")
                .setAdress("Gogolya 5")
                .setMobile("fghj@mail.ru")
                .setEmail("fghj@mail.ru"));
        app.submitAddNewContact();
        app.returnToHomeGage();
    }

}
