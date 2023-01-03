package com.DH.vacunacion.abs;

public abstract class VacunaStrategy {
    private String nombre;
    private String origen;
    private Integer cantDosisAplicar;

    public VacunaStrategy(String nombre, String origen, Integer cantDosisAplicar) {
        this.nombre = nombre;
        this.origen = origen;
        this.cantDosisAplicar = cantDosisAplicar;
    }

    public abstract void informarVacuna();

    public Integer getCantDosisAplicar() {
        return cantDosisAplicar;
    }

    public String getNombre() {
        return nombre;
    }

    public String getOrigen() {
        return origen;
    }
}
