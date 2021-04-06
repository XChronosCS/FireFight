package com.mygdx.game.states.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Dimension;
import com.mygdx.game.characters.Fireguy;
import com.mygdx.game.states.GameState;
import com.mygdx.game.utils.Handler;
import com.mygdx.game.utils.Utils;
import com.mygdx.game.widgets.Button;

public class TestState extends GameState {

    private final float SPEED = 10;
    private Texture backgroundImage;
    private Dimension backgroundSize;
    private TestInputProcessor inputProcessor;
    private Dimension characterSize;
    private Fireguy fireball;
    private Handler handler;
    private Vector2 mousePos;
    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;
    private BitmapFont score;


    public TestState() {
        handler = Handler.getInstance();
        backgroundImage = new Texture("Menu/background-black.png");
        characterSize = new Dimension(100, 100, 200, 200);
        backgroundSize = new Dimension(0, 0, 800, 1600);
        inputProcessor = new TestInputProcessor();
        Texture upArrow = new Texture("Menu/UpArrow.png");
        Texture leftArrow = new Texture("Menu/LeftArrow.png");
        Texture downArrow = new Texture("Menu/DownArrow.png");
        Texture rightArrow = new Texture("Menu/RightArrow.png");
        Dimension leftArrowSize = new Dimension(302, 1600 - 1255, 161, 165);
        Dimension rightArrowSize = new Dimension(619, 1600 - 1255, 161, 165);
        Dimension upArrowSize = new Dimension(466, 1600 - 1102, 165, 161);
        Dimension downArrowSize = new Dimension(466, 1600 - 1427, 165, 161);
        score = new BitmapFont();
        score.getData().setScale(5);


        mousePos = new Vector2(0, 0);
        //Main Character Initialization


        this.fireball = new Fireguy(SPEED, characterSize) {
            public void moveCharacter(float xVal, float yVal) {
                mousePos.set(xVal, yVal);
            }
        };

        upButton = new Button(upArrowSize, upArrow) {
            @Override
            public void onClick(float x, float y) {
                if (fireball.getYVal() + fireball.getSpeed() <= backgroundSize.height - fireball.getHeight()) {
                    characterSize.y += fireball.getSpeed();
                    fireball.updateDimension(characterSize);
                    fireball.rotate(2);
                    fireball.incrementSpeed();
                }
                else{
                    boundsCheck();
                }
            }
        };
        downButton = new Button(downArrowSize, downArrow) {
            @Override
            public void onClick(float x, float y) {
                if (fireball.getYVal() - fireball.getSpeed() > 0 ) {
                    characterSize.y -= fireball.getSpeed();
                    fireball.updateDimension(characterSize);
                    fireball.rotate(3);
                    fireball.incrementSpeed();
                }else{
                    boundsCheck();
                }
            }
        };
        leftButton = new Button(leftArrowSize, leftArrow) {
            @Override
            public void onClick(float x, float y) {
                if (fireball.getXVal() - fireball.getSpeed() > 0) {
                    characterSize.x -= fireball.getSpeed();
                    fireball.updateDimension(characterSize);
                    fireball.rotate(1);
                    fireball.incrementSpeed();
                }
                else{
                    boundsCheck();
                }
            }
        };
        rightButton = new Button(rightArrowSize, rightArrow) {
            @Override
            public void onClick(float x, float y) {
                if (fireball.getXVal() + fireball.getSpeed() < backgroundSize.width - fireball.getWidth()) {
                    characterSize.x += fireball.getSpeed();
                    fireball.updateDimension(characterSize);
                    fireball.rotate(0);
                    fireball.incrementSpeed();
                }
                else{
                    boundsCheck();
                }

            }

        };
        inputProcessor.setBlaze(fireball);
        inputProcessor.addButton(upButton);
        inputProcessor.addButton(downButton);
        inputProcessor.addButton(rightButton);
        inputProcessor.addButton(leftButton);

    }
    private void boundsCheck() {
            characterSize.x = 100;
            characterSize.y = 100;
            fireball.updateDimension(characterSize);
            fireball.resetSpeed();
    }


    public void setActiveInputProcessor() {
        Gdx.input.setInputProcessor(inputProcessor);
    }


    public void render(SpriteBatch batch) {
        Utils.drawImg(batch, backgroundImage, backgroundSize);
        upButton.render(batch);
        downButton.render(batch);
        leftButton.render(batch);
        rightButton.render(batch);
        fireball.render(batch);
        score.draw(batch, "Score: " + String.valueOf(fireball.getScore()), 400, 160);
    }

    public void tick() {

    }
}
