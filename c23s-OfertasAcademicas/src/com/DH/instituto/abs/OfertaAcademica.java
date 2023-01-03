package com.DH.instituto.abs;

public abstract class OfertaAcademica {
    private String nombere;
    private String descripcion;

    public OfertaAcademica(String nombere, String descripcion) {
        this.nombere = nombere;
        this.descripcion = descripcion;
    }

    public abstract Double calcularPrecio();

    public String getNombere() {
        return nombere;
    }
}
