package com.mygdx.game.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Dimension;
import com.mygdx.game.Entity;
import com.mygdx.game.utils.Utils;

import sun.rmi.runtime.Log;

public abstract class Character extends Entity {

    private Texture characterArt;
    private Texture baseArt;
    private final float ACCELERATION = 5;
    private float BASE_SPEED;
    private int score = 0;

    public float getSpeed() {
        return speed;
    }

    public void incrementSpeed(){
        this.speed += ACCELERATION;
        score++;
    }

    public int getScore() {
        return score;
    }

    public void resetSpeed(){
        this.speed = BASE_SPEED;
        score = 0;
    }

    public Vector2 getPosition() {
        return position;
    }

    private float speed;
    private Vector2 position;

    @Override
    public float getXVal(){
        return this.dim.x;
    }

    @Override
    public float getYVal(){
        return this.dim.y;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    private float angle;
    private Dimension dim;
    //private Projectile projectile; //for future updates

    public Character(float speedVal, Dimension dimension){
        super(dimension.x, dimension.y);
        this.dim = dimension;
        this.speed = speedVal;
        this.BASE_SPEED = speedVal;
        position = new Vector2(dimension.x, dimension.y);
        //this.projectile = bullet;
    }
    public abstract void moveCharacter(float newX, float newY);

    public void setCharacterArt(Texture art){
        this.characterArt = art;
        this.baseArt = art;
    }

    public void updateDimension(Dimension dim){
        this.dim = dim;
    }



    public void render(SpriteBatch batch){
        Utils.drawImg(batch, this.characterArt, this.dim);
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

    public Vector2 getOrigin(){
        return new Vector2(this.getXCenter(), this.getYCenter());
    }

    public float getAngle() {
        return angle;
    }

    public void rotate(int direction){
        switch(direction){
            case 0:
                this.characterArt = baseArt;
                //Gdx.app.debug("Case 0", "Case 0 works fine.");
                break;
            case 1:
                this.characterArt = new Texture("Characters/FlameGuyBack.png");
                //Gdx.app.debug("Case 1", "Case 1 works fine.");
                break;
            case 2:
                this.characterArt = new Texture("Characters/FlameGuyUp.png");
               // Gdx.app.debug("Case 2", "Case 2 works fine.");
                break;
            case 3:
                this.characterArt = new Texture("Characters/FlameGuyDown.png");
               // Gdx.app.debug("Case 3", "Case 3 works fine.");
                break;
        }
    }




}
