package com.mygdx.game.states.menu;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.states.GameState;
import com.mygdx.game.utils.Handler;
import com.mygdx.game.widgets.Button;

import java.awt.Dimension;


public class MenuState extends GameState {

    private Texture backgroundImage;
    private Dimension size;
    private MenuInputProcessor inputProcessor;
    private Button startButton;
    private Button customizeButton;
    private Handler handler;

    public MenuState(){
        handler = Handler.getInstance();
        backgroundImage = new Texture("Menu/fire-background.jpg");
    }
}
