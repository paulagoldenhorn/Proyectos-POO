package com.DH.local.abs;

import com.DH.local.excepction.ItemFactoryExcepction;

public abstract class MetodoPagoStrategy {
    private int numeroTarjeta;
    private Double saldo;
    private MetodoPagoStrategy metodo;

    public MetodoPagoStrategy(int numeroTarjeta, Double saldo) {
        this.numeroTarjeta = numeroTarjeta;
        this.saldo = saldo;
    }

    public void elegirMetodo(MetodoPagoStrategy p){
        metodo = p;
    }

    public abstract Boolean pagar(Double monto);

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
