package com.mygdx.game.widgets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Dimension;

public abstract class Button implements Clickable{

    private Dimension dimButton;
    private Texture imgButton;

    public Button(Dimension dimVal, Texture imgVal){
        this.dimButton = dimVal;
        this.imgButton = imgVal;
    }

    public void render(SpriteBatch batch){
        batch.draw(imgButton, dimButton.x, dimButton.y, dimButton.width, dimButton.height);

    }

    public boolean wasClicked(float clickX, float clickY){
        if(clickX <= dimButton.x + dimButton.width && clickX >= dimButton.x
                && clickY <= dimButton.y + dimButton.height && clickY >= dimButton.y){
            return true;
        }
        return false;
    }


}
