package com.example.ordenamientos.Algoritmos;

import java.util.List;
import java.util.Collections;

public class Heapsort implements Ordenamiento{

    Boolean termino = false;
    List<Double> lista;

    int tamanioRelativo;



    public Heapsort(List<Double> lista){
        heapify(lista);
        this.lista=lista;
        tamanioRelativo=this.lista.size()-1;
    }



    private int maximo(List<Double> lista,int primerValor, int segundoValor) {
        if (lista.get(primerValor)>lista.get(segundoValor)){
            return primerValor;
        }
        return segundoValor;
    }

    private void heapify(List<Double> lista) {
        for (int i = lista.size()/ 2; i >= 0; i--) {
            downheap(lista,i, 2*i+1, 2*i+2, lista.size()-1);
        }
    }


    private void downheap(List<Double> lista,int posPadre,int posPrimerHijo,int posSegundoHijo,int posUltima) {
        int  posMayor = posPadre;
        if (posPrimerHijo <= posUltima) {
            posMayor = maximo(lista,posMayor, posPrimerHijo);
        }
        if (posSegundoHijo <= posUltima) {
            posMayor = maximo(lista,posMayor, posSegundoHijo);
        }
        if (posMayor == posPadre) {
            return;
        } else {
            Collections.swap(lista,posMayor,posPadre);
            downheap(lista,posMayor, 2*posMayor+1, 2*posMayor+2, posUltima);
        }
    }
    @Override
    public List<Double> ordenarParcialmente() {
        Collections.swap(this.lista,0,this.tamanioRelativo);
        this.tamanioRelativo=this.tamanioRelativo-1;
        if (tamanioRelativo<=0){
            this.termino=true;
        }else{
            downheap(lista,0,1, 2, this.tamanioRelativo);
        }
        return this.lista;
    }
    @Override
    public Boolean termino() {
        return this.termino;
    }


}