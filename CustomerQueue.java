
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerQueue {

    // INPUT
    static Scanner Input = new Scanner(System.in);

    // CUSTOMER RECORDS
    static ArrayList<Integer> TicketNumbers = new ArrayList<>();
    static ArrayList<String> CustomerNames = new ArrayList<>();

    // WAITING QUEUE
    static Queue<Integer> WaitingQueue = new LinkedList<>();

    // SYSTEM VARIABLES
    static int NextTicketNumber = 1;
    static int Choice = 0;
    static boolean IsRunning = true;

    public static void main(String[] args) {

        while (IsRunning) {

            DisplayMenu();

            Choice = GetMenuChoice();

            if (Choice == 1) {
                IssueTicket();

            } else if (Choice == 2) {
                ViewQueue();

            } else if (Choice == 3) {
                ServeNextCustomer();

            } else if (Choice == 4) {
                ViewNextCustomer();

            } else if (Choice == 5) {
                SearchCustomer();

            } else if (Choice == 6) {
                SortCustomersByName();

            } else if (Choice == 7) {
                System.out.println("Thank you for using the system.");
                IsRunning = false;

            } else {
                System.out.println("Invalid choice. Please select 1-7.");
            }
        }

        Input.close();
    }

    // METHOD 1: DISPLAY MENU
    public static void DisplayMenu() {

        System.out.println("\n================================");
        System.out.println("    CUSTOMER SERVICE QUEUE");
        System.out.println("================================");
        System.out.println("1. Get a Ticket");
        System.out.println("2. View Waiting Queue");
        System.out.println("3. Serve Next Customer");
        System.out.println("4. View Next Customer");
        System.out.println("5. Search Customer by Ticket");
        System.out.println("6. Sort Customers by Name");
        System.out.println("7. Exit");
        System.out.println("================================");
        System.out.print("Enter your choice: ");
    }

    // METHOD 2: GET AND VALIDATE MENU INPUT
    public static int GetMenuChoice() {

        int MenuChoice = 0;

        try {
            MenuChoice = Integer.parseInt(Input.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return 0;
        }

        return MenuChoice;
    }

    // METHOD 3: ISSUE A TICKET
    public static void IssueTicket() {

        System.out.println("\n--- GET A TICKET ---");
        System.out.print("Enter customer name: ");

        String CustomerName = Input.nextLine().trim();

        if (CustomerName.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        int NewTicketNumber = NextTicketNumber;

        TicketNumbers.add(NewTicketNumber);
        CustomerNames.add(CustomerName);
        WaitingQueue.add(NewTicketNumber);

        System.out.println("\nTicket issued successfully!");
        System.out.println("Customer Name: " + CustomerName);
        System.out.printf("Ticket Number: T-%03d%n", NewTicketNumber);
        System.out.println("Position in Queue: " + WaitingQueue.size());

        NextTicketNumber++;
    }

    // METHOD 4: VIEW WAITING QUEUE
    public static void ViewQueue() {

        System.out.println("\n--- WAITING QUEUE ---");

        if (WaitingQueue.isEmpty()) {
            System.out.println("No customers are waiting.");
            return;
        }

        int Position = 1;

        System.out.println("Position | Ticket | Customer");
        System.out.println("----------------------------");

        for (int TicketNumber : WaitingQueue) {

            int CustomerIndex = TicketNumbers.indexOf(TicketNumber);

            System.out.printf(
                "%-8d | T-%03d | %s%n",
                Position,
                TicketNumber,
                CustomerNames.get(CustomerIndex)
            );

            Position++;
        }

        System.out.println("----------------------------");
        System.out.println("Total Waiting: " + WaitingQueue.size());
    }

    // METHOD 5: SERVE NEXT CUSTOMER
    public static void ServeNextCustomer() {

        System.out.println("\n--- SERVE NEXT CUSTOMER ---");

        if (WaitingQueue.isEmpty()) {
            System.out.println("No customers are waiting to be served.");
            return;
        }

        int ServedTicketNumber = WaitingQueue.poll();

        int CustomerIndex = TicketNumbers.indexOf(ServedTicketNumber);

        System.out.println("Customer is now being served.");
        System.out.printf("Ticket Number: T-%03d%n", ServedTicketNumber);
        System.out.println("Customer Name: " + CustomerNames.get(CustomerIndex));
        System.out.println("Remaining Customers: " + WaitingQueue.size());
    }

    // METHOD 6: VIEW NEXT CUSTOMER WITHOUT REMOVING
    public static void ViewNextCustomer() {

        System.out.println("\n--- NEXT CUSTOMER ---");

        if (WaitingQueue.isEmpty()) {
            System.out.println("No customers are waiting.");
            return;
        }

        int NextTicket = WaitingQueue.peek();

        int CustomerIndex = TicketNumbers.indexOf(NextTicket);

        System.out.printf("Ticket Number: T-%03d%n", NextTicket);
        System.out.println("Customer Name: " + CustomerNames.get(CustomerIndex));
    }

    // METHOD 7: SEARCH CUSTOMER BY TICKET NUMBER
    public static void SearchCustomer() {

        System.out.println("\n--- SEARCH CUSTOMER ---");
        System.out.print("Enter ticket number: ");

        int SearchedTicket;

        try {
            SearchedTicket = Integer.parseInt(Input.nextLine());

        } catch (NumberFormatException e) {
            System.out.println("Invalid ticket number. Enter digits only.");
            return;
        }

        int CustomerIndex = TicketNumbers.indexOf(SearchedTicket);

        if (CustomerIndex == -1) {
            System.out.println("Ticket number not found.");
            return;
        }

        System.out.printf("Ticket Number: T-%03d%n", SearchedTicket);
        System.out.println("Customer Name: " + CustomerNames.get(CustomerIndex));

        if (WaitingQueue.contains(SearchedTicket)) {
            System.out.println("Status: Waiting");
        } else {
            System.out.println("Status: Already served");
        }
    }

    // METHOD 8: SORT CUSTOMERS ALPHABETICALLY
    public static void SortCustomersByName() {

        System.out.println("\n--- SORT CUSTOMERS BY NAME ---");

        if (WaitingQueue.isEmpty()) {
            System.out.println("No customers are waiting to be sorted.");
            return;
        }

        // COPY WAITING TICKETS INTO A SEPARATE LIST
        ArrayList<Integer> SortedTicketNumbers = new ArrayList<>();

        for (int TicketNumber : WaitingQueue) {
            SortedTicketNumbers.add(TicketNumber);
        }

        // BUBBLE SORT
        for (int i = 0; i < SortedTicketNumbers.size() - 1; i++) {

            for (int j = 0; j < SortedTicketNumbers.size() - 1 - i; j++) {

                int FirstTicket = SortedTicketNumbers.get(j);
                int SecondTicket = SortedTicketNumbers.get(j + 1);

                int FirstCustomerIndex = TicketNumbers.indexOf(FirstTicket);
                int SecondCustomerIndex = TicketNumbers.indexOf(SecondTicket);

                String FirstCustomerName =
                    CustomerNames.get(FirstCustomerIndex);

                String SecondCustomerName =
                    CustomerNames.get(SecondCustomerIndex);

                if (FirstCustomerName.compareToIgnoreCase(
                        SecondCustomerName) > 0) {

                    SortedTicketNumbers.set(j, SecondTicket);
                    SortedTicketNumbers.set(j + 1, FirstTicket);
                }
            }
        }

        // DISPLAY SORTED CUSTOMERS
        System.out.println("Customers sorted alphabetically:");
        System.out.println("Ticket | Customer");
        System.out.println("----------------");

        for (int TicketNumber : SortedTicketNumbers) {

            int CustomerIndex = TicketNumbers.indexOf(TicketNumber);

            System.out.printf(
                "T-%03d  | %s%n",
                TicketNumber,
                CustomerNames.get(CustomerIndex)
            );
        }
    }
}
