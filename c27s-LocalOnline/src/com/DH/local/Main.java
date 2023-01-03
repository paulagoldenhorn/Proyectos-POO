package com.DH.local;

import com.DH.local.abs.MetodoPagoStrategy;
import com.DH.local.comp.Item;
import com.DH.local.excepction.ItemFactoryExcepction;
import com.DH.local.factory.ItemFactory;
import com.DH.local.model.*;

public class Main {
    public static void main(String[] args) {

        MetodoPagoStrategy credito = new TarjetaCredito(445566, 5000.0);
        MetodoPagoStrategy debito = new TarjetaDebito(456889, 8000.0);
        MetodoPagoStrategy credito2 = new TarjetaDebito(114789, 200.0);

        CatalogoOfertas catalogo = new CatalogoOfertas();

        Local seluGadgets = new Local("SELU GADGETS", "selugalles@gmail.com", "4555-0112", catalogo, ProdBD.getInstance());
        seluGadgets.addOferta(seluGadgets.elegirItem(ItemFactory.COMBOSTREAMER));
        seluGadgets.addOferta(seluGadgets.elegirItem(ItemFactory.COMBOGAMER));
        seluGadgets.addOferta(seluGadgets.elegirItem(ItemFactory.TECLADO));
        seluGadgets.addOferta(seluGadgets.elegirItem(ItemFactory.WEBCAM));
        seluGadgets.addOferta(seluGadgets.elegirItem(ItemFactory.MICROFONO));
        /* prueba agregar prod sin desc */ seluGadgets.addOferta(seluGadgets.elegirItem(ItemFactory.MOUSE));

        /* prueba elegir prod con codigo invalido */ seluGadgets.elegirItem("vidrio templado");

        System.out.println("CATALOGO DE OFERTAS");
        seluGadgets.mostrarCatalogoOfertas(catalogo);


        Carrito carrito1 = new Carrito();
        Carrito carrito2 = new Carrito();
        Carrito carrito3 = new Carrito();

        Cliente cliente1 = new Cliente("Leo", "Messi", "messi@hotmail.com", carrito1);
        Cliente cliente2 = new Cliente("Taylor", "Swift", "taylor@hotmail.com", carrito2);
        Cliente cliente3 = new Cliente("Jimmy", "Fallon", "jimmy@hotmail.com", carrito3);


        System.out.println("\n");
        System.out.println("CLIENTE 1 - CARRITO 1");
        Item teclado = seluGadgets.elegirItem(ItemFactory.TECLADO);
        Item mouse = seluGadgets.elegirItem(ItemFactory.MOUSE);
        cliente1.addAlCarrito(teclado);
        cliente1.addAlCarrito(mouse);

        cliente1.informarPrecioCarrito();
        System.out.println("Saldo tarjeta: " + credito.getSaldo());
        cliente1.pagarCarrito(credito);
        System.out.println("Saldo tarjeta: " + credito.getSaldo());

        for (Item i : carrito1.getItems()){
            for (Item iBD : ProdBD.getInstance().getItems()){
                if (i.equals(iBD)) {
                    System.out.println("Stock " + iBD.getNombre() + " " + iBD.getStock());
                }
            }
        }

        System.out.println("\n");
        System.out.println("CLIENTE 2 - CARRITO 2");
        Item comboG = seluGadgets.elegirItem(ItemFactory.COMBOGAMER);
        cliente2.addAlCarrito(comboG);
        cliente2.informarPrecioCarrito();
        cliente2.pagarCarrito(debito);

        for (Item i : carrito2.getItems()){
            for (Item iBD : ProdBD.getInstance().getItems()){
                if (i.equals(iBD)) {
                    System.out.println("Stock " + iBD.getNombre() + " " + iBD.getStock());
                }
            }
        }

        System.out.println("\n");
        System.out.println("CLIENTE 3 - CARRITO 3");
        Item comboS = seluGadgets.elegirItem(ItemFactory.COMBOSTREAMER);
        Item comboG2 = seluGadgets.elegirItem(ItemFactory.COMBOGAMER);
        Item prodAgotado = seluGadgets.elegirItem(ItemFactory.TECLADO);
        cliente3.addAlCarrito(comboS);
        cliente3.addAlCarrito(comboG2);
        cliente3.addAlCarrito(prodAgotado);

        cliente3.informarPrecioCarrito();
        cliente3.pagarCarrito(credito2);

        for (Item i : carrito3.getItems()){
            for (Item iBD : ProdBD.getInstance().getItems()){
                if (i.equals(iBD)) {
                    System.out.println("-- Stock " + iBD.getNombre() + ": " + iBD.getStock());
                }
            }
        }

        System.out.println("\n");
        // VENTAS DEL LOCAL
        seluGadgets.addCarrito(carrito1);
        seluGadgets.addCarrito(carrito2);

        seluGadgets.calcularTotalVentas();
        seluGadgets.informarSumaVentas();

    }
}
