package Control.DataBase;
import java.util.ArrayList;
import User.Driver.Driver;

public class DriversList extends IList {
    private static DriversList instanceOFDriversList =null;
    public static ArrayList<Driver> ListOfDrivers = new ArrayList<>();

    private DriversList(){ }

    public static DriversList getInstance(){
        if(instanceOFDriversList == null) return instanceOFDriversList = new DriversList();
        else return instanceOFDriversList;
    }

}
