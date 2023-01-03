package com.DH.instituto.model;

import com.DH.instituto.abs.OfertaAcademica;

public class Curso extends OfertaAcademica {
    private Double cargaHoraria;
    private Double mesesDuracion;
    private Double valorHora;

    public Curso(String nombere, String descripcion, Double cargaHoraria, Double mesesDuracion, Double valorHora) {
        super(nombere, descripcion);
        this.cargaHoraria = cargaHoraria;
        this.mesesDuracion = mesesDuracion;
        this.valorHora = valorHora;
    }

    @Override
    public Double calcularPrecio() {
        return cargaHoraria * mesesDuracion * valorHora;
    }
}
