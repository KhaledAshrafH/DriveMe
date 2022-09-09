package Application.Control.DataBase;

import Application.Trip.Request;

import java.util.*;

public class Events {
    Map <Request, ArrayList<String>> history= new HashMap<>();
    private static Events instanceOFEvents = null;

    public Events()
    {

    }

    public static Events getInstance(){
        if(instanceOFEvents == null) return instanceOFEvents = new Events();
        else return instanceOFEvents;
    }

    public void addEvent(Request r,String str)
    {
        ArrayList<String>arr = history.get(r);
        // if list does not exist create it
        if(arr == null)
        {
            arr = new ArrayList<String>();
            arr.add(str);
            history.put(r, arr);
        }
        else
        {
        // add if arr is not already in list
            if(!arr.contains(str)) arr.add(str);
        }
    }

    public ArrayList<String> showEvents(Request r)
    {
        ArrayList<String> array = history.get(r);
        if (array!=null)
        {
            for (int i=0;i<array.size();i++) System.out.println(array.get(i));
        }
        return array;
    }

   public Request selectEvent()
   {
        System.out.println("select ride from following by Entering Id of the ride");
        int i=1;

        for (Map.Entry<Request,ArrayList<String>> entry : history.entrySet())
        {
            System.out.println(i+"- Ride Id = "+entry.getKey().getRequestId()+"- Source= " + entry.getKey().getSource() +", Destination= " + entry.getKey().getDestination());
            i++;
        }

        Scanner s = new Scanner(System.in);
        int id=s.nextInt();

        for (Map.Entry<Request,ArrayList<String>> entry : history.entrySet())
        {
           if(entry.getKey().getRequestId()==id)
           {
              return entry.getKey();
           }
        }

        System.out.println("wrong Ride Id");
        return null;
    }
}