package com.telRan.addressbok.tests;

import com.telRan.addressbok.manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp(){
        app.start();
    }

    @AfterClass
    public void tearDown(){
        app.stop();
    }

}
