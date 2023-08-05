# DriveMe

DriveMe is a Java application that helps users to communicate with car drivers to transport users to any area. It uses SOLID principles, software engineering, and OOP concepts to implement the functionality and design of the application. The application has two versions: one with web service in Spring Boot and another with console.

## Features

The application has the following features:

- **User registration**: The user can register to the system by providing username, mobile number, email (optional), and password. If the user wants to register as a driver, the driving license and national id should also be provided.
- **Driver verification**: The admin user can verify driver registration by listing all pending driver registrations and verifying any of them.
- **Ride request**: The user can request a ride by entering the source area's name and the destination area's name.
- **Ride notification**: The driver can add some areas to get notification when any ride is requested and one of these areas is added as the source area.
- **Ride offer**: The driver can list all rides with source area within one of the driver's favorite areas. The driver can suggest a price to this ride and notify the user with this price. Each price suggestion is called an "offer".
- **Account suspension**: The admin can suspend any driver/user account. By suspending an account, the corresponding user cannot login into the application.
- **Driver rating**: The user can rate any driver by providing a star rating from 1 to 5 (1 worst, 5 best).
- **Rating list**: The driver can list user ratings. All user ratings are visible to the driver.
- **Rating average**: The user can check the average rating for the driver. The driver's information includes the average user rating.
- **Data persistence**: Data from the above features are persisted using a database.

The web service version of the application also has the following additional features:

- **Web service**: The application exposes all features as web services using Spring Boot framework.
- **Design patterns**: The application applies design patterns to all features as needed within sprint 1 and sprint 2 requirements.
- **Event logging**: The admin can show the events that happened on a specific ride. These include captain putting a price, user accepting the price, captain arriving to user location, captain arriving to user destination. Each event has a name, a time, and the involved parties.
- **Area discount**: The admin can add discounts on specific areas. If any ride is going to that area, a 10% discount is applied to the ride price. This discount does not affect the price that the captain suggests. The ride price is added with no discount to the captain balance once completing the ride, but the discount is applied to what the user pays for this ride.
- **Booking refactoring**: The booking ride logic is refactored to add a new way to book a ride. Only the drivers within the ride source area and available to handle a new request are notified. The user can also specify the number of passengers in this ride.
- **Discount chain**: Various discounts are applied to the ride price. So what the user pays passes by some discounts, if they should be applied then the ride price is reduced accordingly.

## Installation

To install and run the console version of the application, you need to have Java Development Kit (JDK) installed on your machine. You can download JDK from [here](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html). 

To install and run the web service version of the application, you need to have Maven installed on your machine. You can download Maven from [here](https://maven.apache.org/download.cgi). 

You also need to have Spring Boot installed on your machine. You can download Spring Boot from [here](https://spring.io/projects/spring-framework/).

To clone the project repo, you can use the following command:
```
git clone https://github.com/KhaledAshrafH/DriveMe.git
```

## Usage

To use the application, you need to register as either a user or a driver. You can then login with your credentials and access the features according to your role.

If you are a user, you can request a ride by entering your source and destination areas. You will then receive offers from drivers who are interested in your ride. You can accept any offer and start your ride. You can also rate your driver after completing your ride. You can also check your driver’s average rating before accepting their offer.

If you are a driver, you can add some areas to get notified when a ride is requested in those areas. You can then make an offer for any ride that matches your preferences. You will then wait for the user to accept your offer and start your ride. You can also check your ratings from users who have rated you.

If you are an admin, you can verify driver registrations by approving or rejecting them. You can also suspend any user or driver account if they violate the rules. You can also add discounts to specific areas to attract more users. You can also view the events that happened on any ride.

To run the console version of the application, you need to navigate to the project directory and execute the following command:
```
java -jar TransportationApp.jar
```

To run the web service version of the application, you need to navigate to the project directory and execute the following command:
```
mvn spring-boot:run
```


The web service will run on port 8080 by default. You can use any REST client tool such as Postman or curl to test the web service endpoints.


## Contributing

The project is open for contributions. If you want to contribute to this project, please follow these steps:

- Fork the project repo
- Create a new branch for your feature
- Commit and push your changes to your branch
- Create a pull request to the main branch
- Wait for review and feedback


## Team

The project is developed by a team of four students from the Faculty of Computers and Artificial Intelligence, Cairo University . The team members are:

- [Khaled Ashraf](https://github.com/KhaledAshrafH).
- [Ahmed Sayed](https://github.com/AhmedSayed117).
- [Ebrahim Mohammed](https://github.com/EbrahimHeggy).
- [Zeyad Maher](https://github.com/ZeyadMaher).


## Contact

If you have any questions, suggestions, or feedback, please feel free to contact me at 5aleda4rf@gmail.com.

## License

The project is licensed under MIT License. See [LICENSE] file for more details.
