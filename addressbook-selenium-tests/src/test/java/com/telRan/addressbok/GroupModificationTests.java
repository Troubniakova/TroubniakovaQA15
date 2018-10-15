package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){
        openGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm("modifyed", "new", "Changed");
        submitGroupModification();
        returnToGroupsPage();
    }


}
