package Application.Control;
import Application.Control.DataBase.Events;
import Application.User.User;
import Application.User.userState;

import java.util.ArrayList;

public class Administrator {

    private Events events=Events.getInstance();
    private String currentDay="Monday";
    private String currentDate="15/7";
    ArrayList<String>discount_areas=new ArrayList<>();
    private static Administrator instanceOFAdministrator = null;

    public Administrator(){

    }
    public void setCurrentDay(String currentDay) {
        this.currentDay = currentDay;
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentDate() {
        return currentDate;
    }


    public static Administrator getInstance(){
        if(instanceOFAdministrator == null) return instanceOFAdministrator = new Administrator();
        else return instanceOFAdministrator;
    }

    public void Approve(User obj){
        System.out.println(obj.getSTATE());
        obj.setSTATE(userState.ACTIVE);
        System.out.println(obj.getSTATE());
    }

    public void Blocked(User obj){
        obj.setSTATE(userState.BLOCkED);
    }

    public ArrayList<String> viewLog(){
       return events.showEvents(events.selectEvent());
    }

    public void setDiscount_areas(String str) {
        this.discount_areas.add(str);
    }

    public ArrayList<String> getDiscount_areas() {
        return discount_areas;
    }
}