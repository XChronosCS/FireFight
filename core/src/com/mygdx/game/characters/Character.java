package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Dimension;
import com.mygdx.game.Entity;

public abstract class Character extends Entity {

    private Texture characterArt;
    private float speed;
    private Vector2 position;
    private float angle;
    private Dimension dim;
    //private Projectile projectile; //for future updates

    public Character(float speedVal, Dimension dimension){
        super(dimension.x, dimension.y);
        this.dim = dimension;
        this.speed = speedVal;
        position = new Vector2(dimension.x, dimension.y);
        //this.projectile = bullet;
    }
    public abstract void moveCharacter(float newX, float newY);

    public void setCharacterArt(Texture art){this.characterArt = art;}



    public void render(SpriteBatch batch){
        batch.draw(this.characterArt, this.getXVal(), this.getYVal(), this.getWidth(), this.getHeight());
    }

    public Texture getCharacterArt() {
        return characterArt;
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

    public float getXCenter(){
        return position.x + characterArt.getWidth() / (float)2;
    }

    public float getYCenter(){
        return position.y + characterArt.getHeight()/(float)2;
    }

    private Vector2 getOrigin(){
        return new Vector2(this.getXCenter(), this.getYCenter());
    }

    public float getAngle() {
        return angle;
    }

    public void update(SpriteBatch batch, Vector2 target){
        Vector2 followPath = target.cpy().sub(getOrigin());
        followPath.nor();
        Vector2 velocity = followPath.scl(speed);
        angle = velocity.angleDeg();
        position.add(velocity);
        batch.draw(this.getCharacterArt(),
                this.getXVal(),
                this.getYVal(),
                this.getWidth()/2,
                this.getHeight()/2,
                this.getWidth(),
                this.getHeight(),
                1,
                1,
                getAngle(),
                0,
                0,
                (int) this.getWidth(),
                (int) this.getHeight(),
                false,
                false);
    }



}
