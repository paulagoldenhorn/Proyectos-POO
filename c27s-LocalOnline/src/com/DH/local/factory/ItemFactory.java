package com.DH.local.factory;

import com.DH.local.comp.Item;
import com.DH.local.excepction.ItemFactoryExcepction;
import com.DH.local.model.ComboProd;
import com.DH.local.model.Producto;

public class ItemFactory {
    private static ItemFactory instance;

    public static final String TECLADO = "TC";
    public static final String MOUSE = "MS";
    public static final String AURICULAR = "AU";
    public static final String WEBCAM = "WB";
    public static final String MICROFONO = "MC";
    public static final String LUCESLED = "LD";
    public static final String COMBOGAMER = "CGA";
    public static final String COMBOSTREAMER = "CST";

    private ItemFactory(){}

    public static ItemFactory getInstance(){
        if (instance == null )
            instance = new ItemFactory();
        return instance;
    }

    public Item crearItem(String codigo) throws ItemFactoryExcepction {
        switch (codigo) {
            case "TC":
                return new Producto(ItemFactory.TECLADO, "TECLADO", "Teclado mecanico", 15.0, 3500.0, 1);
            case "MS":
                return new Producto(ItemFactory.MOUSE, "MOUSE","Mouse razer", 0.0, 1500.0, 200);
            case "AU":
                return new Producto(ItemFactory.AURICULAR, "AURICULAR","Auriculares bluetooth", 0.0, 950.0, 100);
            case "WB":
                return new Producto(ItemFactory.WEBCAM, "WEBCAM","Camara 1080 HD", 10.0, 2000.0, 200);
            case "MC":
                return new Producto(ItemFactory.MICROFONO, "MICROFONO","Microfono stereo y mono", 15.0, 3500.0, 200);
            case "LD":
                return new Producto(ItemFactory.LUCESLED, "LUCES LED","Tira luces LED RGB",0.0 , 1800.0, 100);
            case "CGA":
                ComboProd comboGamer = new ComboProd(ItemFactory.COMBOGAMER, 10, "COMBO GAMER");
                comboGamer.addItem(ItemFactory.getInstance().crearItem("TC"));
                comboGamer.addItem(ItemFactory.getInstance().crearItem("MS"));
                comboGamer.addItem(ItemFactory.getInstance().crearItem("AU"));
                comboGamer.addItem(ItemFactory.getInstance().crearItem("LD"));
                return comboGamer;
            case "CST":
                ComboProd comboStreamer = new ComboProd(ItemFactory.COMBOSTREAMER, 5, "COMBO STREAMER");
                comboStreamer.addItem(ItemFactory.getInstance().crearItem("TC"));
                comboStreamer.addItem(ItemFactory.getInstance().crearItem("MS"));
                comboStreamer.addItem(ItemFactory.getInstance().crearItem("AU"));
                comboStreamer.addItem(ItemFactory.getInstance().crearItem("WB"));
                comboStreamer.addItem(ItemFactory.getInstance().crearItem("MC"));
                return comboStreamer;
            default:
                throw new ItemFactoryExcepction("Codigo de producto invalido");
        }
    }
}
