package com.DH.local.model;

import com.DH.local.abs.MetodoPagoStrategy;

public class TarjetaDebito extends MetodoPagoStrategy {


    public TarjetaDebito(int numeroTarjeta, Double saldo) {
        super(numeroTarjeta, saldo);
    }

    @Override
    public Boolean pagar(Double monto) {
        if (monto > getSaldo()) {
            System.out.println("Saldo insuficiente");
            return false;
        }
        else {
            Double saldoUpdated = getSaldo() - monto;
            setSaldo(saldoUpdated);
            System.out.println("Pago con tarjeta de debito exitoso");
            return true;
        }
    }
}
