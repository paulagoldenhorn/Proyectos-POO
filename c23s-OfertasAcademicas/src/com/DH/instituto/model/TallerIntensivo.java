package com.DH.instituto.model;

import com.DH.instituto.abs.OfertaAcademica;
import com.DH.instituto.factory.OfertaAcademicaFactory;

public class TallerIntensivo extends OfertaAcademica {
    private Integer numeroDeTP;
    private Double costoPorTP;

    public TallerIntensivo(String nombere, String descripcion, Integer numeroDeTP, Double costoPorTP) {
        super(nombere, descripcion);
        this.numeroDeTP = numeroDeTP;
        this.costoPorTP = costoPorTP;
    }

    @Override
    public Double calcularPrecio() {
        return numeroDeTP * costoPorTP;
    }
}
