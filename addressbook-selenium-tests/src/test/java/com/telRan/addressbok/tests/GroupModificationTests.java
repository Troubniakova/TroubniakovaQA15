package com.telRan.addressbok.tests;

import com.telRan.addressbok.model.Group;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.getGroupHelper().openGroupPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
    }

    @Test
    public void testGroupModification(){
        app.getGroupHelper().openGroupPage();
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group()
                .setGroupFooter("Changed")
                .setGroupHeader("newmodifyed")
                .setGroupName("new"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before);
    }


}
