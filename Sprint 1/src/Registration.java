public class Registration {

    static DriversList ListOfDrivers;
    static CustomersList ListOfCustomers;

    static User SignIn(User object ,String username,String password){
        if (object!=null) return object.Login(username,password);
        return null;
    }

    static void SignUp(User object){
        object.Register(object);
    }
}
