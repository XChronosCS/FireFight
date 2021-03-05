package com.mygdx.game.characters;

import com.badlogic.gdx.graphics.Texture;

public class Fireguy extends Character{

    public static float SPEED = 10;

    public Fireguy(){
        super(120, 120, Fireguy.SPEED);
        setPosition(256, 128);
        Texture character = new Texture("Characters/FlameGuy.png");
        setCharacterArt(character);
    }

}
