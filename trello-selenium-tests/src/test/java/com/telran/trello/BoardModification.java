package com.telran.trello;

import org.testng.annotations.Test;

public class BoardModification extends TestBase{

    @Test
    public void boardModificationTests(){

        app.openBoardModification();
        app.fillBoardModification();
        app.submitBoardModification();
    }


}
