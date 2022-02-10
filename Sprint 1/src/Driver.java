import java.util.ArrayList;

public class Driver implements Idriver{
    userState state = userState.PENDING;
    rideState Rstate = rideState.FREE;


    private ArrayList<String>fav_area=new ArrayList<String>();
    private ArrayList<String>ratings=new ArrayList<String>();
    private ArrayList<Customer>notification=new ArrayList<Customer>();
    Offer offer = new Offer();
    private double Avg_Rating = 0.0;
    private double Rating = 0.0;

    private String license;
    private String national_id;
    private String mobile ;
    private String Username ;
    private String E_mail ;
    private String Password ;

    public void setLicense(String license) {
        this.license = license;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    @Override
    public User Login(String username,String password) {
        Driver d = new Driver();

        for (Driver driver : DriversList.getInstance().ListOfDrivers){
            if ( ( driver.getUsername().equals(username) ) && ( driver.getPassword().equals(password) ) && (getSTATE()==userState.ACTIVE)){
                d = driver;
                return d;
            }else d = null;
        }
        return d;
    }

    public void addArea(String Area){
        fav_area.add(Area);
        for (int i=0;i<CustomersList.getInstance().ListOfCustomer.size();i++){
            if(fav_area.contains(CustomersList.getInstance().ListOfCustomer.get(i).getRequest().getSource())){
                if (!notification.contains(CustomersList.getInstance().ListOfCustomer.get(i))) notification.add(CustomersList.getInstance().ListOfCustomer.get(i));
            }
        }
    }

    @Override
    public void Register(User object) {
        Driver obj = (Driver) object;
        for (int i=0;i<DriversList.getInstance().ListOfDrivers.size();i++){
            if(DriversList.getInstance().ListOfDrivers.get(i).getUsername().equals(obj.getUsername())){
                System.out.println("username already exists");
                return;
            }
        }
            DriversList.getInstance().ListOfDrivers.add(obj);
    }

    @Override
    public void Update(User object) {
        Customer obj = (Customer) object;
        if(fav_area.indexOf(obj.getRequest().getSource())!=-1){
            if (!notification.contains(obj)) notification.add(obj);
        }
    }

    public ArrayList<String> getRatings() {
        return ratings;
    }

    public double getAvg_Rating() {
        return Avg_Rating;
    }

    public void setAvg_Rating() {
        Avg_Rating = Rating/ratings.size();
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    @Override
    public String getE_mail() {
        return E_mail;
    }

    @Override
    public String getUsername() {
        return Username;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    @Override
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public void setUsername(String username) {
        Username = username;
    }

    @Override
    public void setSTATE(userState STATE) {
        state = STATE;
    }

    @Override
    public userState getSTATE() {
        return state;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "state=" + state +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public rideState getRstate() {
        return Rstate;
    }

    public void setRstate(rideState rstate) {
        Rstate = rstate;
    }

    void display(){
        for (int i=0;i<DriversList.getInstance().ListOfDrivers.size();i++){
            System.out.println(DriversList.getInstance().ListOfDrivers.get(i));
        }
    }

    public ArrayList<Customer> getNotification() {
        return notification;
    }

    public void addRate(String Name,int rate){
        Rating+=rate;
        String r = Integer.toString(rate);
        String result = Name + " " + r;
        ratings.add(result);
        setAvg_Rating();
    }

    void addOffer(Customer object, double price){
        offer.setPrice(price);
        offer.setDriverObj(this);
        object.getRequest().getOfferList().add(offer);
    }

    public ArrayList<String> getFav_area() {
        return fav_area;
    }


}