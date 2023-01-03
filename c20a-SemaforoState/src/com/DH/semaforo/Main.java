package com.DH.semaforo;

import com.DH.semaforo.model.Semaforo;

public class Main {
    public static void main(String[] args) {

        Semaforo s = new Semaforo();

        s.mostrarAviso();
        s.cambiarEstado(); // amarillo
        s.mostrarAviso();
        s.cambiarEstado(); // rojo
        s.mostrarAviso();
        s.cambiarEstado(); // verde
        s.mostrarAviso();

    }
}
