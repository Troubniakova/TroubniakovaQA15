package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {

    @Test
    public void testContactDeletion(){
        selectContact();
        deleteContact();
        returnToHomeGage();

    }

}
