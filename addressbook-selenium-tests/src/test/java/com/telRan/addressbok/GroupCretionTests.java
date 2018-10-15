package com.telRan.addressbok;

import org.testng.annotations.Test;

public class GroupCretionTests extends TestBase{

    @Test
    public void testGroupCretion(){
        openGroupPage();
        initGroupCreation();
        fillGroupForm("QA 15", "jhggh", "footer");
        submitGroupCreation();
        returnToGroupsPage();


    }

}
