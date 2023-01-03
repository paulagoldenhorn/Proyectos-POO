package com.DH.semaforo.model;

import com.DH.semaforo.comp.StateSemaforo;

public class Semaforo {
    private StateSemaforo estadoActual;

    public Semaforo() {
        this.estadoActual = new Verde(this);
    }

    protected void setEstadoActual(StateSemaforo estadoActual) {
        this.estadoActual = estadoActual;
    }

    protected StateSemaforo getEstadoActual() {
        return estadoActual;
    }

    @Override
    public String toString() {
        return " -- Estado actual: " + estadoActual.getClass().getSimpleName();
    }

    public void mostrarAviso(){
        getEstadoActual().mostrarAviso();
    }
    public void cambiarEstado(){
        getEstadoActual().cambiarEstado();
    }
}
