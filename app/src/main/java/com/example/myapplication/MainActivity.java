package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FifteenModel fifteenGoodLooking = new FifteenModel();

        FifteenView fifteenlook = new FifteenView(fifteenGoodLooking);

        fifteenlook.addButton(0,0,findViewById(R.id.button00));
        fifteenlook.addButton(0,1,findViewById(R.id.button01));
        fifteenlook.addButton(0,2,findViewById(R.id.button02));
        fifteenlook.addButton(0,3,findViewById(R.id.button03));
        fifteenlook.addButton(1,0,findViewById(R.id.button10));
        fifteenlook.addButton(1,1,findViewById(R.id.button11));
        fifteenlook.addButton(1,2,findViewById(R.id.button12));
        fifteenlook.addButton(1,3,findViewById(R.id.button13));
        fifteenlook.addButton(2,0,findViewById(R.id.button20));
        fifteenlook.addButton(2,1,findViewById(R.id.button21));
        fifteenlook.addButton(2,2,findViewById(R.id.button22));
        fifteenlook.addButton(2,3,findViewById(R.id.button23));
        fifteenlook.addButton(3,0,findViewById(R.id.button30));
        fifteenlook.addButton(3,1,findViewById(R.id.button31));
        fifteenlook.addButton(3,2,findViewById(R.id.button32));
        fifteenlook.addButton(3,3,findViewById(R.id.button33));
        fifteenlook.addButton(3,4,findViewById(R.id.buttonReset));



        FifteenController fifteenControlling = new FifteenController(fifteenlook, fifteenGoodLooking);

        fifteenlook.setOnClick(fifteenControlling);
    }
}