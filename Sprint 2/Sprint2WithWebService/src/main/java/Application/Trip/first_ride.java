package Application.Trip;

public class first_ride extends Discount{

    public first_ride(Service s) {
        super(s);
    }

    @Override
    public double calcCost() {
        return super.calcCost()-super.calcCost()*0.1;
    }
}