package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Dimension;

public abstract class Fireguy extends Character{

    public static float SPEED = 10;
    public float acceleration = 0;


    public Fireguy(float speed, Dimension dim){
        super(speed, dim);
        setPosition(256, 128);
        Texture character = new Texture("Characters/FlameGuy.png");
        setCharacterArt(character);
    }



}
