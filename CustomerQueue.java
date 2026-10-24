
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerQueue {

    // INPUT
    static Scanner input = new Scanner(System.in);

    // CUSTOMER RECORDS
    static ArrayList<Integer> ticketNumbers = new ArrayList<>();
    static ArrayList<String> customerNames = new ArrayList<>();

    // WAITING QUEUE
    static Queue<Integer> waitingQueue = new LinkedList<>();

    // SYSTEM VARIABLES
    static int nextTicketNumber = 1;
    static int choice = 0;
    static boolean isRunning = true;

    public static void main(String[] args) {

        while (isRunning) {

            displayMenu();

            choice = getMenuChoice();

            if (choice == 1) {
                issueTicket();
            } else if (choice == 2) {
                viewQueue();
            } else if (choice == 3) {
                serveNextCustomer();
            } else if (choice == 4) {
                viewNextCustomer();
            } else if (choice == 5) {
                searchCustomer();
            } else if (choice == 6) {
                System.out.println("Thank you for using the system.");
                isRunning = false;
            } else {
                System.out.println("Invalid choice. Please select 1-6.");
            }
        }

        input.close();
    }

    // METHOD 1: DISPLAY MENU
    public static void displayMenu() {

        System.out.println("\n================================");
        System.out.println("    CUSTOMER SERVICE QUEUE");
        System.out.println("================================");
        System.out.println("1. Get a Ticket");
        System.out.println("2. View Waiting Queue");
        System.out.println("3. Serve Next Customer");
        System.out.println("4. View Next Customer");
        System.out.println("5. Search Customer by Ticket");
        System.out.println("6. Exit");
        System.out.println("================================");
        System.out.print("Enter your choice: ");
    }

    // METHOD 2: GET AND VALIDATE MENU INPUT
    public static int getMenuChoice() {

        int menuChoice = 0;

        try {
            menuChoice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return 0;
        }

        return menuChoice;
    }

    // METHOD 3: ISSUE A TICKET
    public static void issueTicket() {

        System.out.println("\n--- GET A TICKET ---");
        System.out.print("Enter customer name: ");

        String customerName = input.nextLine().trim();

        if (customerName.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        int newTicketNumber = nextTicketNumber;

        ticketNumbers.add(newTicketNumber);
        customerNames.add(customerName);
        waitingQueue.add(newTicketNumber);

        System.out.println("\nTicket issued successfully!");
        System.out.println("Customer Name: " + customerName);
        System.out.printf("Ticket Number: T-%03d%n", newTicketNumber);
        System.out.println("Position in Queue: " + waitingQueue.size());

        nextTicketNumber++;
    }

    // METHOD 4: VIEW WAITING QUEUE
    public static void viewQueue() {

        System.out.println("\n--- WAITING QUEUE ---");

        if (waitingQueue.isEmpty()) {
            System.out.println("No customers are waiting.");
            return;
        }

        int position = 1;

        System.out.println("Position | Ticket | Customer");
        System.out.println("----------------------------");

        for (int ticketNumber : waitingQueue) {

            int customerIndex = ticketNumbers.indexOf(ticketNumber);

            System.out.printf(
                "%-8d | T-%03d | %s%n",
                position,
                ticketNumber,
                customerNames.get(customerIndex)
            );

            position++;
        }

        System.out.println("----------------------------");
        System.out.println("Total Waiting: " + waitingQueue.size());
    }

    // METHOD 5: SERVE NEXT CUSTOMER
    public static void serveNextCustomer() {

        System.out.println("\n--- SERVE NEXT CUSTOMER ---");

        if (waitingQueue.isEmpty()) {
            System.out.println("No customers are waiting to be served.");
            return;
        }

        int servedTicketNumber = waitingQueue.poll();

        int customerIndex = ticketNumbers.indexOf(servedTicketNumber);

        System.out.println("Customer is now being served.");
        System.out.printf("Ticket Number: T-%03d%n", servedTicketNumber);
        System.out.println("Customer Name: " + customerNames.get(customerIndex));
        System.out.println("Remaining Customers: " + waitingQueue.size());
    }

    // METHOD 6: VIEW NEXT CUSTOMER WITHOUT REMOVING
    public static void viewNextCustomer() {

        System.out.println("\n--- NEXT CUSTOMER ---");

        if (waitingQueue.isEmpty()) {
            System.out.println("No customers are waiting.");
            return;
        }

        int nextTicket = waitingQueue.peek();

        int customerIndex = ticketNumbers.indexOf(nextTicket);

        System.out.printf("Ticket Number: T-%03d%n", nextTicket);
        System.out.println("Customer Name: " + customerNames.get(customerIndex));
    }

    // METHOD 7: SEARCH CUSTOMER BY TICKET NUMBER
    public static void searchCustomer() {

        System.out.println("\n--- SEARCH CUSTOMER ---");
        System.out.print("Enter ticket number: ");

        int searchedTicket;

        try {
            searchedTicket = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid ticket number. Enter digits only.");
            return;
        }

        int customerIndex = ticketNumbers.indexOf(searchedTicket);

        if (customerIndex == -1) {
            System.out.println("Ticket number not found.");
            return;
        }

        System.out.printf("Ticket Number: T-%03d%n", searchedTicket);
        System.out.println("Customer Name: " + customerNames.get(customerIndex));

        if (waitingQueue.contains(searchedTicket)) {
            System.out.println("Status: Waiting");
        } else {
            System.out.println("Status: Already served");
        }
    }
}
