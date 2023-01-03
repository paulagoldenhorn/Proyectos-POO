package com.DH.local.model;

import com.DH.local.comp.Item;
import com.DH.local.excepction.ItemFactoryExcepction;
import com.DH.local.factory.ItemFactory;

import java.util.ArrayList;
import java.util.List;

public class ProdBD {
    private List<Item> items;
    private static ProdBD instance;

    public static ProdBD getInstance(){
        if (instance == null)
            instance = new ProdBD();
        return instance;
    }

    private ProdBD() {
        this.items = new ArrayList<>();
       try {
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.COMBOSTREAMER));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.COMBOGAMER));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.WEBCAM));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.LUCESLED));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.AURICULAR));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.MOUSE));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.TECLADO));
           items.add(ItemFactory.getInstance().crearItem(ItemFactory.MICROFONO));
       } catch (ItemFactoryExcepction i){
           i.printStackTrace();
       }
    }

    public List<Item> getItems() {
        return items;
    }

}
