package com.DH.local.model;

import com.DH.local.comp.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComboProd implements Item {
    private String codigo;
    private String nombre;
    private Integer stock;
    private List<Item> items;

    public ComboProd(String codigo, Integer stock, String nombre) {
        this.codigo = codigo;
        this.stock = stock;
        this.nombre = nombre;
        this.items = new ArrayList<>();
    }

    public void addItem(Item i){
        items.add(i);
    }

    @Override
    public Double calcularPrecio() {
        Double acc = 0.0;
        for (Item i : items) {
            acc += i.calcularPrecio();
        }
        return acc;
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
        Double acc = 0.0;
        for (Item i : items){
            acc += i.getDescuento();
        }
        return acc;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
