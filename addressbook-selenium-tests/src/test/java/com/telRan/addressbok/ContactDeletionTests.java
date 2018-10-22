package com.telRan.addressbok;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!app.isContactPresent()){
            app.createContact();
        }
    }


    @Test
    public void testContactDeletion(){
        app.selectContact();
        app.deleteContact();
        app.returnToHomeGage();

    }

}
