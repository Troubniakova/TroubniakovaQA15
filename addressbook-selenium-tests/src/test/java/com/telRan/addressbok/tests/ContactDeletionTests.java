package com.telRan.addressbok.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
        }
    }


    @Test
    public void testContactDeletion(){
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();


    }

}
