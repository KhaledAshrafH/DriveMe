import java.util.ArrayList;

public class Request {
    private String source;
    private String destination;
    private ArrayList<Offer> OfferList = new ArrayList<>();

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public ArrayList<Offer> getOfferList() {
        return OfferList;
    }

    public void setOfferList(ArrayList<Offer> offerList) {
        OfferList = offerList;
    }
}
