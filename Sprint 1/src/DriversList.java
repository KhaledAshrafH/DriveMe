import java.util.ArrayList;

public class DriversList {
    private static DriversList instanceOFDriversList =null;
    ArrayList<Driver> ListOfDrivers = new ArrayList<>();

    private DriversList(){

    }

    public static DriversList getInstance(){
        if(instanceOFDriversList == null) return instanceOFDriversList = new DriversList();
        else return instanceOFDriversList;
    }

}
