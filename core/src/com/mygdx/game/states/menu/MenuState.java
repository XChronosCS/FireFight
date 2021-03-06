package com.mygdx.game.states.menu;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Dimension;
import com.mygdx.game.states.GameState;
import com.mygdx.game.utils.Handler;
import com.mygdx.game.widgets.Button;


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
        size = new Dimension(0, 1300, 512, 100);
        inputProcessor = new MenuInputProcessor();
        //Button Initialization
        Dimension startGameDim = new Dimension(200, 800, 200, 100);
        startGameDim.centerX(handler.screenWidth);
        Texture startGameImg = new Texture("Menu/start-button.png");
        this.startButton = new Button(startGameDim, startGameImg){
            @Override
            public void onClick(float x, float y){
                handler.setActiveState()
            }
        }



    }
}
