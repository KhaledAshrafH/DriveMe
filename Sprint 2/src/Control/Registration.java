package Control;
import Control.DataBase.CustomersList;
import Control.DataBase.DriversList;
import User.User;

public class Registration {

    static DriversList ListOfDrivers;
    static CustomersList ListOfCustomers;

    public static User SignIn(User object , String username, String password){
        if (object!=null) return object.Login(username,password);
        return null;
    }

    public static void SignUp(User object){
        object.Register(object);
    }
}
