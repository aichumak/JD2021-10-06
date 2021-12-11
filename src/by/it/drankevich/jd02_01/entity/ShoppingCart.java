package by.it.drankevich.jd02_01.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


    List<Good> cart=new ArrayList<>();
    public void print(){
        System.out.println("Goods in cart"+ cart);
    }

    public int add(Good good){
        cart.add(good);
        return cart.size();
    };

    public  void extract(Good good){
        cart.remove(good);

    };
}
