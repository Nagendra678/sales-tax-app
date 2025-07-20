package com.makkajai;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> items = new ArrayList<>();
            // here items are add to the list
    public void addItem(Item item) {
        items.add(item);
    }

    public void printReceipt() {
        double totalTax = 0.0, total = 0.0;
        for (Item item : items) {
            System.out.println(item);
            totalTax += item.getRawTax();
            total += item.getTotal();
        }
        System.out.printf("Sales Taxes: %.2f\n", totalTax);
        System.out.printf("Total: %.2f\n", total);
    }
}
