package com.mygdx.game.states.test;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.characters.Fireguy;
import com.mygdx.game.utils.Handler;
import com.mygdx.game.utils.Utils;
import com.mygdx.game.widgets.Button;

import java.util.ArrayList;

public class TestInputProcessor implements InputProcessor {
    private Handler handler;
    private Fireguy blaze;
    private ArrayList<Button> buttonArrayList;


    public TestInputProcessor(){
        buttonArrayList = new ArrayList<>();
        handler = Handler.getInstance();
    }

    public void addButton(Button button) {buttonArrayList.add(button);}

    public void setBlaze(Fireguy hot) {
        blaze = hot;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Vector3 mathVector = Utils.getCameraPosFromMousePos(handler.camera, screenX, screenY);
        float translatedX = mathVector.x;
        float translatedY = mathVector.y;
        for(int i = 0; i < buttonArrayList.size(); i++){
            Button curButton = buttonArrayList.get(i);
            if(curButton.wasClicked(translatedX, translatedY)){
                curButton.onClick(translatedX, translatedY);
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}


