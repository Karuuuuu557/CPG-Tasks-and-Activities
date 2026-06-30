package FINALS_PROJECT;

import java.util.Scanner;

public class POS_UNFINISHED {
    //MAIN ARRAYS
    static Scanner input = new Scanner(System.in);
    static String[] itemName = {"Iced Caramel Latte", "Classic Americano", "Matcha Green Tea Latte", "Chocolate Donut"};
    static String[] description = {"A refreshing blend of espresso, milk, and caramel syrup served over ice",
            "Bold and smooth espresso diluted with hot water for a rich, pure coffee taste.",
            "Creamy steamed milk mixed with premium Japanese matcha powder",
            "Soft and fluffy donut glazed with rich chocolate icing."};
    static int[] itemPrice = {100, 80, 120, 45};
    static int[] quantity = new int[20];
    static int[] choices = new int[20];
    static int count = 0;
    static int subtotal = 0;
    static double discount = 0;
    static double total = 0;
    static double discounted = 0;
    static double finalTotal = 0;

    //LOGIN SYSTEM ARRAYS
    static String[] userIDs = new String[10];
    static String[] passwords = new String[10];
    static int userCount = 0;
    static boolean isLoggedIn = false;


    //LOGIN CONCEPT------------------------------------------------------------
    public static void main(String[] args) {

        // Predefined ADMIN Credentials
        userIDs[userCount] = "ADMIN";
        passwords[userCount] = "ADMIN:PASSWORD";
        userCount++;

        while (true) {
            if (isLoggedIn) {
                MenuDisplay();
            } else {
                System.out.println("\n === Log In Page ===");
                System.out.println("1. Register ");
                System.out.println("2. Log In ");
                System.out.println("3. Exit ");
                System.out.println("======================");

                System.out.print("Choose an action (1-3): ");
                String choice = input.nextLine();

                switch(choice) {
                    case "1":
                        register(input);
                        login(input);
                        break;
                    case "2":
                        login(input);
                        break;
                    case "3":
                        System.out.println("Goodbye.");
                        return;
                    default:
                        System.out.println("Invalid input. Please try again.");
                }
            }
        }
    }

    static void register(Scanner input) {
        if (userCount >= userIDs.length) {
            System.out.println("User limit reached. Cannot register more users.");
            return;
        }

        System.out.println("Enter new UserID: ");
        String userID = input.nextLine().trim();

        if (findUser(userID) != -1) {
            System.out.println("UserID already registered. ");
            register(input);
        }

        System.out.println("Enter your Password: ");
        String password = input.nextLine();

        userIDs[userCount] = userID;
        passwords[userCount] = password;
        userCount++;

        System.out.println("Registration successful! You can now Log In.");
    }

    static void login(Scanner input) {
        System.out.println("Enter UserID: ");
        String userID = input.nextLine();

        System.out.println("Enter Password: ");
        String password = input.nextLine();

        int index = findUser(userID);

        if (index != -1 && passwords[index].equals(password)) {
            System.out.println("Log In successful! Welcome, " + userID + ".");
            isLoggedIn = true;
        } else {
            System.out.println("Invalid UserID or Password. Please try again.");
        }
    }

    static int findUser(String userID) {
        for (int i = 0; i < userCount; i++) {
            if (userIDs[i].equalsIgnoreCase(userID)) {
                return i;
            }
        }
        return -1;
    }

    //MAIN POS CONCEPT --------------------------------------------------------------------
    static void MenuDisplay() {
        System.out.println("----------HomePage----------");
        System.out.println("\n 1. Order \n2. Logout");
        System.out.println("Choose an Action (1-2): ");
        int action = input.nextInt();
        input.nextLine();

        switch(action) {
            case 1:
                System.out.println("Proceeding to Menu...");
                break;

            case 2:
                System.out.println("Logging out..");
                logout();
                return;

            default:
                System.out.println("Enter a valid action! ");
                return;
        }


        System.out.println(">>>>>>>>>>---------- MENU ----------<<<<<<<<<<<");
        for (int i = 0; i < itemPrice.length; i++) {
            System.out.println((i + 1) + ". " + itemName[i] + ": ------------>> \u20B1" + itemPrice[i] + "\n   --" + description[i]);
        }
        System.out.println("----------------------------------------------\n");


        while (true) {
            try {
                System.out.print("Enter number of item you want to order: ");
                int choice = input.nextInt();

                // FIX: Bounds check BEFORE array access, and use >= instead of >
                if (choice < 1 || choice > itemName.length) {
                    System.out.println("Item not in menu!!!");
                    input.nextLine();
                    continue;
                }

                System.out.println(itemName[choice - 1] + ": \u20B1" + itemPrice[choice - 1]);

                System.out.print("Enter quantity: ");
                int quant = input.nextInt();
                input.nextLine();

                subtotal = subtotal + (itemPrice[choice - 1] * quant);

                quantity[count] = quant;
                choices[count] = choice - 1;
                count++;

                System.out.print("Add more order? (y/n): ");
                String addOrder = input.nextLine();

                if (addOrder.equalsIgnoreCase("n")) {
                    break;
                } else if (addOrder.equalsIgnoreCase("y")) {
                    continue;
                }

            } catch (Exception e) {
                System.out.println("Invalid value!!!");
                input.nextLine();
            }
        }

        try {
            System.out.println("\n--- Your Order Summary ---");
            for (int i = 0; i < count; i++) {
                int itemIndex = choices[i];
                int itemQuant = quantity[i];
                String name = itemName[itemIndex];
                int price = itemPrice[itemIndex];
                System.out.println(name + " (x" + itemQuant + ") ..... \u20B1" + (price * itemQuant));
            }
            System.out.println("------------------------------------");
            System.out.println("Total --------------- \u20B1" + subtotal);



            System.out.println("\nApply special discount?");
            System.out.println("  1. PWD");
            System.out.println("  2. Senior Citizen");
            System.out.println("  3. None");
            System.out.print("Enter choice (1-3): ");
            int discountType = input.nextInt();
            input.nextLine();

            if (discountType == 1) {
                System.out.println("---You got 20% PWD discount---");

                discount = 20;
                // FIX: Cast to double before division to avoid integer division (20/100 = 0)
                discounted = subtotal * (discount / 100.0);
                total = subtotal - discounted;
                finalTotal = total;
                System.out.println("discount has been applied\n" + "Total: \u20B1" + total);

                if (subtotal > 500) {
                    System.out.println("applying 30% discount");
                    Thread.sleep(1000);
                    discount = 30;
                    discounted = total * (discount / 100.0);
                    finalTotal = total - discounted;
                    System.out.printf("Total: \u20B1%.2f\n", finalTotal);
                }

            } else if (discountType == 2) {
                System.out.println("---You got 20% Senior discount---");
                discount = 20;
                discounted = subtotal * (discount / 100.0);
                total = subtotal - discounted;
                finalTotal = total;

                System.out.println("discount has been applied\n" + "Total: \u20B1" + total);

                if (subtotal > 500) {
                    System.out.println("applying 30% discount");
                    Thread.sleep(1000);
                    discount = 30;
                    discounted = total * (discount / 100.0);
                    finalTotal = total - discounted;
                    System.out.printf("Total: \u20B1%.2f\n", finalTotal);
                }
            } else if (discountType == 3) {
                finalTotal = subtotal;
                System.out.println("Your total value is: \u20B1" + subtotal);

                if (subtotal > 500) {
                    System.out.println("\n---> applying 30% discount...");
                    Thread.sleep(1000);
                    discount = 30;
                    discounted = subtotal * (discount / 100.0);
                    total = subtotal - discounted;
                    finalTotal = total;
                    System.out.printf("Total: \u20B1%.2f\n", total);
                }
            } else {
                System.out.println("Invalid value");
            }


            receipt(input);
        } catch (Exception e) {
            System.out.println("Invalid Value!!");
        }

    }


    static void receipt(Scanner input){
        System.out.println("\n\n\n--- Receipt ---");
        for (int i = 0; i < count; i++) {
            int itemIndex = choices[i];
            int itemQuant = quantity[i];
            String name = itemName[itemIndex];
            int price = itemPrice[itemIndex];
            System.out.println(name + " (x" + itemQuant + ") ..... \u20B1" + (price * itemQuant));
        }

        // FIX: Print total ONCE after all items, not inside the loop
        if (discount > 0) {
            System.out.println("Total: \u20B1" + finalTotal);
        } else {
            System.out.println("Total: --------------------- \u20B1" + subtotal);
        }

        System.out.println("------------------------------------");

    }


    static void logout() {
        isLoggedIn = false;
    }
}
