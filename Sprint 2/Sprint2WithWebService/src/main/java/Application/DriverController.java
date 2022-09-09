package Application;

import Application.Control.DataBase.*;
import Application.Control.Registration;
import Application.User.Customer.Customer;
import Application.User.Driver.Driver;
import Application.User.User;
import Application.User.userState;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class DriverController {

    User driver = new Driver();

    @PostMapping(value = "/signUp/driver")
    public String signup(@RequestBody Driver driver){
        this.driver = driver;
        Registration.SignUp(this.driver);
        return driver.getUsername() + " is sign up in The System And His State " + driver.getSTATE();
    }

    @GetMapping(value = "/signin/driver/{username}/{password}")
    public String signin(@PathVariable String username,@PathVariable String password){
        Driver obj = DriversList.getDriver(username);
        this.driver = obj;
        if (obj!=null && obj.getSTATE()== userState.ACTIVE){
            Registration.SignIn(obj,username,password);
            System.out.println(obj);
            return driver.getUsername() + " is signin successfully and his State " + driver.getSTATE();
        }else{
            if (obj==null) return "Driver Not Found In The System ";
            return "waiting until Admin Approve you ";
        }
    }

    @GetMapping(value = "/list/driver")
    public ArrayList<Driver> list(){
        return DriversList.getInstance().ListOfDrivers;
    }

    @GetMapping(value = "{userNameDriver}/addArea/{Area}")
    public String addArea(@PathVariable String userNameDriver,@PathVariable String Area)throws IOException {
        Driver d = DriversList.getDriver(userNameDriver);
        this.driver = d;
        if (driver!=null){
            d.addArea(Area);
            return driver.getUsername() + " added " + Area + " successfully ";
        }else return "Driver Not Found In The System ";
    }

    @PostMapping(value = "{userNameDriver}/addOffer/{userNameCustomer}/{price}")
    public String addOffer(@PathVariable String userNameDriver,@PathVariable String userNameCustomer,@PathVariable double price){
        Driver d  = DriversList.getDriver(userNameDriver);
        Customer c  = CustomersList.getCustomer(userNameCustomer);
        this.driver =d;
        if (d!=null && c!=null){
            d.addOffer(c,price);
            return d.getUsername() + " added offer successfully to " + c.getUsername() + " and The Price Offer is " + price;
        }else {
            if (d==null) return "Driver Not Found In The System ";
            if (c==null) return "Customer Not Found In The System ";
        }
        return null;
    }


    @PostMapping(value = "driver/{UserNameDriver}/{setCurrent_location}")
    public String setCurrent_location(@PathVariable String UserNameDriver,@PathVariable String setCurrent_location){
        Driver obj = DriversList.getDriver(UserNameDriver);
        if (obj!=null){
            obj.setCurrent_location(setCurrent_location);
            return " Current location " + obj.getUsername() + " is " + setCurrent_location;
        }
        return "Driver Not Found In The System ";
    }

    @GetMapping(value = "/driver/{UserNameDriver}/checkArriving")
    public String checkArriving(@PathVariable String UserNameDriver){
        Driver obj = DriversList.getDriver(UserNameDriver);
        if (obj!=null) return obj.checkArriving();
        return "Driver Not Found In The System ";
    }

    @GetMapping(value = "/driver/{UserNameDriver}/checkFinishing")
    public String checkFinishing(@PathVariable String UserNameDriver) throws IOException {
        Driver obj = DriversList.getDriver(UserNameDriver);
        if (obj!=null) return obj.checkFinishing();
        return "Driver Not Found In The System ";
    }


}
