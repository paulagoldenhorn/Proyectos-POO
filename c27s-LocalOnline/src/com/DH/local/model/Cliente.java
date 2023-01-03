package com.DH.local.model;

import com.DH.local.abs.MetodoPagoStrategy;
import com.DH.local.comp.Item;

public class Cliente {
    private String nombre;
    private String apellido;
    private String mail;
    private Carrito carrito;

    public Cliente(String nombre, String apellido, String mail, Carrito carrito) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.carrito = carrito;
    }

    public void addAlCarrito(Item i){
        carrito.addItem(i);
    }

    public void informarPrecioCarrito(){
        carrito.informarPrecio();
    }


    public Boolean pagarCarrito(MetodoPagoStrategy metodoPago) {
        Double monto = carrito.calcularPrecioCarrito();
        if (metodoPago.pagar(monto)) {
            for (Item i : carrito.getItems()) {
                for (Item iBD : ProdBD.getInstance().getItems()) {
                    if (i.equals(iBD)) {
                        Integer stockBDUpdated = iBD.getStock() - 1;
                        iBD.setStock(stockBDUpdated);
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
