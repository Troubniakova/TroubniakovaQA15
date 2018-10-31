package com.telran.trello;

import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test
    public void createBoardTest(){
        app.openBoardPage();
        app.initBoardCreation();
        app.submitBoardCreation();
    }

}
