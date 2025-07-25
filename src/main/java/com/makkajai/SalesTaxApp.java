package com.makkajai;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// here use regex to get a match input according to the  string input
//** pettern is used to define the pattern of the string .
//** matcher use the pattern to match the string input or parts of string value is match according to pattern
//**or not
public class SalesTaxApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        System.out.println("Enter items:");
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            Matcher matcher = Pattern.compile("(\\d+) (.+) at ([\\d.]+)").matcher(line);
            if (matcher.matches()) {
                int quantity = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                double price = Double.parseDouble(matcher.group(3));

                Item item = new Item(quantity, name, price);
                receipt.addItem(item);
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("\nReceipt:");
        receipt.printReceipt();
    }
}
