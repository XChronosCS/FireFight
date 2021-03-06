package com.mygdx.game.states.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dimension;
import com.mygdx.game.states.GameState;
import com.mygdx.game.utils.Handler;
import com.mygdx.game.utils.Utils;
import com.mygdx.game.widgets.Button;


public class MenuState extends GameState {

    private Texture backgroundImage;
    private Texture titleImage;
    private Dimension backgroundSize;
    private Dimension titleSize;
    private MenuInputProcessor inputProcessor;
    private Button startButton;
    private Button customizeButton;
    private Handler handler;

    public MenuState(){
        handler = Handler.getInstance();
        backgroundImage = new Texture("Menu/fire-background.jpg");
        titleImage = new Texture ("Menu/Title.png");
        titleSize = new Dimension(100, 1000, 600, 200);
        titleSize.centerX(handler.screenWidth);
        backgroundSize = new Dimension(0, 0, 800, 1600);
        inputProcessor = new MenuInputProcessor();
        //Start Button Initialization
        Dimension startGameDim = new Dimension(200, 500, 400, 200);
        startGameDim.centerX(handler.screenWidth);
        Texture startGameImg = new Texture("Menu/start-button.png");
        this.startButton = new Button(startGameDim, startGameImg){
            @Override
            public void onClick(float x, float y){
                handler.setActiveState(handler.testState);
            }
        };
        inputProcessor.addButton(this.startButton);
        Gdx.input.setInputProcessor(inputProcessor);
    }

    public void render(SpriteBatch batch){
        Utils.drawImg(batch, backgroundImage, backgroundSize);
        Utils.drawImg(batch, titleImage, titleSize);
        startButton.render(batch);
    }

    public void tick(){

    }
}
