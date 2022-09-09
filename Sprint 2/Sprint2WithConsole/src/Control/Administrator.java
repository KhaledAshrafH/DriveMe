package Control;
import Control.DataBase.Events;
import User.User;
import User.userState;

import java.util.ArrayList;

public class Administrator {
    private Events events=Events.getInstance();
    private String currentDay="Monday";
    private String currentDate="15/7";
    ArrayList<String>discount_areas=new ArrayList<>();
    private static Administrator instanceOFAdministrator = null;
    private Administrator(){ }

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
        obj.setSTATE(userState.ACTIVE);
    }

    public void Blocked(User obj){
        obj.setSTATE(userState.BLOCkED);
    }

    public void viewLog(){
        events.showEvents(events.selectEvent());
    }

    public void setDiscount_areas(String str) {
        this.discount_areas.add(str);
    }

    public ArrayList<String> getDiscount_areas() {
        return discount_areas;
    }
}