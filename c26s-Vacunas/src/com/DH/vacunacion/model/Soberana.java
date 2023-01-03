package com.DH.vacunacion.model;

import com.DH.vacunacion.abs.VacunaStrategy;

public class Soberana extends VacunaStrategy {

    public Soberana(String nombre, String origen, Integer cantDosisAplicar) {
        super(nombre, origen, cantDosisAplicar);
    }

    @Override
    public void informarVacuna() {
        System.out.println("Nombre: " + this.getNombre() + " - Origen: " + this.getOrigen() + " - Cantidad de dosis: " + this.getCantDosisAplicar() + " dosis");
    }
}
