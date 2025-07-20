package com.makkajai;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesTaxApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Receipt receipt = new Receipt();

        System.out.println("Enter items (e.g. '1 book at 12.49'), blank line to finish:");
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
