package by.it.drankevich.jd02_03.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


   public List<Good> cart=new ArrayList<>();


    public int add(Good good){
        cart.add(good);
        return cart.size();
    }

    public  void extract(Good good){
        cart.remove(good);

    }
    public String print(){
        StringBuilder stringBuilder=new StringBuilder();
        for (Good good : cart) {
            stringBuilder.append(good.toString()).append("\n");

        }
        return stringBuilder.toString();
    }

}
