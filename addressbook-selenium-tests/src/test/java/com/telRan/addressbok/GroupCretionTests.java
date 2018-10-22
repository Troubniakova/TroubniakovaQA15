package com.telRan.addressbok;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCretionTests extends TestBase{

    @Test
    public void testGroupCretion(){
        app.getGroupHelper().openGroupPage();

        int before = app.getGroupHelper().getGroupsCount();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group().setGroupName("QA 15")
                .setGroupHeader("jhggh")
                .setGroupFooter("footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before+1);


    }

}
