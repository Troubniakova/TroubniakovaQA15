package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification(){
        selectContact();
        modifyContact();
        fillEditForm("Changed", "Changed", "Changed", "Changed", "Changed");
        updateContactModification();
        returnToHomeGage();
    }

}
