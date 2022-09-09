package Application.Trip;

import Application.User.Driver.Driver;

public class Offer {
    private double Price;
    private Driver DriverObj = new Driver();;

    public void setPrice(double price) {
        Price = price;
    }

    public double getPrice() {
        return Price;
    }

    public Driver getDriverObj() {
        return DriverObj;
    }

    public void setDriverObj(Driver driverObj) {
        DriverObj = driverObj;
    }

}
