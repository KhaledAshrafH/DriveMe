package Application;

import Application.Control.Administrator;
import Application.Control.DataBase.DriversList;
import Application.User.Driver.Driver;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AdminController {

    Administrator admin  = new Administrator();

    @GetMapping(value = "approve/driver/{username}")
    public String approve(@PathVariable String username){
        Driver obj = DriversList.getDriver(username);
        if (obj!=null) {
            admin.Approve(obj);
            return "admin approved " + obj.getUsername() + " and His State Became " + obj.getSTATE();
        }
        return "Driver Not Found In The System ";
    }

    @PostMapping(value = "admin/{Area}")
    public ArrayList<String> setDiscount_areas(@PathVariable String Area){
        admin.setDiscount_areas(Area);
        System.out.println("admin choose " + Area + " to set discount for this Trip");
        return admin.getDiscount_areas();
    }

    @GetMapping(value = "/admin/viewLog")
    public ArrayList<String> ListOfLog(){
        return admin.viewLog();
    }

    @PostMapping(value = "/admin/setCurrentDay/{Day}")
    public String setCurrentDay(@PathVariable String Day){
        admin.setCurrentDay(Day);
        return "Current Day Of admin is " + Day;
    }

    @PostMapping(value = "/admin/setCurrentDate/{Date}")
    public String setCurrentDate(@PathVariable String Date){
        admin.setCurrentDate(Date);
        return "Current Date Of admin is " + Date;
    }

}