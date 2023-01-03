package com.DH.instituto;

import com.DH.instituto.factory.OfertaAcademicaFactory;
import com.DH.instituto.model.Instituto;

public class Main {
    public static void main(String[] args) {

        Instituto digitalHouse = new Instituto();
        digitalHouse.addOfertaAcademica(OfertaAcademicaFactory.FRONTEND);
        digitalHouse.addOfertaAcademica(OfertaAcademicaFactory.BACKEND);
        digitalHouse.addOfertaAcademica(OfertaAcademicaFactory.FULLSTACK);

        digitalHouse.addOfertaAcademica(OfertaAcademicaFactory.DESIGN_THINKING);
        digitalHouse.addOfertaAcademica(OfertaAcademicaFactory.METODOLOGIAS);
        digitalHouse.addOfertaAcademica(OfertaAcademicaFactory.CERTIFIED_DEVELOPER);

        digitalHouse.generarInforme();

    }
}
