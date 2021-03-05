package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {

    public float getXVal() {
        return xVal;
    }

    public float getYVal() {
        return yVal;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    private float xVal;
    private float yVal;
    private float width;
    private float height;

    public Entity(float widthVal, float heightVal){
        this.xVal = 0;
        this.yVal = 0;
        this.width = widthVal;
        this.height = heightVal;
    }

    public void render(SpriteBatch object){

    }

    public void setPosition(float xNow, float yNow){
        this.xVal = xNow;
        this.yVal = yNow;
    }

}
