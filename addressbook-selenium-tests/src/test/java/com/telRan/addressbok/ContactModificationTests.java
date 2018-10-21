package com.telRan.addressbok;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!isContactPresent()){
            createContact();
        }
    }

    @Test
    public void testContactModification(){
        selectContact();
        modifyContact();
        fillEditForm(new Contact().setFirstName("Changed")
                .setLastName("Changed")
                .setAdress("Gogolya 5")
                .setMobile("fghj@mail.ru")
                .setEmail("fghj@mail.ru"));
        updateContactModification();
        returnToHomeGage();
    }

}
