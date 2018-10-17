package com.telRan.addressbok;

import org.testng.annotations.Test;

public class AddContact extends TestBase {

    @Test
    public void testAddContact(){
        openAddNewPage();
        fillEditForm("Vasya", "Pupkin", "Gogolya 5","0334567876", "fghj@mail.ru");
        submitAddNewContact();
        returnToHomeGage();


    }

}
