package com.example.ordenamientos.Algoritmos;

import java.util.List;

public class Seleccion implements Ordenamiento {

    private int indiceActual;
    private List<Double> lista;

    public Seleccion(List<Double> lista) {
        this.lista = lista;
        this.indiceActual = 0;
    }
    private int indiceMinimo(){
        int indiceMinimo = this.indiceActual;
        for (int i = this.indiceActual; i< this.lista.size(); i++){
            if(this.lista.get(indiceMinimo).compareTo(this.lista.get(i)) > 0){
                indiceMinimo = i;
            }
        }
        return indiceMinimo;
    }
    private void cambiar(int indiceMinimo){
        Double valorAux = this.lista.get(indiceMinimo);
        this.lista.remove(indiceMinimo);
        this.lista.add(indiceMinimo, this.lista.get(this.indiceActual));
        this.lista.remove(this.indiceActual);
        this.lista.add(this.indiceActual, valorAux);
    }

    @Override
    public Boolean termino() {
        return (this.indiceActual == this.lista.size()-1);
    }

    @Override
    public List<Double> ordenarParcialmente() {
        int indiceMinimo = indiceMinimo();
        cambiar(indiceMinimo);
        this.indiceActual++;
        return this.lista;
    }
}
