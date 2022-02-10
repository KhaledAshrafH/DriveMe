package Trip;

public class AdminDiscount extends Discount{

    public AdminDiscount(Service s) {
        super(s);
    }

    @Override
    public double calcCost() {
        return super.calcCost();
    }
}
