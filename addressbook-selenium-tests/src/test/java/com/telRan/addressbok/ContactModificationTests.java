package com.telRan.addressbok;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!app.isContactPresent()){
            app.createContact();
        }
    }

    @Test
    public void testContactModification(){
        app.selectContact();
        app.modifyContact();
        app.fillEditForm(new Contact().setFirstName("Changed")
                .setLastName("Changed")
                .setAdress("Gogolya 5")
                .setMobile("fghj@mail.ru")
                .setEmail("fghj@mail.ru"));
        app.updateContactModification();
        app.returnToHomeGage();
    }

}
