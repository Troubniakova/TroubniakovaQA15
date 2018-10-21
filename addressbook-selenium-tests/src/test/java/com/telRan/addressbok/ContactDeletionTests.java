package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!isContactPresent()){
            createContact();
        }
    }


    @Test
    public void testContactDeletion(){
        selectContact();
        deleteContact();
        returnToHomeGage();

    }

}
