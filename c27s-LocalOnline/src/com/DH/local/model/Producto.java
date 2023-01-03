package com.DH.local.model;

import com.DH.local.comp.Item;

import java.util.Objects;

public class Producto implements Item {
    private String codigo;

    private String nombre;
    private String descripcion;
    private Double descuento;
    private Double costo;
    private Integer stock;

    public Producto(String codigo, String nombre, String descripcion, Double descuento, Double costo, Integer stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.costo = costo;
        this.stock = stock;
    }

    @Override
    public Double calcularPrecio() {
        if (descuento > 0.0)
            return costo - (costo * (descuento / 100));
        return costo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (this.getClass() != o.getClass())
            return false;
        Item i = (Item) o;

        return Objects.equals(codigo, i.getCodigo());
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Double getDescuento() {
        return descuento;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }


}
