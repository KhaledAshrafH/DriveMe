package Trip;

import Control.DataBase.Events;
import User.Customer.Customer;
import User.Driver.Driver;

public class Ride implements Service{
   private String source;
    private  String destination;
    private Customer customer;
    private RideState rideState;
    private Driver driver;
    private double cost;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setRideState(RideState rideState) {
        this.rideState = rideState;
    }

    public Driver getDriver() {
        return driver;
    }

    public RideState getRideState() {
        return rideState;
    }

    public Customer getCustomer() {
        return customer;
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

    public void checkArriving(){
        if (getDriver().getCurrent_location().equals(getSource())){
            setRideState(RideState.STARTED);
            String str="Captain Arrived to User Location, 00:00, Driver: "+getDriver().getUsername()+" , Customer: " +getCustomer().getUsername();
            Events.getInstance().addEvent(getCustomer().getRequest(),str);
        }

    }

    public void isFinished() {
        if (getDriver().getCurrent_location().equals(getDestination())) {
            setRideState(RideState.FINISHED);
            String str = "Captain Arrived to User Destination, 00:00, Driver: " + getDriver().getUsername() + " , Customer: " + getCustomer().getUsername();
            Events.getInstance().addEvent(getCustomer().getRequest(), str);


        }

    }


}
