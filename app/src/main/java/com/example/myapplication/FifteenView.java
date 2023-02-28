package com.example.myapplication;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class FifteenView {

    private Button[][] buttons;

    private FifteenModel fifteenGoodLooking;

    public FifteenView(FifteenModel f) {
        fifteenGoodLooking = f;
        buttons = new Button[4][5];
    }

    public void addButton(int row, int col, Button b) {
        buttons[row][col] = b;
    }

    public void switchButtons(Button uno, Button dos) {
        int[] unoPos = position(uno);
        int[] dosPos = position(dos);

        String unoText = (String)buttons[unoPos[0]][unoPos[1]].getText();
        buttons[unoPos[0]][unoPos[1]].setText(buttons[dosPos[0]][dosPos[1]].getText());
        buttons[dosPos[0]][dosPos[1]].setText(unoText);

        Float unoAlpha = buttons[unoPos[0]][unoPos[1]].getAlpha();
        buttons[unoPos[0]][unoPos[1]].setAlpha(buttons[dosPos[0]][dosPos[1]].getAlpha());
        buttons[dosPos[0]][dosPos[1]].setAlpha(unoAlpha);
    }

    public void switchAdjacent(Button view) {
        int[] pos = position(view);
        int row = pos[0];
        int col = pos[1];

        if (isValid(row + 1, col) && couldSwitch(buttons[row + 1][col])) {
            switchButtons(buttons[row][col], buttons[row + 1][col]);
        }
        else if (isValid(row - 1, col) && couldSwitch(buttons[row - 1][col])) {
            switchButtons(buttons[row][col], buttons[row - 1][col]);
        }
        else if (isValid(row, col + 1) && couldSwitch(buttons[row][col + 1])) {
            switchButtons(buttons[row][col], buttons[row][col + 1]);
        }
        else if (isValid(row, col - 1) && couldSwitch(buttons[row][col - 1])) {
            switchButtons(buttons[row][col], buttons[row][col - 1]);
        }
    }


    public boolean isValid(int row, int col) {
        Log.d("debug", "isValid worked!!!");
        if(row > -1 && row < 4 && col > -1 && col < 4) {
            return true;
        }
        return false;
    }

    public boolean couldSwitch(Button button) {
        Log.d("debug", "couldSwitch worked!!!");
        if(button.getAlpha() <= .5) {
            return true;
        }
        return false;
    }

    public int[] position(Button view) {
        int[] pos = new int[2];
        for(int i = 0;i < 4;i++){
            for(int j = 0; j < 4; j++) {
                if(buttons[i][j] == view) {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }

    public void resetButtons() {
        ArrayList<Integer> pos = new ArrayList<>();
        for(int i = 1;i < 17;i++) {
            pos.add(i);
        }

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                Integer currValue = fifteenGoodLooking.getRNG(pos.size());
                buttons[i][j].setText(pos.get(currValue).toString());
                pos.remove((int)currValue);
                if(buttons[i][j].getText() == "16") {
                    buttons[i][j].setAlpha(0.0f);
                }
                else {
                    buttons[i][j].setAlpha(1.0f);
                }
            }
        }
    }
    void setOnClick(FifteenController game) {

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                buttons[i][j].setOnClickListener(game);
            }
        }
        buttons[3][4].setOnClickListener(game);
    }

}
