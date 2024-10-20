import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static class Expense {
        private String description;
        private double amount;

        public Expense(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Description: " + description + ", Amount: $" + amount;
        }
    }

    private static ArrayList<Expense> expenses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addExpense();
                    break;
                case "2":
                    viewExpenses();
                    break;
                case "3":
                    removeExpense();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nExpense Tracker Application");
        System.out.println("1. Add an expense");
        System.out.println("2. View expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        expenses.add(new Expense(description, amount));
        System.out.println("Expense added successfully.");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            System.out.println("\nYour Expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i));
            }
        }
    }

    private static void removeExpense() {
        viewExpenses();
        if (!expenses.isEmpty()) {
            System.out.print("Enter the expense number to remove: ");
            int expenseNumber = Integer.parseInt(scanner.nextLine());
            if (expenseNumber > 0 && expenseNumber <= expenses.size()) {
                expenses.remove(expenseNumber - 1);
                System.out.println("Expense removed successfully.");
            } else {
                System.out.println("Invalid expense number.");
            }
        }
    }
}
