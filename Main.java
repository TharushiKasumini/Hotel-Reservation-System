// Author - W.G.T. Kasumini
// Index Number - KUDSE23.1F - 029

import java.util.ArrayList;
import java.util.Scanner;


// Customer class
class Customer{

    // Attributes of a customer
    private String name;
    private int ID;
    private String phoneNumber;
    private String email;

    // Constructor
    public Customer(String name, int ID, String phoneNumber, String email){
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Methods
    public String getName(){
        return name;
    }

    public int getID(){
        return ID;
    }

    public String getPhone(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    // Get customer information
    public void customerDetails(){
        System.out.println("Customer Details:");
        System.err.println("    Name - " + name);
        System.err.println("    Customer ID - " + ID);
        System.err.println("    Phone Number - " + phoneNumber);
        System.err.println("    Email Address - " + email);

    }

}


// Room Class
class Room{

    // Attributes of a room
    private String roomType;
    private int roomNumber;
    private String remarks;
    private double pricePerNight;

    // Constructor
    public Room(String roomType, int roomNumber, String remarks, double pricePerNight){
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.remarks = remarks;
        this.pricePerNight = pricePerNight;
    }

    // Methods
    public String getRoomType(){
        return roomType;
    }

    public int getRoomNumber(){
        return roomNumber;
    }

    public String getRemakrs(){
        return remarks;
    }

    public double getPricePerNight(){
        return pricePerNight;
    }

    // Get room Information
    public void roomDetails(){
        System.out.println("Room Details:");
        System.err.println("    Room Type - " + roomType);
        System.err.println("    Room Number - " + roomNumber);
        System.err.println("    Remarks - " + remarks);
        System.err.println("    Price Per Night - " + pricePerNight);

    }
}


// Reservation class
class Reservation{

    // Attributes of reservation
    private Customer customer;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private int numberOfNights;

    // Constructor
    public Reservation(Customer customer, Room room, String checkInDate, String checkOutDate, int numberOfNights){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfNights = numberOfNights;
    }

    // Methods
    // Return the total cost
    public double getTotalCost(){
        return numberOfNights*(room.getPricePerNight());
    }

    // Get the customer associated
    public Customer getCustomer(){
        return customer;
    }

    // Show the reservation summary
    public void showSummary(){

        System.out.println("---------------------------");
        System.out.println("    Reservation Summary");
        System.out.println("---------------------------");
        System.out.println("Customer Details:");
        System.out.println("    Customer Name - " + customer.getName());
        System.out.println("    Customer ID - " + customer.getID());
        System.out.println("    Customer Phone Number - " + customer.getPhone());
        System.out.println("    Customer Email - " + customer.getEmail());
        System.out.println("Room Details:");
        System.err.println("    Room Type - " + room.getRoomType() + "| Room Number - " + room.getRoomNumber());
        System.err.println("    Price Per Night - " + room.getPricePerNight() + "| Remarks - " + room.getRemakrs());
        System.out.println("Check In Date - " + checkInDate);
        System.out.println("Check Out Date - " + checkOutDate);
        System.out.println("Number of Nights - " + numberOfNights);
        System.out.println("Total Cost - " + getTotalCost());
        System.out.println();

    }
}


public class Main {

    // ArrayLists for stroing customers, rooms, reservations
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    // Initializing scanner
    private static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {

        // Select the option from the menu
        int option = 0;

        // Menu
        while(option != 7){

            System.out.println();
            System.out.println("========================================");
            System.out.println("        Hotel Reservation System");
            System.out.println("========================================");
            System.out.println();
            System.out.println("Select an option (Number)");
            System.out.println();
            System.out.println("1. Register a customer");
            System.out.println("2. Register a room");
            System.out.println("3. Create a reservation");
            System.out.println("4. Display a reservation summary");
            System.out.println("5. Display a Customer summary");
            System.out.println("6. Display a Room summary");
            System.out.println("7. Exit");
            System.out.println();

            // Scan for the option
            try{
                option = Integer.parseInt(scanner.next());
                System.out.println();
            
                // Functionality based on selected option
                switch(option) {
                    case 1:
                        registerCustomer();
                        break;
                        
                    case 2:
                        registerRoom();
                        break;

                    case 3:
                        createReservation();
                        break;
                    
                    case 4:
                        reservationSummary();
                        break;

                    case 5:
                        showCustomer();
                        break;
                    
                    case 6:
                        showRoom();
                        break;

                    case 7:
                        System.out.println("Exiting Program..");
                        break;
                
                    default:
                        System.out.println("Invalid Option!");
                        break;
                }  
            }
            // Catching invalid input (letters etc..)
            catch (Exception e){
                System.out.println("Invalid Input!");
            }
        }

        // Clossing the scanner
        scanner.close();
    }

    // Register a customer
    private static void registerCustomer(){

        // Get customer details
        System.out.print("Enter Customer Name: ");
        String name = scanner.next();
        System.out.print("Enter Customer ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Customer Phone: ");
        String phone = scanner.next();
        System.out.print("Enter Customer Email: ");
        String email = scanner.next();

        // Creating object and add it to the arraylist
        Customer customer = new Customer(name, id, phone, email);
        customers.add(customer);

        System.out.println("Customer registered successfully!");
    }


    // Register a Room
    private static void registerRoom(){

        // Getting room details
        System.out.print("Enter Room Type: ");
        String roomType = scanner.next();
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        // Able to get space separate strings as remarks
        scanner.nextLine();
        System.out.print("Enter Room Remarks: ");
        String remarks = scanner.nextLine();
        System.out.print("Enter Price per Night: ");
        double pricePerNight = scanner.nextDouble();

        // Creating the object and add it to the arraylist
        Room room = new Room(roomType, roomNumber, remarks, pricePerNight);
        rooms.add(room);

        System.out.println("Room registered successfully!");
    }


    // Creating a Reservation
    private static void createReservation(){

        // Get the customer by customer ID
        System.out.print("Enter Customer ID for reservation: ");
        int customerId = scanner.nextInt();
        Customer customer = findCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found. Please register the customer first.");
            return;
        }

        // Get the room by Room Number
        System.out.print("Enter Room Number for reservation: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Room not found. Please register the room first.");
            return;
        }

        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.next();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.next();
        System.out.print("Enter number of nights: ");
        int numberOfNights = scanner.nextInt();

        // Create object and add it to the arraylist
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate, numberOfNights);
        reservations.add(reservation);
        System.out.println("Reservation created successfully!");

    }

    // Find customer by given ID
    private static Customer findCustomer(int customerID){

        // Find the customer by ID
        for(int i=0; i<customers.size(); i++){
            Customer customer = customers.get(i);
            if(customer.getID() == customerID){
                return customer;
            }
        }
        // If customer is nnot found return Null
        return null;
    }


    // Find Room by given room number
    private static Room findRoom(int roomNumber){
        
        // Find the customer by ID
        for(int i=0; i<rooms.size(); i++){
            Room room = rooms.get(i);
            if(room.getRoomNumber() == roomNumber){
                return room;
            }
        }
        // If room is nnot found return Null
        return null;
    }

    // Show summary of the reservation
    private static void reservationSummary(){

        System.out.println("Enter the customer ID of the reservation: ");
        
        int customerID = scanner.nextInt();

        // Track whether reservations are available or not
        boolean hasReservation = false;

        Customer customer = findCustomer(customerID);
        if (customer == null) {
            System.out.println("Customer not found. Please register the customer first.");
            return;
        }

        // Show the reservation summary
        for(int i=0; i<reservations.size(); i++){
            Reservation reservation = reservations.get(i);
            
            // print the reservation summary
            if(reservation.getCustomer().getID() == customerID){
                reservation.showSummary();
                hasReservation = true;
            }
        }

        // if not reservation found,
        if(!hasReservation){
            System.out.println("There are no reservations for this customer.");
        }
    }

    // Show customer details
    private static void showCustomer(){

        System.out.println("Enter the customer ID: ");
        
        int customerID = scanner.nextInt();

        // Get the customer
        Customer customer = findCustomer(customerID);

        if (customer == null) {
            System.out.println("Customer not found. Please register the customer first.");
            return;
        }

        // Show customer details
        customer.customerDetails();
    }

    // Show Room details
    private static void showRoom(){

        System.out.println("Enter the Room Number: ");
        
        int roomNumber = scanner.nextInt();

        // Get the customer
        Room room = findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room not found. Please register the roo, first.");
            return;
        }

        // Show customer details
        room.roomDetails();
    }
}