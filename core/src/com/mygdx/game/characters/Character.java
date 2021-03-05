package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Entity;

public class Character extends Entity {

    private Texture characterArt;
    private float speed;
    //private Projectile projectile; //for future updates

    public Character(float X, float Y, float speedVal){
        super(X, Y);
        this.speed = speedVal;
        //this.projectile = bullet;
    }

    public void setCharacterArt(Texture art){this.characterArt = art;}

    public void render(SpriteBatch batch){
        batch.draw(this.characterArt, this.getXVal(), this.getYVal(), this.getWidth(), this.getHeight());
    }

    public void dispose(){this.characterArt.dispose();}

    public void moveLeft(){
        float newPos = getXVal() - speed;
        setPosition(newPos, getYVal());
    }

    public void moveRight(){
        float newPos = getXVal() + speed;
        setPosition(newPos, getYVal());
    }

    public void moveUp(){
        float newPos = getYVal() + speed;
        setPosition(getXVal(), newPos);
    }

    public void moveDown(){
        float newPos = getYVal() - speed;
        setPosition(getXVal(), newPos);
    }



}
