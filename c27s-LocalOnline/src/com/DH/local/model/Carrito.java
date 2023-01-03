package com.DH.local.model;

import com.DH.local.comp.Item;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private int id;
    static int contador = 0;
    private List<Item> items;

    public Carrito() {
        contador++;
        this.id = contador;
        this.items = new ArrayList<>();
    }

    public void addItem(Item i){
        if (i == null){
            return;
        }
        items.add(i);
    }
    public List<Item> getItems() {
        return items;
    }

    public Double calcularPrecioCarrito(){
        Double acc = 0.0;
        for (Item i : items){
            acc += i.calcularPrecio();
        }
        return acc;
    }

    public void informarPrecio(){
        System.out.println("Precio total de su carrito de compras: $" + calcularPrecioCarrito());
    }


}
