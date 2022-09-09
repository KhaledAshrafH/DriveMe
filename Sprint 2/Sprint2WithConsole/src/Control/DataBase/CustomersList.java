package Control.DataBase;

import User.Customer.Customer;
import User.Driver.Driver;

import java.util.ArrayList;

public class CustomersList extends IList {
    private static CustomersList instanceOFCustomersList = null;
    public static ArrayList<Customer> ListOfCustomer = new ArrayList<>();

    private CustomersList(){ }

    public static CustomersList getInstance(){
        if(instanceOFCustomersList == null) instanceOFCustomersList = new CustomersList();
        return instanceOFCustomersList;
    }

}
