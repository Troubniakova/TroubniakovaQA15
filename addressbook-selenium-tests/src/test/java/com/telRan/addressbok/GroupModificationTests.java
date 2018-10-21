package com.telRan.addressbok;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        openGroupPage();
        if(!isGroupPresent()){
            createGroup();
        }
    }

    @Test
    public void testGroupModification(){
        openGroupPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(new Group().setGroupFooter("Changed").setGroupHeader("newmodifyed").setGroupName("new"));
        submitGroupModification();
        returnToGroupsPage();
    }


}
