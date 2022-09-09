package Application;

import Application.Control.DataBase.*;
import Application.Control.*;
import Application.Trip.*;
import Application.User.Customer.Customer;
import Application.User.Driver.Driver;
import Application.User.User;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class CustomerController {
    User customer = new Customer();

    @PostMapping(value = "/signUp/customer")
    public String signup(@RequestBody Customer customer){
        this.customer = customer;
        Registration.SignUp(this.customer);
        return customer.getUsername() + " is sign up in The System And His State " + customer.getSTATE();

    }

    @GetMapping(value = "/signin/customer/{username}/{password}")
    public String signin(@PathVariable String username, @PathVariable String password){
        Customer obj = CustomersList.getCustomer(username);
        this.customer = obj;
        if (customer!=null){
            Registration.SignIn(obj,username,password);
            System.out.println(obj);
            return customer.getUsername() + " is signin successfully and his State " + customer.getSTATE();
        } return " Customer Not Found In The System ";
    }

    @GetMapping(value = "/list/customer")
    public ArrayList<Customer> list(){
        return CustomersList.getInstance().ListOfCustomer;
    }


    @GetMapping(value = "/customer/{username}/Request")
    public Request setRequest(@PathVariable String username,@RequestBody Request request)throws IOException {
        Customer c = CustomersList.getCustomer(username);
        this.customer = c;
        if (customer!=null) {
            c.setRequest(request);
            return request;
        }return null;
    }

    @PostMapping(value = "/driver/addRate/{rate}/{usernameCustomer}/{usernameDriver}")
    public String addRateDriver(@PathVariable int rate,@PathVariable String usernameCustomer,@PathVariable String usernameDriver){
        Customer c = CustomersList.getCustomer(usernameCustomer);
        Driver d = DriversList.getDriver(usernameDriver);
        this.customer = c;
        if (c!=null && d!=null){
            if (rate>0 && rate<6){
                c.RateDriver(rate,d);
                return c.getUsername() + " added rate = " + rate + " successfully to " + d.getUsername();
            }else return "rate must be in range \" 0<r<6 \" ";
        }else {
            if (c==null) return " Customer Not Found In The System ";
            return " Driver Not Found In The System ";
        }
    }

    @PostMapping(value = "/SelectOffer/{username}/{id}")
    public String SelectOffer(@PathVariable String username,@PathVariable int id){
        Customer c = CustomersList.getCustomer(username);
        this.customer = c;
        if (c!=null) c.SelectOffer(c.getRequest().getOfferList().get(--id));
        else return " Customer Not Found In The System ";
        return c.getUsername() + " Selected offer successfully ";
    }

    @GetMapping(value = "/ListOffers/{username}")
    public ArrayList<Offer> ListOffers(@PathVariable String username){
        Customer customer = CustomersList.getCustomer(username);
        this.customer = customer;
        if (customer!=null) return customer.getRequest().getOfferList();
        return null;
    }

}