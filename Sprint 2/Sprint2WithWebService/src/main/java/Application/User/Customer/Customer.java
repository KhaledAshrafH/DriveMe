package Application.User.Customer;

import Application.Control.Administrator;
import Application.Control.DataBase.*;
import Application.Trip.*;
import Application.User.*;
import Application.User.Driver.*;
import Application.User.Driver.Driver;

import java.io.IOException;
import java.util.ArrayList;

public class Customer implements Icustomer {

    private Request request = new Request();
    private int customer_rate;
    private String mobile ;
    private String Username ;
    private String E_mail ;
    private String Password ;
    private userState STATE;
    private int trip_count=0;
    private String birth_date;


    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public Customer(){
        STATE = userState.ACTIVE;
    }

    public void setDate(String date) {
        this.birth_date = date;
    }

    public String getDate() {
        return birth_date;
    }

    public void setTrip_count(int trip_count) {
        this.trip_count = trip_count;
    }

    public int getTrip_count() {
        return trip_count;
    }

    @Override
    public void subscribe(Idriver object) {
        Driver obj = (Driver) object;
        Drivers.add(obj);
    }

    @Override
    public void unsubscribe(Idriver object) {
        Driver obj = (Driver) object;
        Drivers.remove(obj);
    }

    @Override
    public void Notify() throws IOException {
        for(Driver obj: DriversList.getInstance().ListOfDrivers) {
            obj.Update(this);
        }
    }

    @Override
    public User Login(String username, String password) {
        Customer c = new Customer();
        for (Customer customer : CustomersList.getInstance().ListOfCustomer){
            if ( ( customer.getUsername().equals(username) ) && ( customer.getPassword().equals(password) )  && (customer.getSTATE()== userState.ACTIVE)){
                c = customer;
                return c;
            }else c = null;
        }
        return c;
    }

    @Override
    public void Register(User object) {
        Customer obj = (Customer) object;
        for (int i=0;i<CustomersList.getInstance().ListOfCustomer.size();i++){
            if(CustomersList.getInstance().ListOfCustomer.get(i).getUsername().equals(obj.getUsername())){
                System.out.println("username already exists");
                return;
            }
        }
            CustomersList.getInstance().ListOfCustomer.add(obj);
    }


    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRequest(Request request)throws IOException {
        this.request = request;
        Notify();
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setSTATE(userState STATE) {
        this.STATE = STATE;
    }

    public void setCustomer_rate(int customer_rate) {
        this.customer_rate = customer_rate;
    }

    public String getE_mail() {
        return E_mail;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public userState getSTATE() {
        return STATE;
    }

    public int getCustomer_rate() {
        return customer_rate;
    }

    public Request getRequest() {
        return request;
    }

    public ArrayList<Driver> getDrivers() {
        return DriversList.getInstance().ListOfDrivers;
    }

    @Override
    public String toString() {
        return Username;
    }

    public void ListOffers(){
        System.out.println(getRequest().getOfferList().toString());
    }

    public void SelectOffer(Offer object){
        object.getDriverObj().setDriverState(DriverState.BUSY);

        for (int i=0;i<DriversList.getInstance().ListOfDrivers.size();i++){
            DriversList.getInstance().ListOfDrivers.get(i).getNotification().remove(this);
        }
        Ride r=new Ride();

        object.getDriverObj().setCustomerUsername(this.Username);
        r.setSource(request.getSource());
        r.setDestination(request.getDestination());
        r.setRideState(RideState.DRIVER_ON_WAY);
        r.setCost(object.getPrice());
        r.setCost(checkDiscount(r));

        request.setRide(r);
        String str="Offer Accepted, 00:00, C "+this.getUsername();
        Events.getInstance().addEvent(request,str);

        this.request.getOfferList().removeAll(this.request.getOfferList());
        this.trip_count++;
    }


    public void RateDriver(int rate,Driver object){
        setCustomer_rate(rate);
        object.addRate(this.getUsername(),this.getCustomer_rate());
    }

    public double checkDiscount(Ride ride) {
        Service s = ride;
        if (getTrip_count() == 0) {
            s = new first_ride(s);
        }
        if (request.getPassenger_num() >= 2) {
            s = new TwoPassengersDiscount(s);
        }
        if (Administrator.getInstance().getCurrentDay().equals("Friday") ){
            s = new public_holiday(s);
        }
        if (Administrator.getInstance().getDiscount_areas().contains(ride.getDestination())){
            s=new AdminDiscount(s);
        }
        if(Administrator.getInstance().getCurrentDate().equals(this.birth_date)){
            s=new birthday(s);
        }
        return s.calcCost();
    }

}