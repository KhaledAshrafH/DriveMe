package Control;
import Control.DataBase.CustomersList;
import Control.DataBase.DriversList;
import Control.DataBase.IList;
import User.User;

public class Registration {

    static IList ListOfDrivers=DriversList.getInstance();
    static IList ListOfCustomers=CustomersList.getInstance();

    public static User SignIn(User object , String username, String password){
        if (object!=null) return object.Login(username,password);
        return null;
    }

    public static void SignUp(User object){
        object.Register(object);
    }
}
