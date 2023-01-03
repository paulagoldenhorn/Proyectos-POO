package com.DH.instituto.model;

import com.DH.instituto.abs.OfertaAcademica;

import java.util.ArrayList;
import java.util.List;

public class ProgramaIntensivo extends OfertaAcademica {
    private List<OfertaAcademica> ofertasAcademicas;
    private Double descuento;

    public ProgramaIntensivo(String nombere, String descripcion, Double descuento) {
        super(nombere, descripcion);
        this.ofertasAcademicas = new ArrayList<>();
        this.descuento = descuento;
    }

    public void addOfertaAcademica (OfertaAcademica of){
        ofertasAcademicas.add(of);
    }

    @Override
    public Double calcularPrecio() {
        Double sumatoria = 0.0;
        for (OfertaAcademica of : ofertasAcademicas)
            sumatoria += of.calcularPrecio();
        return sumatoria - ( sumatoria * (descuento/100) );
    }
}
