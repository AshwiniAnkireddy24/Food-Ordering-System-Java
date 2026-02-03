import java.util.Scanner;

class Rest {
    static Scanner sc = new Scanner(System.in);

    double veg(int quantity) {
        return quantity * 399;
    }

    double chicken(int quantity) {
        return quantity * 199;
    }

    double mutton(int quantity) {
        return quantity * 599;
    }
}

class Swiggy extends Rest {
    double bill = 0;

    void menu() {
        System.out.println("\n--- Swiggy Menu ---");
        System.out.println("1. Veg Biryani     : ₹399");
        System.out.println("2. Chicken Biryani : ₹199");
        System.out.println("3. Mutton Biryani  : ₹599");
        System.out.println("\nDo you want to order?");
        System.out.println("1. Yes");
        System.out.println("2. Exit");

        int choice = sc.nextInt();
        if (choice == 1) {
            order();
        } else {
            System.out.println("Thank you for visiting Swiggy 😊");
        }
    }

    void order() {
        System.out.println("\nSelect item to order:");
        System.out.println("1. Veg Biryani");
        System.out.println("2. Chicken Biryani");
        System.out.println("3. Mutton Biryani");

        int item = sc.nextInt();

        System.out.print("Enter quantity: ");
        if (item == 1) bill += veg(sc.nextInt());
        else if (item == 2) bill += chicken(sc.nextInt());
        else if (item == 3) bill += mutton(sc.nextInt());
        else {
            System.out.println("Invalid choice. Try again.");
            order();
            return;
        }

        System.out.println("\n1. Order more");
        System.out.println("2. Generate bill");

        int next = sc.nextInt();
        if (next == 1) order();
        else billing(bill);
    }

    void billing(double bill) {
        System.out.println("\n--- Swiggy Bill ---");
        System.out.println("Subtotal        : ₹" + bill);
        System.out.println("Delivery Charge : ₹40");

        if (bill >= 1000) {
            System.out.println("Discount (10%)  : Applied");
            bill -= bill * 0.10;
        }

        System.out.println("Final Amount    : ₹" + (bill + 40));
        System.out.println("Thank you for ordering from Swiggy 🙏");
    }
}

class Zomato extends Rest {
    double bill = 0;

    void menu() {
        System.out.println("\n--- Zomato Menu ---");
        System.out.println("1. Veg Biryani     : ₹399");
        System.out.println("2. Chicken Biryani : ₹199");
        System.out.println("3. Mutton Biryani  : ₹599");
        System.out.println("\nDo you want to order?");
        System.out.println("1. Yes");
        System.out.println("2. Exit");

        int choice = sc.nextInt();
        if (choice == 1) {
            order();
        } else {
            System.out.println("Thank you for visiting Zomato 😊");
        }
    }

    void order() {
        System.out.println("\nSelect item to order:");
        System.out.println("1. Veg Biryani");
        System.out.println("2. Chicken Biryani");
        System.out.println("3. Mutton Biryani");

        int item = sc.nextInt();

        System.out.print("Enter quantity: ");
        if (item == 1) bill += veg(sc.nextInt());
        else if (item == 2) bill += chicken(sc.nextInt());
        else if (item == 3) bill += mutton(sc.nextInt());
        else {
            System.out.println("Invalid choice. Try again.");
            order();
            return;
        }

        System.out.println("\n1. Order more");
        System.out.println("2. Generate bill");

        int next = sc.nextInt();
        if (next == 1) order();
        else billing(bill);
    }

    void billing(double bill) {
        System.out.println("\n--- Zomato Bill ---");
        System.out.println("Subtotal : ₹" + bill);
        System.out.println("GST (17%): ₹" + (bill * 0.17));
        System.out.println("Final Amount: ₹" + (bill + bill * 0.17));
        System.out.println("Thank you for ordering from Zomato 🙏");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Select Platform:");
        System.out.println("1. Swiggy");
        System.out.println("2. Zomato");

        int choice = Rest.sc.nextInt();

        if (choice == 1) new Swiggy().menu();
        else if (choice == 2) new Zomato().menu();
        else {
            System.out.println("Invalid selection. Try again.");
            main(null);
        }
    }
}
