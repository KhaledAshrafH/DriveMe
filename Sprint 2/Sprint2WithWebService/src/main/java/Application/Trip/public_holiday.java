package Application.Trip;

public class public_holiday extends Discount{
    public public_holiday(Service s) {
        super(s);
    }

    @Override
    public double calcCost() {
        return super.calcCost()-super.calcCost()*.05;
    }
}
