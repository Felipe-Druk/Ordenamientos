package com.example.ordenamientos.Algoritmos;

import java.util.ArrayList;
import java.util.List;

public class Quick implements Ordenamiento {
    private double pibote;
    private int iteraciones;
    private List<Double> lista;
    private List<Double> listaMenores;
    private List<Double> listaMayores;

    private Quick quickMenor;
    private Quick quickMayor;

    public Quick(List<Double> lista) {
        this.lista = lista;
        this.iteraciones = 0;
        if(this.lista.size() > 0){
            this.pibote = lista.get(0);
        }
        this.listaMenores = new ArrayList<>();
        this.listaMayores = new ArrayList<>();
    }

    public void setLista(List<Double> lista){
        this.lista = lista;
        this.iteraciones = 0;
        this.pibote = lista.get(2);
        this.listaMenores = new ArrayList<>();
        this.listaMayores = new ArrayList<>();
    }
    @Override
    public Boolean termino() {
        if(this.quickMenor != null || this.quickMayor != null){
            Boolean termino = true;
            if(this.quickMayor != null){
                termino &= quickMayor.termino();
            }
            if(this.quickMenor != null){
                termino &= quickMenor.termino();
            }
            return termino;
        }
        return (this.lista.size() <= 1);
    }

    @Override
    public List<Double> ordenarParcialmente() {
        if (this.iteraciones <= this.lista.size()-1) {
            if (this.lista.get(this.iteraciones) < this.pibote) {
                this.listaMenores.add(this.lista.get(this.iteraciones));
            }
            else if (this.lista.get(this.iteraciones) > this.pibote){
                this.listaMayores.add(this.lista.get(this.iteraciones));
            }
            this.iteraciones++;
        }
        else {
            if (this.iteraciones != this.lista.size()*10) {
                if(this.listaMayores.size() > 0){
                    quickMayor = new Quick(this.listaMayores);
                }
                if(this.listaMenores.size() > 0){
                    quickMenor = new Quick(this.listaMenores);
                }
            }
            this.iteraciones = this.lista.size()*10;
            if (quickMenor != null){
                this.listaMenores = quickMenor.ordenarParcialmente();
            }
            if (this.quickMayor != null) {
                    this.listaMayores = quickMayor.ordenarParcialmente();
             }
       }
        List<Double> listAxuliar = new ArrayList<>();
        listAxuliar.addAll(listaMenores);
        listAxuliar.add(pibote);
        listAxuliar.addAll(listaMayores);

        return listAxuliar;
    }
}
