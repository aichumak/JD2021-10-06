package by.it.vrublevskii.jd02_03.entity;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class CustomerTypeList {
    private final ArrayList<String> customerTypes = new ArrayList<>();

    public CustomerTypeList() {
        fillCustomerTypes();
    }

    public String getCustomer(int index){
        return customerTypes.get(index);
    }

    private void fillCustomerTypes(){
        customerTypes.add("average");
        customerTypes.add("Student");
        customerTypes.add("Pensioner");
    }

}
