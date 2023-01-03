package com.DH.local.model;

import com.DH.local.comp.Item;

import java.util.ArrayList;
import java.util.List;

public class CatalogoOfertas {
    private List<Item> ofertas;

    public CatalogoOfertas() {
        this.ofertas = new ArrayList<>();
    }

    public void addOferta(Item i) {
        if (i.getDescuento() == 0){
            System.out.println("No puede agregar productos sin descuento al catalogo de ofertas");
            return;
        }
        ofertas.add(i);
    }

    public void mostrarCatalogo(){
        for (Item i : ofertas){
            System.out.println(i.getNombre() + " $" + i.calcularPrecio());
        }
    }
}
