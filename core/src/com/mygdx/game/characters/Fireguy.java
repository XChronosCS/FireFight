package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Dimension;

public abstract class Fireguy extends Character{

    public static float SPEED = 10;

    public Fireguy(float speed, Dimension dim){
        super(speed, dim);
        setPosition(256, 128);
        Texture character = new Texture("Characters/FlameGuy.png");
        setCharacterArt(character);
    }

}
