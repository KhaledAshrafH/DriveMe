package Application.Control.DataBase;

import Application.User.Customer.Customer;

import java.util.ArrayList;

public class CustomersList extends IList {
    private static CustomersList instanceOFCustomersList = null;
    public ArrayList<Customer> ListOfCustomer = new ArrayList<>();

    private CustomersList(){

    }

    public static CustomersList getInstance(){
        if(instanceOFCustomersList == null) instanceOFCustomersList = new CustomersList();
        return instanceOFCustomersList;
    }

    public static Customer getCustomer(String username){
        for(Customer c : CustomersList.getInstance().ListOfCustomer){
            if (c.getUsername().equals(username)) return c;
        }
        return null;
    }

}
