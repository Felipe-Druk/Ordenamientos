package com.example.ordenamientos.Vista;

import javafx.geometry.Pos;

import javafx.scene.layout.HBox;

import javafx.scene.shape.Rectangle;

import java.util.List;

public class VistaLista {

    public HBox crearHbox(List<Double> lista) throws Exception {

        HBox raiz = new HBox();
        double valorBase = 10;
        raiz.setAlignment(Pos.BOTTOM_LEFT);
        raiz.setSpacing(2);
        Rectangle rectangulo;
        for (Double con: lista){
            rectangulo= new Rectangle(50, con*valorBase);
            raiz.getChildren().add(rectangulo);
        }
        return raiz;
    }
}
