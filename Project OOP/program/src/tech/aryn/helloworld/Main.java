package tech.aryn.helloworld;

import java.util.*;
import java.util.Scanner;

class Flight{

    // Init
    private int flightNumber = 123;
    private String airline = "Air India";
    private int capacity = 220 ;
    private int seats_booked = 0;
    private int seats_avail;
    private int newPNR;

    // Constructor - Flight
    void flight(int flightNumber, String airline, int capacity, int seats_booked, int seats_avail){
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.capacity = capacity;
        this.seats_booked = seats_booked;
        this.seats_avail = seats_avail;
    }

    private static HashMap<Integer, Integer> pnrMap;
    private static HashMap<Integer, String> nameMap;
    private static HashMap<Integer, String> Location;

    public Flight(){
        nameMap = new HashMap();
        Location = new HashMap();
        pnrMap = new HashMap();
    }

    public HashMap<Integer, Integer> getPnrMap(){
        return pnrMap;
    }

    public HashMap<Integer, String> getLocation(){
        return Location;
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

    public void newPNR(int pnr){
        this.newPNR = pnr;
    }
}

class Passenger{

    // Address

    private static class Address{
        private String street;
        private String city;
        private String state;

        public void setCity(String city){
            this.city = city;
        }

        public void setState(String state){
            this.state = state;
        }

        public void setStreet(String street){
            this.street = street;
        }

        public void getAddress(){
            System.out.println("Street: " + street);
            System.out.println("City: " + city);
            System.out.println("State: " + state);
        }
    }
    // Contact
    private static class Contact{
        private String name;
        private String email;
        private int phone;

        public void getContact(String name, int phone, String email){
            System.out.println("Name: " + this.name);
            System.out.println("Phone: " + this.phone);
            System.out.println("Email: " + this.email);
        }

        public void setName(String name){
            this.name = name;
        }
        public void setPhone(int phone){
            this.phone = phone;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public int getPhone(){
            return this.phone;
        }
        public String getName(){
            return this.name;
        }
    }

    private static int idCounter=0;
    Scanner sc = new Scanner(System.in);

    Passenger(){
        this.idCounter = this.idCounter + 1;
    }

    public int getPassengerCount(){
        return this.idCounter;
    }

    public void ContactObj(int phone, String name, String email){
        Contact contact = new Passenger.Contact();

        System.out.println("Please Enter Contact Details: ");
        System.out.println("Name: ");
        name = sc.nextLine();
        System.out.println("Phone: ");
        phone = sc.nextInt();
        System.out.println("Email: ");
        email = sc.nextLine();

        contact.setName(name);
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.getContact(name, phone, email);
    }
    public void AddressObject(String street, String city, String state){
        Address address = new Passenger.Address();// Creating an obeject of the inner class

        System.out.println("Please enter the street : ");
        street = sc.next();
        System.out.println("Please enter the city : ");
        city = sc.next();
        System.out.println("Please enter the state : ");
        state = sc.next();
        address.setCity(street);//Using setter to set various properties
        address.setState(city);
        address.setStreet(state);
        address.getAddress();

        System.out.println("If you want to Book a Tourist Ticket press 1 else press 2 for regular Ticket : ");
        int k = sc.nextInt();
        if(k == 1){
            int max = 12000;
            int min =300;
            TouristTicket ob1 = new TouristTicket(123+(int)(Math.random()*(max-min+1)+min),getPassengerCount());// Using random ftn to generate varying PNR number
            ob1.TicketDetails();
            System.out.println("Please enter the Hotel Address : ");
            String l = sc.next();
            ob1.setHotelAddress(l);
            System.out.println("Please add 5 Tourist Locations separated by a space : ");

            String str = sc.next();
            ob1.setTouristLocation(str);

        }else if(k == 2){
            int max = 50000;
            int min =14000;
            RegularTicket ob2 = new RegularTicket(123+(int)(Math.random()*(max-min+1)+min), getPassengerCount()); // Using random ftn to generate varying PNR number
            ob2.TicketDetails();
            System.out.println("Please Enter any special Service you need : ");
            String s = sc.next();
            ob2.setService(s);
        }
    }
}



// Ticket Class
abstract class Ticket {

    private int ticketPNR;
    private String ticketClass;
    private String ticketPrice;
    private String destination;
    private int departure;
    private int seatNum;
    private boolean ticketStat;

    public Ticket(int ticketPNR, String ticketClass, String ticketPrice, String destination, int departure, int seatNum, boolean ticketStat) {
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
        return ticketPNR;
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


// Inheriting Ticket Class in Regular Tickets
class RegularTicket extends Ticket{

    private String specialService;

    RegularTicket(int num, int passengerCount){
        super(num, "Regular", "Delhi", "Mumbai", 0500, 1, true);
    }

    public void getService(){
        System.out.println("Special Service: " + this.specialService);
    }

    public void setService(String service){
        this.specialService = service;
    }
};

// Tourist Ticket Class inheriting Ticket Class
class TouristTicket extends Ticket{

    private String hotelAddress;


    public TouristTicket(int num, int psx){
        super(num, "Tourist", "2000", "Mumbai", 0122, 26, true);
    }

    // Setting Hotel Address
    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    // Getting Hotel Address
    public void getHotelAddress() {
        System.out.println("Hotel Address: " + this.hotelAddress);
    }

    // Getting Tourist Ticket Info
    public void getTouristTicketInfo(){
        super.TicketDetails();
    }

    // Getting Tourist Locations
    public void getTouristLocation(int pnr){
        System.out.println("Tourist Locations are: " + Location.get(pnr));
    }

    Flight flight = new Flight();

    Map<Integer, String> Location = flight.getLocation();

    public void setTouristLocation(String location){
        Location.put(super.getPnr(), location);
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
                    // Passenger Details
                    System.out.println("Enter your name: ");
                    String name = ns.next();
                    System.out.println("Enter your phone no: ");
                    int phone = ns.nextInt();
                    System.out.println("Enter your email: ");
                    String email = ns.next();

                    new_pass.ContactObj(phone, name, email);


                    // Address Details

                    System.out.println("Fill in your address details: ");
                    System.out.println("Enter your street: ");
                    String street = ns.next();
                    System.out.println("Enter your city: ");
                    String city = ns.next();
                    System.out.println("Enter your state: ");
                    String state = ns.next();

                    new_pass.AddressObject(street, city, state);

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