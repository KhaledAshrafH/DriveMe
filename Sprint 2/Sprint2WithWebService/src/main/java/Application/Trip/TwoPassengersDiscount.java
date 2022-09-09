package Application.Trip;

public class TwoPassengersDiscount extends Discount {
    public TwoPassengersDiscount(Service s) {
        super(s);
    }

    @Override
    public double calcCost() {
        return super.calcCost()-super.calcCost()*0.05;
    }

}
