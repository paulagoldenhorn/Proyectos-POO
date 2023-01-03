package com.DH.vacunacion.model;

import com.DH.vacunacion.abs.VacunaStrategy;
import com.DH.vacunacion.exc.AplicacionVacExc;

import javax.swing.plaf.PanelUI;

public class Paciente {
    private String nombre;
    private VacunaStrategy vacunaElegida;
    private Integer cantVacAplicadas;
    private Integer dosisRestante;

    public Paciente(String nombre) {
        this.nombre = nombre;
        this.cantVacAplicadas = 0;
    }

    public void calcularDosisRestante(){
        dosisRestante = vacunaElegida.getCantDosisAplicar() - cantVacAplicadas;
    }
    public void definirVacuna(VacunaStrategy v){
        vacunaElegida = v;
        v.informarVacuna();
    }

    public void aplicarVacuna() throws AplicacionVacExc {
        if (cantVacAplicadas.equals(vacunaElegida.getCantDosisAplicar()))
            throw new AplicacionVacExc("No puede aplicar mas vacunas, dosis de vacunacion completa");
        cantVacAplicadas++;
        calcularDosisRestante();
        System.out.println("|| Aplicando " + vacunaElegida.getNombre() + " ||");
    }

    public void informarVacunacion(){
        System.out.println("Cantidad de dosis aplicadas: " + cantVacAplicadas);
        System.out.println("Cantidad de dosis restantes: " + dosisRestante);
        if (dosisRestante.equals(0))
            System.out.println("Vacunacion Completa!");
    }
}
