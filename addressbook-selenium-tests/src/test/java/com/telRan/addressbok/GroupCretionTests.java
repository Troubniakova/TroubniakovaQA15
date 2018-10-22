package com.telRan.addressbok;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCretionTests extends TestBase{

    @Test
    public void testGroupCretion(){
        app.openGroupPage();

        int before = app.getGroupsCount();

        app.initGroupCreation();
        app.fillGroupForm(new Group().setGroupName("QA 15")
                .setGroupHeader("jhggh")
                .setGroupFooter("footer"));
        app.submitGroupCreation();
        app.returnToGroupsPage();

        int after = app.getGroupsCount();
        Assert.assertEquals(after, before+1);


    }

}
