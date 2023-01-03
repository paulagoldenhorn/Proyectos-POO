package com.DH.local.comp;

public interface Item {
    Double calcularPrecio();
    String getCodigo();
    Integer getStock();
    String getNombre();
    Double getDescuento();
    void setStock(Integer stock);



}
