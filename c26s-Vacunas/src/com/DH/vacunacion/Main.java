package com.DH.vacunacion;

import com.DH.vacunacion.abs.VacunaStrategy;
import com.DH.vacunacion.exc.AplicacionVacExc;
import com.DH.vacunacion.model.AstraZeneca;
import com.DH.vacunacion.model.Moderna;
import com.DH.vacunacion.model.Paciente;

public class Main {
    public static void main(String[] args) {

        VacunaStrategy astra = new AstraZeneca("Oxford-AstraZeneca", "Inglaterra", 1);
        VacunaStrategy moderna = new Moderna("Moderna", "EEUU", 2);
        VacunaStrategy soberana = new AstraZeneca("Soberana", "Cuba", 3);

        Paciente p1 = new Paciente("Belen");

        // ELEGIR VACUNA A APLICAR
        p1.definirVacuna(moderna);

        // APLICAR PRIMERA DOSIS
        try {
            p1.aplicarVacuna();
        } catch (AplicacionVacExc e) {
            e.printStackTrace();
        }
        p1.informarVacunacion();

        // APLICAR SEGUNDA DOSIS
        try {
            p1.aplicarVacuna();
        } catch (AplicacionVacExc e) {
            e.printStackTrace();
        }
        p1.informarVacunacion();

        // INTENTAR APLICAR TERCERA DOSIS
        try {
            p1.aplicarVacuna();
        } catch (AplicacionVacExc e) {
            e.printStackTrace();
        }

    }
}
