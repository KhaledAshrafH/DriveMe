import java.util.ArrayList;

public interface Icustomer extends User {
    ArrayList<Idriver> Drivers =new ArrayList<>();
     void subscribe(Idriver obj);
     void unsubscribe(Idriver obj);
     void Notify();
}
