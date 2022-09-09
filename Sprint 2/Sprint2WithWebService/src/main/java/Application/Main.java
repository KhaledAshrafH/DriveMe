package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("Sprint2")

public class Main {
    public static void main(String []args){
        SpringApplication.run(Main.class,args);
    }

/*
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        Application.User UserAdmin = new Customer();


        Administrator admin = Administrator.getInstance();
        DriversList ListDrivers = DriversList.getInstance();
        CustomersList ListCustomers = CustomersList.getInstance();

        UserAdmin.setUsername("admin");
        UserAdmin.setPassword("admin");
        Registration.SignUp(UserAdmin);

        while (true){
            System.out.println("1-Administrator\n2-Driver\n3-Customer\n4-Exit");
            char choose = input.next().charAt(0);

            switch (choose){
                case '1':{ //Admin

                    System.out.print("Enter UserName : ");
                    String userAdmin = input.next();
                    System.out.print("Password : ");
                    String Password = input.next();
                    if(Registration.SignIn(UserAdmin,userAdmin,Password)!=null){
                        System.out.println("Login Successfully");

                        while (true){

                            System.out.println("1-Drivers\n2-Customers\n3-LogOut");
                            char choose1 = input.next().charAt(0);

                            if (choose1 == '1') {
                                for (int i=0;i<ListDrivers.ListOfDrivers.size();i++){
                                    System.out.println( (i+1) +"- "+ListDrivers.ListOfDrivers.get(i).getUsername() + " & his State is " +ListDrivers.ListOfDrivers.get(i).getSTATE());
                                }
                                System.out.println("1-Approve\n2-Block\n3-Exit");
                                char choose2 = input.next().charAt(0);
                                System.out.print("Enter Number Of Application.User : ");
                                int number = input.nextInt();
                                number--;
                                if (choose2=='1'){
                                    admin.Approve(ListDrivers.ListOfDrivers.get(number));
                                }else if(choose2=='2'){
                                    admin.Blocked(ListDrivers.ListOfDrivers.get(number));
                                }else if(choose2=='3') break;
                                else System.out.println("invalid Numbers");
                            }
                            else if (choose1 == '2') {
                                for (int i=1;i<ListCustomers.ListOfCustomer.size();i++){
                                    System.out.println( (i) +"- "+ListCustomers.ListOfCustomer.get(i).getUsername() + " & his State is " +ListCustomers.ListOfCustomer.get(i).getSTATE());
                                }

                                System.out.println("1-Approve\n2-Block\n3-Exit");
                                char choose2 = input.next().charAt(0);
                                System.out.print("Enter Number Of Application.User : ");
                                int number = input.nextInt();

                                if (choose2=='1'){
                                    admin.Approve(ListCustomers.ListOfCustomer.get(number));

                                }else if(choose2=='2'){
                                    admin.Blocked(ListCustomers.ListOfCustomer.get(number));

                                }else System.out.println("invalid Numbers");

                            }else if (choose1 == '3') break;
                            else
                                System.out.println("invalid Numbers");
                        }
                        //end Admin
                    }else {
                        System.out.println("invalid Password And Username");
                    }
                    break;
                }
                //Driver
                case '2':{

                    System.out.println("1-Register\n2-Login");
                    char choose1 = input.next().charAt(0);
                    switch (choose1){
                        case '1':{
                            System.out.print("Enter Username : ");
                            String Username = input.next();

                            System.out.print("Enter Password : ");
                            String Password = input.next();

                            System.out.print("Enter E_Mail : ");
                            String E_Mail = input.next();

                            System.out.print("Enter Mobile : ");
                            String Mobile = input.next();

                            System.out.print("Enter National_ID : ");
                            String National_ID = input.next();

                            System.out.print("Enter License : ");
                            String License = input.next();

                            Driver driver = new Driver();
                            driver.setUsername(Username);
                            driver.setPassword(Password);
                            driver.setE_mail(E_Mail);
                            driver.setMobile(Mobile);
                            driver.setNational_id(National_ID);
                            driver.setLicense(License);

                            Registration.SignUp(driver);

                            break;
                        }
                        case '2':{
                            System.out.print("Enter UserName : ");
                            String driverName = input.next();
                            System.out.print("Password : ");
                            String Password = input.next();
                            Driver driver = null;

                            for (Driver d : ListDrivers.ListOfDrivers){
                                if ( ( d.getUsername().equals(driverName) ) && ( d.getPassword().equals(Password)) ){
                                    driver = d;
                                }
                            }

                            if(Registration.SignIn(driver,driverName,Password)!=null){
                                System.out.println("Login Successfully");
                                while (true){


                                    System.out.println("1-List All Notifications\n2-List Favourite Area\n3-List Of All Ratings\n4-AddArea\n5-LogOut");
                                    char choose2 = input.next().charAt(0);
                                    if(choose2=='1'){
                                        if (driver.getNotification().size()==0){
                                            System.out.println("Notification Is Empty");
                                        }else{
                                            for (int i=0;i<driver.getNotification().size();i++){
                                                System.out.println((i+1)+"- " + driver.getNotification().get(i).getUsername() + " & "+ driver.getNotification().get(i).getRequest().getSource());
                                            }

                                            System.out.print("Enter Number Of Customer To Send Offer : ");
                                            int number = input.nextInt();
                                            number--;

                                            System.out.print("Enter Offer : ");
                                            double price = input.nextDouble();
                                            driver.addOffer(driver.getNotification().get(number),price );
                                        }
                                    }
                                    else if(choose2=='2'){
                                        if (driver.getFav_area().size()==0){
                                            System.out.println("Favorite Area Is Empty");
                                        }else{
                                            System.out.println(driver.getFav_area().toString());
                                        }
                                    }
                                    else if(choose2=='3'){
                                        if (driver.getRatings().size()==0){
                                            System.out.println("Ratings Is Empty");
                                        }else{
                                            System.out.println(driver.getRatings().toString());
                                        }
                                    }
                                    else if(choose2=='4'){
                                        System.out.print("Enter Area : ");
                                        String Area = input.next();
                                        driver.addArea(Area);
                                    }
                                    else if(choose2=='5'){
                                        break;
                                    }
                                    else
                                        System.out.println("invalid Numbers");
                                }
                            }//end login

                            else System.out.println("invalid Password And Username");
                            break;
                        }
                        default: System.out.println("invalid Numbers");
                    }
                    break;
                }//3-Customer
                case '3':{


                    System.out.println("1-Register\n2-Login");
                    char choose1 = input.next().charAt(0);
                    switch (choose1){

                        case '1':{
                            System.out.print("Enter Username : ");
                            String Username = input.next();

                            System.out.print("Enter Password : ");
                            String Password = input.next();

                            System.out.print("Enter E_Mail : ");
                            String E_Mail = input.next();

                            System.out.print("Enter Mobile : ");
                            String Mobile = input.next();

                            Customer customer = new Customer();
                            customer.setUsername(Username);
                            customer.setPassword(Password);
                            customer.setE_mail(E_Mail);
                            customer.setMobile(Mobile);
                            Registration.SignUp(customer);
                            break;
                        }
                        case '2':{
                            System.out.print("Enter UserName : ");
                            String customerName = input.next();
                            System.out.print("Password : ");
                            String Password = input.next();
                            Customer customer = null;

                            for (Customer C : ListCustomers.ListOfCustomer){
                                if ( ( C.getUsername().equals(customerName) ) && ( C.getPassword().equals(Password)) ){
                                    customer = C;
                                }
                            }

                            if(Registration.SignIn(customer,customerName,Password)!=null){
                                System.out.println("Login Successfully");
                                while (true){

                                    System.out.println("1-Add Request\n2-Add Rate\n3-Get Average Rate For drivers\n4-List Offers\n5-LogOut");
                                    char choose2 = input.next().charAt(0);
                                    if(choose2=='1'){
                                        Request req = new Request();
                                        System.out.print("Enter Source Area : ");
                                        String source = input.next();
                                        System.out.print("Enter Destination Area Area : ");
                                        String dest = input.next();
                                        System.out.print("Enter number of passengers : ");
                                        int num = input.nextInt();
                                        req.setSource(source);
                                        req.setDestination(dest);
                                        req.setPassenger_num(num);
                                        req.setOfferList(customer.getRequest().getOfferList());// cant make old offers on new ones
                                        customer.setRequest(req);

                                    }
                                    else if(choose2=='2'){
                                        for (Driver d : ListDrivers.ListOfDrivers){
                                            if (d.getSTATE()==userState.ACTIVE) System.out.println(d.getUsername());
                                        }
                                        System.out.print("Enter Name Of Driver : ");
                                        String name = input.next();
                                        Driver newobj = null;

                                        for (int i=0;i<ListDrivers.ListOfDrivers.size();i++){
                                            if(ListDrivers.ListOfDrivers.get(i).getUsername().equals(name))  {newobj = ListDrivers.ListOfDrivers.get(i);break;}
                                        }

                                        System.out.println("Enter Rate From < 1 To 5 >");
                                        int rate = input.nextInt();
                                        if (rate>0 && rate<6 && newobj!=null){
                                            customer.RateDriver(rate,newobj);
                                        }else if (newobj==null){
                                            System.out.println("Not Found");
                                        }else System.out.println("Invalid Number Rate");

                                    }
                                    else if(choose2=='3'){

                                        for (int i=0;i<ListDrivers.ListOfDrivers.size();i++){
                                            if (ListDrivers.ListOfDrivers.get(i).getSTATE()==userState.ACTIVE) System.out.println(ListDrivers.ListOfDrivers.get(i).getUsername()+ " & Average Rating "+ ListDrivers.ListOfDrivers.get(i).getAvg_Rating());
                                        }

                                    }
                                    else if(choose2=='4'){
                                        if (customer.getRequest().getOfferList().size()==0){
                                            System.out.println("Offer List Is Empty");
                                        }else
                                        {
                                            for (int i=0;i<customer.getRequest().getOfferList().size();i++){
                                                System.out.println((i+1) +"- "+ customer.getRequest().getOfferList().get(i).getDriverObj().getUsername() + " & Price is " + customer.getRequest().getOfferList().get(i).getPrice());
                                            }
                                            System.out.println("Choose Offer");
                                            int number = input.nextInt();
                                            number--;
                                            customer.SelectOffer(customer.getRequest().getOfferList().get(number));
                                        }
                                    }
                                    else if(choose2=='5'){
                                        break;
                                    }
                                    else
                                        System.out.println("invalid Numbers");
                                }
                            }//end Register

                            else System.out.println("invalid Password And Username");
                            break;
                        }
                        default: System.out.println("invalid Numbers");
                    }
                    break;
                } case '4':
                    return;
                default:
                    System.out.println("invalid Numbers");
            }
        }
    }
*/

}