package com.telRan.addressbok;

import org.testng.annotations.Test;

public class GroupCretionTests extends TestBase{

    @Test
    public void testGroupCretion(){
        openGroupPage();
        initGroupCreation();
        fillGroupForm(new Group().setGroupName("QA 15")
                .setGroupHeader("jhggh")
                .setGroupFooter("footer"));
        submitGroupCreation();
        returnToGroupsPage();


    }

}
