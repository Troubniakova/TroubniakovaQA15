package com.telRan.addressbok.tests;

import com.telRan.addressbok.manager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    WebDriver wd;
    public ApplicationManager app = new ApplicationManager(wd);

    @BeforeClass
    public void setUp(){
        app.start();
    }

    @AfterClass
    public void tearDown(){
        app.stop();
    }

}
