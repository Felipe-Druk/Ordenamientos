package com.example.ordenamientos;

import com.example.ordenamientos.Algoritmos.*;
import com.example.ordenamientos.Vista.VistaLista;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class ControladorOrdenamientos extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        List doubles = new ArrayList<Double>();
        doubles.add(11.00);
        doubles.add(4.00);
        doubles.add(6.00);
        doubles.add(8.00);
        doubles.add(1.50);
        doubles.add(3.00);
        doubles.add(3.9);
        doubles.add(1.00);

        VistaLista vista = new VistaLista();
        Scene scene = new Scene(vista.crearHbox(doubles), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

       // Ordenamiento se = new Seleccion(doubles);
       // Ordenamiento se = new Burbuja(doubles);
        //Ordenamiento se = new Quick(doubles);
        //Ordenamiento se = new Mergesort(doubles);
        //Ordenamiento se = new Insercion(doubles);
        Ordenamiento se = new ShellSort(doubles);
        FadeTransition fade = new FadeTransition();
        final int[] repeticones = {0};
        fade.setDuration(Duration.millis(500));
            fade.setNode(stage.getScene().getRoot());
            fade.setOnFinished(e -> {
                try {
                    stage.getScene().setRoot(vista.crearHbox(se.ordenarParcialmente()));
                    stage.show();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                fade.setNode(stage.getScene().getRoot());
                if(!se.termino()){
                    fade.play();
                }
                else System.out.println("termino");
            });
        fade.play();

    }


    public static void main(String[] args) {
        launch();
    }
}