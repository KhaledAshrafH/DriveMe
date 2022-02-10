public class Offer {
    private double Price;
//    private Request request;
    private Driver DriverObj;

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
