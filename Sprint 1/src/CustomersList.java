import java.util.ArrayList;

public class CustomersList {
    private static CustomersList instanceOFCustomersList = null;
    ArrayList<Customer> ListOfCustomer = new ArrayList<>();

    private CustomersList(){

    }

    public static CustomersList getInstance(){
        if(instanceOFCustomersList == null) instanceOFCustomersList = new CustomersList();
        return instanceOFCustomersList;
    }

    //    public String getListOfCustomer() {
//        return ListOfCustomer.get(0).getUsername() + ListOfCustomer.get(1).getUsername();
//    }
}
