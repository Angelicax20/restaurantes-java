package com.restaurantes.model.enums;

import java.awt.*;

public enum DishType {
    STARTER("Entrandes"),
    MAIN("princicales"),
    DESSERT("postres");

    private final String label;

    DishType(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }
}
