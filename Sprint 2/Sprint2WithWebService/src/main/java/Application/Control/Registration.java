package Application.Control;
import Application.Control.DataBase.CustomersList;
import Application.Control.DataBase.DriversList;
import Application.Control.DataBase.IList;
import Application.User.User;

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
