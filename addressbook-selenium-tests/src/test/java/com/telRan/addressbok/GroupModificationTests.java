package com.telRan.addressbok;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.openGroupPage();
        if(!app.isGroupPresent()){
            app.createGroup();
        }
    }

    @Test
    public void testGroupModification(){
        app.openGroupPage();
        int before = app.getGroupsCount();
        app.selectGroupByIndex(before-1);
        app.initGroupModification();
        app.fillGroupForm(new Group()
                .setGroupFooter("Changed")
                .setGroupHeader("newmodifyed")
                .setGroupName("new"));
        app.submitGroupModification();
        app.returnToGroupsPage();

        int after = app.getGroupsCount();
        Assert.assertEquals(after, before);
    }


}
