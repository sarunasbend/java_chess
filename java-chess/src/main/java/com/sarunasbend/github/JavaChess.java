package com.sarunasbend.github;

import com.sarunasbend.github.utility.debug.Debug;

public class JavaChess {
    private static UIManager uiManager = new UIManager();
    public static void main(String[] args) {
        startUp();
    }

    public static void startUp(){
        Debug.info("Initialising Project");
        Debug.info("Initialising UI");
        uiManager.init();
    }
}