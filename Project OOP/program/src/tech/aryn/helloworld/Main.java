package tech.aryn.helloworld;

import java.util.Scanner;

class Address{
    private String street;
    private String city;
    private String state;

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void getAddress(){
        System.out.println("Address of Passenger: ");
        System.out.println("Street: " + street);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
    }
}

class Flight{

    // Init
    private int flightNumber = 123;
    String airline = "Air India";
    int capacity = 220 ;
    int seats_booked = 0;
    int seats_avail;

    // Constructor - Flight
    void flight(int flightNumber, String airline, int capacity, int seats_booked, int seats_avail){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.capacity = capacity;
        this.seats_booked = seats_booked;
        this.seats_avail = seats_avail;
    }

    // Output
    public void getFlightDetails(){
        System.out.println("Flight Details: ");
        System.out.println("Flight Number: " + this.flightNumber);
        System.out.println("Airline: " + this.airline);
        System.out.println("Capacity: " + this.capacity);
        System.out.println("Seats Booked: " + this.seats_booked);
        System.out.println("Seats Available: " + this.seats_avail);
    }
}

class Passenger{

    private int passengerID=0;
    Scanner sc = new Scanner(System.in);
    private int idCounter;

    Passenger(){
        this.idCounter = this.idCounter + 1;
    }

    public int getPassengerCount(){
        return this.idCounter;
    }
}

class Contact {
    String name;
    String email;
    String phone;

    public void getContact(String name, String phone, String email){
        System.out.println("Contact Details of Passenger: ");
        this.name = name;
        this.email = email;
        this.phone = phone;

        System.out.println("Name: " + this.name);
        System.out.println("Phone: " + this.phone);
        System.out.println("Email: " + this.email);
    }

    // Set Attributes
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}


// Ticket Class
abstract class Ticket {

    private String ticketPNR;
    private String ticketClass;
    private String ticketPrice;
    private String destination;
    private int departure;
    private int seatNum;
    private boolean ticketStat;

    public Ticket(String ticketPNR, String ticketClass, String ticketPrice, String destination, int departure, int seatNum, boolean ticketStat) {
        //Constructor
        this.ticketPNR = ticketPNR;
        this.ticketClass = ticketClass;
        this.ticketPrice = ticketPrice;
        this.destination = destination;
        this.departure = departure;
        this.seatNum = seatNum;
        this.ticketStat = ticketStat;
    }

    // Output
    public void TicketDetails(){
        System.out.println("Ticket Details: ");
        System.out.println("PNR: " + this.ticketPNR);
        System.out.println("Class: " + this.ticketClass);
        System.out.println("Price: " + this.ticketPrice);
        System.out.println("Destination: " + this.destination);
        System.out.println("Departure: " + this.departure);
        System.out.println("Seat Number: " + this.seatNum);
        System.out.println("Status: " + this.ticketStat);
    }

    public void currentTicketStatus(){
        System.out.println("Current Ticket Status: " + this.ticketStat);
    }

    public int getPnr(){
        return ticketPNR.hashCode();
    }

    public void setTicketStat(boolean ticketStat) {
        if(ticketStat == true) {
            this.ticketStat = true;
        }
        else {
            this.ticketStat = false;
        }
    }
}


// Inherting Ticket Class in Regular Tickets
class RegularTicket extends Ticket{

    boolean snacks;
    boolean food;
    boolean water;

    RegularTicket(String snacks, String food, String water){

        super("PNR", "Regular", "Delhi", "Mumbai", 0500, 1, true);

        System.out.println("Special Services Included: ");
        if (snacks == "true"){
            System.out.println("Snacks Included");
        }
        if (food == "true"){
            System.out.println("Food Included");
        }
        if (water == "true"){
            System.out.println("Water Included");
        }
    }
};

class TouristTicket extends Ticket{

    String hotelInfo;
    String hotelName;
    String hotelAddress;

    String location1;
    String location2;
    String location3;
    String location4;
    String location5;

    public TouristTicket(String ticketPNR, String ticketClass, String ticketPrice, String destination, int departure, int seatNum, boolean ticketStat) {
        super(ticketPNR, ticketClass, ticketPrice, destination, departure, seatNum, ticketStat);
    }

    public static void TouristTicket(String hotelInfo, String hotelName, String hotelAddress, String location1, String location2, String location3, String location4, String location5){
        System.out.println("Hotel Info: " + hotelInfo);
        System.out.println("Hotel Name: " + hotelName);
        System.out.println("Hotel Address: " + hotelAddress);
        System.out.println("Locations to be visited: ");
        System.out.println("Location 1: " + location1);
        System.out.println("Location 2: " + location2);
        System.out.println("Location 3: " + location3);
        System.out.println("Location 4: " + location4);
        System.out.println("Location 5: " + location5);
    }
};

public class Main {

    public static void main(String[] args) {
        // System.out.println("Test Message");

        // Taking User Inputs
        Scanner ns = new Scanner(System.in);
        System.out.println("Java Ticket Booking System: ");
        System.out.println("Options Available:");
        System.out.println("1. Book a Ticket");
        System.out.println("2. Cancel a Ticket");
        System.out.println("3. View Ticket Details using PNR");
        System.out.println("4. Check Your Booking Status");
        System.out.println("5. Check Availability of Seats");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");

        int choice = ns.nextInt();

        // Switch Case
        switch (choice) {
            case 1:
                System.out.println("Booking a Ticket");
                // int ticket_num = ns.nextInt();
                int n=1;
                while (n>0){
                    // Construct Passenger
                    Passenger new_pass = new Passenger();
                    Contact new_cont = new Contact();

                    // Passenger Details
                    System.out.println("Enter your name: ");
                    String name = ns.next();
                    System.out.println("Enter your phone no: ");
                    String phone = ns.next();
                    System.out.println("Enter your email: ");
                    String email = ns.next();

                    new_cont.setEmail(email);
                    new_cont.setPhone(phone);
                    new_cont.setName(name);

                    // Address Details
                    Address new_add = new Address();

                    System.out.println("Fill in your address details: ");
                    System.out.println("Enter your street: ");
                    String street = ns.next();
                    System.out.println("Enter your city: ");
                    String city = ns.next();
                    System.out.println("Enter your state: ");
                    String state = ns.next();

                    new_add.setStreet(street);
                    new_add.setCity(city);
                    new_add.setState(state);

                    System.out.println("Entered Details: ");
                    new_cont.getContact(name, email, phone);
                    new_add.getAddress();

                    // Ticket Details

                    System.out.println("Ticket Info: ");
                    System.out.println("Enter the PNR num: ");

                    System.out.println("Ticket Confirmed! Enjoy your trip!");
                    System.out.println("Total Passenger Count: " + new_pass.getPassengerCount());

                    n--;
                    if (n > 0) {
                        System.out.println("Enter Details for Other Passenger: ");
                    }
                }
                break;
            case 2 :
                System.out.println("Cancelling a Ticket");
                System.out.println("Enter PNR: ");

        }

    }

}