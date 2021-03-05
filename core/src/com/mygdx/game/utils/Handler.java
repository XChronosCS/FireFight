package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.states.GameState;
import com.mygdx.game.states.menu.MenuState;

public class Handler {

    private static Handler handler = null;
    public GameState activeState;
    public MenuState menuState;
    public OrthographicCamera camera;
    public float screenWidth;
    public float screenHeight;

    public Handler(){

    }

    public static Handler getInstance() {
        if (handler == null) {
            handler = new Handler();
        }

        return handler;
    }

    public void setActiveState(GameState gs){
        this.activeState = gs;
    }

}
