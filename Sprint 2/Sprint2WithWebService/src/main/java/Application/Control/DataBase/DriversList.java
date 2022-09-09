package Application.Control.DataBase;

import Application.User.Driver.Driver;

import java.util.ArrayList;

public class DriversList extends IList{
    private static DriversList instanceOFDriversList =null;
    public ArrayList<Driver> ListOfDrivers = new ArrayList<>();

    private DriversList(){

    }

    public static DriversList getInstance(){
        if(instanceOFDriversList == null) return instanceOFDriversList = new DriversList();
        else return instanceOFDriversList;
    }

    public static Driver getDriver(String username){
        for(Driver d : DriversList.getInstance().ListOfDrivers){
            if (d.getUsername().equals(username)) return d;
        }
        return null;
    }
}
