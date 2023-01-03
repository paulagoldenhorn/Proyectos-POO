package com.DH.instituto.model;

import com.DH.instituto.abs.OfertaAcademica;
import com.DH.instituto.exception.OAFactoryException;
import com.DH.instituto.factory.OfertaAcademicaFactory;

import java.util.ArrayList;
import java.util.List;

public class Carrera extends OfertaAcademica {
    private Double costoBasico;
    private List<OfertaAcademica> cursosYtalleres;

    public Carrera(String nombere, String descripcion, Double costoBasico) {
        super(nombere, descripcion);
        this.costoBasico = costoBasico;
        this.cursosYtalleres = new ArrayList<>();
    }

    public void addCursoOTaller(OfertaAcademica of) throws OAFactoryException {
        if ( of instanceof ProgramaIntensivo || of instanceof Carrera ) {
            throw new OAFactoryException("No puede agregar una oferta academica distinta a un curso o taller");
        } else {
            cursosYtalleres.add(of);
        }

    }

    @Override
    public Double calcularPrecio() {
        Double sumatoria = 0.0;
        for (OfertaAcademica of : cursosYtalleres)
            sumatoria += of.calcularPrecio();
        return sumatoria + costoBasico;
    }
}
