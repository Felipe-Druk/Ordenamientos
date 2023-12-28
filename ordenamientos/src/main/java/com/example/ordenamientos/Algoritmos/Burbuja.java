package com.example.ordenamientos.Algoritmos;

import java.util.List;

public class Burbuja implements Ordenamiento {

    private int fin;

    private int indiceActual;

    private List<Double> lista;

    public Burbuja(List<Double> lista) {
        this.lista = lista;
        this.fin = lista.size()-1;
        this.indiceActual = 0;
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
        if(this.lista.get(this.indiceActual) > this.lista.get(this.indiceActual+1)){
            intercambiar(this.indiceActual, this.indiceActual+1);
        }
        indiceActual++;
        if(this.indiceActual == this.fin){
            this.fin--;
            this.indiceActual = 0;
        }
        return this.lista;
    }

    @Override
    public Boolean termino() {
        return (this.fin == 0);
    }
}
