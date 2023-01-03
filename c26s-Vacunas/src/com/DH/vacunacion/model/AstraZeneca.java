package com.DH.vacunacion.model;

import com.DH.vacunacion.abs.VacunaStrategy;

public class AstraZeneca extends VacunaStrategy {

    public AstraZeneca(String nombre, String origen, Integer cantDosisAplicar) {
        super(nombre, origen, cantDosisAplicar);
    }

    @Override
    public void informarVacuna() {
        System.out.println("Nombre: " + this.getNombre() + " - Origen: " + this.getOrigen() + " - Cantidad de dosis: " + this.getCantDosisAplicar() + " dosis");
        System.out.println("EFECTOS SECUNDARIOS");
        System.out.println("-> Tendencia de fiebre luego de su aplicacion");
    }
}
