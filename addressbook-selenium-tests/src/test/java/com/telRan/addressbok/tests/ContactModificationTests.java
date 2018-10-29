package com.telRan.addressbok.tests;

import com.telRan.addressbok.model.Contact;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
        }
    }

    @Test
    public void testContactModification(){
        app.getContactHelper().selectContact();
        app.getContactHelper().modifyContact();
        app.getContactHelper().fillEditForm(new Contact().setFirstName("Changed")
                .setLastName("Changed")
                .setAdress("Gogolya 5")
                .setMobile("fghj@mail.ru")
                .setEmail("fghj@mail.ru"));
        app.getContactHelper().updateContactModification();

    }

}
