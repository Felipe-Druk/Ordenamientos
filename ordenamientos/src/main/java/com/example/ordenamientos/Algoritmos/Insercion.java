package com.example.ordenamientos.Algoritmos;

import java.util.List;

public class Insercion implements Ordenamiento {

    private int inicio;

    private int indiceActual;

    private List<Double> lista;

    public Insercion(List<Double> lista) {
        this.lista = lista;
        this.inicio = 0;
        this.indiceActual = 1;
    }

    private void intercambiar(int indice1, int indice2){
        Double valorAux = this.lista.get(indice1);
        this.lista.add(indice1, this.lista.get(indice2));
        this.lista.remove(valorAux);
        this.lista.remove(indice2);
        this.lista.add(indice2, valorAux);
    }
    @Override
    public List<Double> ordenarParcialmente() {
        if(this.indiceActual == 0){
            inicio++;
            this.indiceActual = inicio+1;
        }
        if(this.lista.get(indiceActual) < this.lista.get(indiceActual-1)){
            this.intercambiar(this.indiceActual, this.indiceActual-1);
            this.indiceActual--;
        }else {
            this.indiceActual=0;
        }
        return this.lista;
    }

    @Override
    public Boolean termino() {
        return (this.inicio >= lista.size()-1);
    }
}
