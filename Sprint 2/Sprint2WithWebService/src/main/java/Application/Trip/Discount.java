package Application.Trip;

public abstract class Discount implements Service{
    private Service ride;

    public Discount(Service s){
        this.ride=s;
    }

    @Override
    public double calcCost() {
        return ride.calcCost();
    }

}
