package com.example.myapplication;

import java.util.ArrayList;
import java.util.Random;

public class FifteenModel {

    int row;
    int col;
    Random rng;
    boolean win;
    public FifteenModel() {
        row = 0;
        col = 0;
        rng = new Random();
        win = false;
    }

    public int getRNG(int size) {
        return rng.nextInt(size);
    }
}
