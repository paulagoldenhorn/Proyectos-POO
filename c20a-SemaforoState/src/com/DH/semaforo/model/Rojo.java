package com.DH.semaforo.model;

import com.DH.semaforo.comp.StateSemaforo;

public class Rojo implements StateSemaforo {
    private Semaforo s;

    public Rojo(Semaforo s) {
        this.s = s;
    }

    @Override
    public void mostrarAviso() {
        System.out.println(s.toString());
    }

    @Override
    public void cambiarEstado() {
        s.setEstadoActual(new Verde(s));
        System.out.println("Estado pasa a Verde");
    }
}
