package com.mygdx.game.utils;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.states.GameState;
import com.mygdx.game.states.menu.MenuState;
import com.mygdx.game.states.test.TestState;

public class Handler {

    private static Handler handler = null;
    public GameState activeState;
    public MenuState menuState;
    public TestState testState;
    public OrthographicCamera camera;
    public float screenWidth;
    public float screenHeight;

    public Handler(){

    }

    public static Handler getInstance() {
        if (Handler.handler == null) {
            Handler.handler = new Handler();
        }
        return Handler.handler;
    }

    public void setActiveState(GameState gs){
        this.activeState = gs;
        this.activeState.setActiveInputProcessor();
    }

}
