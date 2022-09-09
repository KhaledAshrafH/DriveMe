package Application.Trip;

import Application.Control.DataBase.Events;
import Application.User.Customer.Customer;
import Application.User.Driver.Driver;

public class Ride implements Service{
    private String source;
    private  String destination;
    private RideState rideState;
    private double cost;

    public void setRideState(RideState rideState) {
        this.rideState = rideState;
    }

    public RideState getRideState() {
        return rideState;
    }

    public RideState checkState(){
       return rideState;
   }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public double calcCost() {
        return cost;
    }

    public boolean isArriving(Customer c,Driver d){
        if (d.getCurrent_location().equals(c.getRequest().getSource())){
            c.getRequest().getRide().setRideState(RideState.STARTED);
            String str="Captain Arrived to User Location, 00:00, Driver: "+d.getUsername()+" , Customer: " +c.getUsername();
            Events.getInstance().addEvent(c.getRequest(),str);
            return true;
        }
        return false;
    }

    public boolean isFinished(Customer c,Driver d) {
        if (d.getCurrent_location().equals(c.getRequest().getDestination())) {
            c.getRequest().getRide().setRideState(RideState.FINISHED);
            String str = "Captain Arrived to User Destination, 00:00, Driver: " + d.getUsername() + " , Customer: " + c.getUsername();
            Events.getInstance().addEvent(c.getRequest(), str);
            return true;
        }
        return false;

    }
}