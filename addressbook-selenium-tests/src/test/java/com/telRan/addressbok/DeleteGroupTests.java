package com.telRan.addressbok;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteGroupTests extends TestBase {
    @Test
    public void testGroupDeletion(){
        openGroupPage();
        selectGroup();
        deleteGroup();
        returnToGroupsPage();
    }

}
