package com.DH.vacunacion.model;

import com.DH.vacunacion.abs.VacunaStrategy;

public class Moderna extends VacunaStrategy {

    public Moderna(String nombre, String origen, Integer cantDosisAplicar) {
        super(nombre, origen, cantDosisAplicar);
    }

    @Override
    public void informarVacuna() {
        System.out.println("Nombre: " + this.getNombre() + " - Origen: " + this.getOrigen() + " - Cantidad de dosis: " + this.getCantDosisAplicar() + " dosis");
        System.out.println("EFECTOS SECUNDARIOS");
        System.out.println("-> Dolor de cabeza despues de su aplicacion");
        System.out.println("RECOMENDACOINES");
        System.out.println("-> Tomar ibupirac luego de su aplicacion");
    }
}
