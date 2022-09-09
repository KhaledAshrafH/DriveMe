package Application.Trip;

public class birthday extends Discount {
    public birthday(Service s) {
        super(s);
    }

    @Override
    public double calcCost() {
        return super.calcCost()-super.calcCost()*.05;
    }
}
