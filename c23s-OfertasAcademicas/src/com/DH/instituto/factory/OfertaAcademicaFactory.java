package com.DH.instituto.factory;

import com.DH.instituto.abs.OfertaAcademica;
import com.DH.instituto.exception.OAFactoryException;
import com.DH.instituto.model.Carrera;
import com.DH.instituto.model.Curso;
import com.DH.instituto.model.ProgramaIntensivo;
import com.DH.instituto.model.TallerIntensivo;

public class OfertaAcademicaFactory {
    private static OfertaAcademicaFactory instance;

    public static final String BACKEND = "BE";
    public static final String FRONTEND = "FE";
    public static final String FULLSTACK = "FSK";
    public static final String METODOLOGIAS = "MET";
    public static final String DESIGN_THINKING = "DTHK";
    public static final String CERTIFIED_DEVELOPER = "CTD";

    private OfertaAcademicaFactory(){}

    public static OfertaAcademicaFactory getInstance(){
        if (instance == null)
            instance = new OfertaAcademicaFactory();
        return instance;
    }

    public OfertaAcademica crearOfertaAcademica(String codigo) throws OAFactoryException {
        switch (codigo) {
            case "BE":
                return new Curso("Back End", "Curso de back end", 20.0, 2.0, 900.0);
            case "FE":
                return new Curso("Front End", "Curso de Front End", 16.0, 2.0, 1000.0);
            case "FSK":
                ProgramaIntensivo programaIntensivo = new ProgramaIntensivo("Full Stack", "Programa Full Stack incluye curso Back End y Front End", 20.0);
                programaIntensivo.addOfertaAcademica(crearOfertaAcademica(OfertaAcademicaFactory.BACKEND));
                programaIntensivo.addOfertaAcademica(crearOfertaAcademica(OfertaAcademicaFactory.FRONTEND));
                return programaIntensivo;
            case "MET":
                return new TallerIntensivo("Metodologias Agiles", "Taller de metodologias agiles", 10, 900.0);
            case "DTHK":
                return new TallerIntensivo("Design Thinking", "Taller de design thinking", 10, 1000.0);
            case "CTD":
                Carrera carrera = new Carrera("Certified Tech Developer", "carrera de certified tech developer", 16.000);
                carrera.addCursoOTaller(crearOfertaAcademica(OfertaAcademicaFactory.BACKEND));
                carrera.addCursoOTaller(crearOfertaAcademica(OfertaAcademicaFactory.FRONTEND));
                carrera.addCursoOTaller(crearOfertaAcademica(OfertaAcademicaFactory.METODOLOGIAS));
                carrera.addCursoOTaller(crearOfertaAcademica(OfertaAcademicaFactory.DESIGN_THINKING));
                return carrera;

            default:
                throw new OAFactoryException("Codigo " + codigo + " de oferta academica invalido");
        }

    }


}
