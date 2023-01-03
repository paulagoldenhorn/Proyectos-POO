package com.DH.semaforo.model;

import com.DH.semaforo.comp.StateSemaforo;

public class Amarillo implements StateSemaforo {
    private Semaforo s;

    public Amarillo(Semaforo s) {
        this.s = s;
    }

    @Override
    public void mostrarAviso() {
        System.out.println(s.toString());
    }

    @Override
    public void cambiarEstado() {
        s.setEstadoActual(new Rojo(s));
        System.out.println("Estado pasa a Rojo");
    }
}
