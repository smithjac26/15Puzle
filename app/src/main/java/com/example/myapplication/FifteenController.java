package com.example.myapplication;

import android.view.View;
import android.widget.Button;

public class FifteenController implements View.OnClickListener {
    FifteenModel fifteenGoodLooking;
    FifteenView fifteenLook;

    public FifteenController(FifteenView v, FifteenModel m) {
        fifteenLook = v;
        fifteenGoodLooking = m;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.buttonReset) {
            fifteenLook.resetButtons();
        }
        else {
            Button button = view.findViewById(view.getId());
            fifteenLook.switchAdjacent(button);
        }
    }
}