package com.example.ninjawulf98.integration.model;

/**
 * Created by nickv on 18/12/2017.
 */

public class lamp {
    private boolean aan = false;

    public lamp(boolean aan) {
        this.aan = aan;
    }

    public boolean isAan() {
        return aan;
    }

    public void setAan(boolean aan) {
        this.aan = aan;
    }
}
