package com.DH.local.model;

import com.DH.local.comp.Item;
import com.DH.local.excepction.ItemFactoryExcepction;
import com.DH.local.factory.ItemFactory;

import java.util.ArrayList;
import java.util.List;

public class Local {
    private String nombre;
    private String mail;
    private String telefono;
    private CatalogoOfertas catalogoOfertas;
    private List<Carrito> ventas;
    private ProdBD productos;

    public Local(String nombre, String mail, String telefono, CatalogoOfertas catalogoOfertas, ProdBD productos) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
        this.catalogoOfertas = catalogoOfertas;
        this.ventas = new ArrayList<>();
        this.productos = productos;
    }

    public void addOferta(Item i){
        catalogoOfertas.addOferta(i);
    }

    public void addCarrito(Carrito c){
        ventas.add(c);
    }
    public void mostrarCatalogoOfertas(CatalogoOfertas co) { co.mostrarCatalogo(); }
    public Item elegirItem(String codigo) {
        for (Item iBD : ProdBD.getInstance().getItems()) {
            if (iBD.getCodigo().equals(codigo)) {
                if (iBD.getStock() == 0) {
                    System.out.println("Stock de " + iBD.getNombre() + " agotado");
                    break;
                } else {
                    try {
                        return ItemFactory.getInstance().crearItem(codigo);
                    } catch (ItemFactoryExcepction fe) {
                        fe.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    public Double calcularTotalVentas(){
        Double acc = 0.0;
        for (Carrito c :ventas) {
            acc += c.calcularPrecioCarrito();
        }
        return acc;
    }

    public void informarSumaVentas(){
        System.out.println("Sumatoria de las ventas totales: $" + calcularTotalVentas());
    }
}
