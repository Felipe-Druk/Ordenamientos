package com.example.ordenamientos.Algoritmos;

import java.util.ArrayList;
import java.util.List;

public class Quick implements Ordenamiento {
    private double pibote;
    private int izquierda;
    private int derecha;
    private List<Double> lista;
    private List<Double> listaMenores;
    private List<Double> listaMayores;

    private Quick quickMenor;
    private Quick quickMayor;

    public Quick(List<Double> lista) {
        this.lista = lista;
        this.izquierda = 0;
        this.pibote = lista.get(0);
        this.derecha = lista.size()-1;
        this.listaMenores = new ArrayList<>();
        this.listaMayores = new ArrayList<>();
    }
    public Quick(){
        this.izquierda = 0;
        this.pibote = 0;
        this.derecha = 0;
    }
    private void intercambiar(int indice1, int indice2){
        Double valorAux = this.lista.get(indice1);
        this.lista.remove(indice1);
        this.lista.add(indice1, this.lista.get(indice2));
        this.lista.remove(indice2);
        this.lista.add(indice2, valorAux);
    }

    public void setLista(List<Double> lista){
        this.lista = lista;
        this.izquierda = 0;
        this.pibote = lista.get(2);
        this.derecha = lista.size()-1;
        this.listaMenores = new ArrayList<>();
        this.listaMayores = new ArrayList<>();
    }
    @Override
    public Boolean termino() {
        return false;
    }

    @Override
    public List<Double> ordenarParcialmente() {
       if (this.izquierda <= this.derecha){
           if (this.lista.get(this.izquierda) <=this.pibote){
               this.listaMenores.add(this.lista.get(this.izquierda));
               this.izquierda++;
           }
           else{
               this.listaMayores.add(this.lista.get(this.derecha));
               this.derecha--;
           }
       }
       else {
           if(this.izquierda != -1){
               quickMenor  = new Quick(this.listaMenores);
               quickMayor = new Quick(this.listaMayores);
           }
           this.izquierda = -1;
           this.listaMenores = quickMenor.ordenarParcialmente();
           this.listaMayores = quickMayor.ordenarParcialmente();
       }
        List<Double> listAxuliar = new ArrayList<>();
        listAxuliar.addAll(listaMenores);
        listAxuliar.addAll(listaMayores);
        return listAxuliar;
    }
}
