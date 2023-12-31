package com.example.ordenamientos.Algoritmos;

import java.util.List;

public class ShellSort implements Ordenamiento {
    private int intervalo;
    private int inicio;

    private int indiceActual;

    protected List<Double> lista;

    public ShellSort(List<Double> lista) {
        this.lista = lista;
        this.inicio = 0;
        this.indiceActual = this.inicio+1;
        this.intervalo = lista.size()/2;
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
        if(this.indiceActual <= 0){
            inicio++;
            this.indiceActual = inicio+1;
        }
        if(this.inicio >= lista.size()-1){
            this.intervalo /= 2;
            this.inicio = 0;
            this.indiceActual = inicio+1;
        }
        try{
            if(this.lista.get(indiceActual) < this.lista.get(indiceActual-this.intervalo)){
                this.intercambiar(this.indiceActual, this.indiceActual-this.intervalo);

            }else {
                this.indiceActual = 0;
            }
        } catch (Exception e){
            this.indiceActual = 0;
            return this.lista;
        }
        return this.lista;
    }

    @Override
    public Boolean termino() {
        return (this.intervalo < 1);
    }
}
