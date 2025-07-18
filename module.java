import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String productName;
        int unitPrice, quantity, totalPrice;
        double taxRate, taxAmount;
        double extraTaxRate = 0, extraTaxAmount = 0;
        int choice;

        System.out.print("\nEnter the name of the product: ");
        productName = sc.nextLine();

        System.out.print("Enter the price of the product: ");
        unitPrice = sc.nextInt();

        System.out.print("Enter the quantity of the product: ");
        quantity = sc.nextInt();

        System.out.print("Enter the TVA rate in %: ");
        taxRate = sc.nextDouble();

        totalPrice = unitPrice * quantity;
        taxAmount = (totalPrice * taxRate) / 100;

        // Ask for additional tax
        do {
            System.out.print("\nDo you want to add more taxes?\nEnter 1 for Yes, 0 for No: ");
            choice = sc.nextInt();
        } while (choice != 0 && choice != 1);

        if (choice == 1) {
            System.out.print("Enter the additional tax rate in %: ");
            extraTaxRate = sc.nextDouble();
            extraTaxAmount = (totalPrice * extraTaxRate) / 100;
        }

        // Confirm the sale
        // using do while loop to make sure the user enter 0 or 1
        do {
            System.out.print("Enter 1 to confirm the sale, or 0 to cancel: ");
            choice = sc.nextInt();
        } while (choice != 0 && choice != 1);
         //if choice equal to 0 the sale is canceled
        if (choice == 0) {
            System.out.println("Sale cancelled.");
            //if not the program continue to run
        } else {
            StringBuilder bill = new StringBuilder();

            bill.append("\n**** PHARMACY INVOICE ****\n");
            bill.append("Product: ").append(productName).append("\n");
            bill.append("Unit Price: ").append(unitPrice).append(" FCFA\n");
            bill.append("Quantity: ").append(quantity).append("\n");
            bill.append("Gross Amount: ").append(totalPrice).append(" FCFA\n");
            bill.append("TVA Rate: ").append(taxRate).append(" %\n");
            bill.append("Additional Tax Rate: ").append(extraTaxRate).append(" %\n");
            bill.append("TVA Amount: ").append(taxAmount).append(" FCFA\n");
            bill.append("Additional Tax Amount: ").append(extraTaxAmount).append(" FCFA\n");
            bill.append("Total Amount (TTC): ").append(totalPrice + taxAmount + extraTaxAmount).append(" FCFA\n");

            System.out.println(bill);

            // Write to file
            try {
                PrintWriter writer = new PrintWriter(new FileWriter("facture.txt"));
                writer.print(bill);
                writer.close();
                System.out.println("✅ Bill has been written to facture.txt");
            } catch (IOException e) {
                System.out.println("❌ Error writing to file: " + e.getMessage());
            }
        }

        sc.close();
    }
}
