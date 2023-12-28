package com.example.ordenamientos.Algoritmos;

import java.util.ArrayList;
import java.util.List;

public class Mergesort implements Ordenamiento {

    private Boolean termino = false;
    private List<Double> lista;
    private int paso=2;
    public Mergesort(List<Double> lista){
        this.lista=lista;
    }


    private void merge(int inicio, int medio, int fin){

        medio=mantenerRango(medio);
        fin=mantenerRango(fin);
        List<Double> izq = this.lista.subList(inicio,medio);
        List<Double> der = this.lista.subList(medio,fin);
        List<Double> aux = new ArrayList<>();

        int k = 0;
        int i=0;
        int j=0;



        while (i<izq.size() && j<der.size()){
            if (izq.get(i)<der.get(j)){
                aux.add(k,izq.get(i));
                i+=1;
            }else{

                aux.add(k,der.get(j));
                j+=1;
            }
            k+=1;
        }
        while (i<(izq.size())){

            aux.add(k,izq.get(i));
            k+=1;
            i+=1;
        }
        while (j<(der.size())){

            aux.add(k, der.get(j));
            k+=1;
            j+=1;
        }

        this.lista.addAll(inicio,aux);
        this.lista.subList(fin, fin * 2 - inicio).clear();

        
    }

    private int mantenerRango(int indice){
        if (indice>this.lista.size()){
            indice=this.lista.size();
        }
        return indice;

    }

    @Override
    public List<Double> ordenarParcialmente() {
        for (int i=0;i<this.lista.size();i+=this.paso){
            merge(i,i+(int)(this.paso/2),i+(this.paso));
            if (i == 0 && (i+this.paso)>=this.lista.size()){
                this.termino=true;
            }
        }
                this.paso=this.paso*2;

        return this.lista;
    }

    @Override
    public Boolean termino() {
        return this.termino;
    }
}



