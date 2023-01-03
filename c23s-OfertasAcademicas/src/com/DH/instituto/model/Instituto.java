package com.DH.instituto.model;

import com.DH.instituto.abs.OfertaAcademica;
import com.DH.instituto.exception.OAFactoryException;
import com.DH.instituto.factory.OfertaAcademicaFactory;

import java.util.ArrayList;
import java.util.List;

public class Instituto {
    private List<OfertaAcademica> ofertasAcademicas;

    public Instituto() {
        this.ofertasAcademicas = new ArrayList<>();
    }

    public void addOfertaAcademica(String codigo){
        try {
            ofertasAcademicas.add(OfertaAcademicaFactory.getInstance().crearOfertaAcademica(codigo));
        } catch (OAFactoryException of){
            of.printStackTrace();
        }
    }

    public void generarInforme(){
        for (OfertaAcademica of : ofertasAcademicas)
            System.out.println(of.getNombere() + " $" + of.calcularPrecio());
    }
}
