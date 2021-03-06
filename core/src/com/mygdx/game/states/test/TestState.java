package com.mygdx.game.states.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Dimension;
import com.mygdx.game.characters.Fireguy;
import com.mygdx.game.states.GameState;
import com.mygdx.game.states.menu.MenuInputProcessor;
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

    public TestState(){
        handler = Handler.getInstance();
        backgroundImage = new Texture("Menu/fire-background.jpg");
        characterSize = new Dimension(100, 100, 200, 200);
        backgroundSize = new Dimension(0, 0, 800, 1600);
        inputProcessor = new TestInputProcessor();
        mousePos = new Vector2(0, 0);
        //Main Character Initialization


        this.fireball = new Fireguy(SPEED, characterSize){
            public void moveCharacter(float xVal, float yVal) {
                mousePos.set(xVal, yVal);
            }
        };
        inputProcessor.setBlaze(fireball);
        Gdx.input.setInputProcessor(inputProcessor);
    }

    public void render(SpriteBatch batch){
        Utils.drawImg(batch, backgroundImage, backgroundSize);
        Utils.drawImg(batch, fireball.getCharacterArt(), characterSize);
        fireball.render(batch);
        fireball.update(batch, mousePos);
    }

    public void tick(){

    }
}
