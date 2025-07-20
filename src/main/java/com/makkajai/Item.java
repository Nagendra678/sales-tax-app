package com.makkajai;

public class Item {
    private String name;
    private int quantity;
    private double price;
    private boolean imported;
    private boolean exempt;

    public Item(int quantity, String name, double price) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.imported = name.contains("imported");
        this.exempt = isExempt(name);
    }

    private boolean isExempt(String name) {
        return name.contains("book") || name.contains("chocolate") || name.contains("pill");
    }

    public double getTax() {
        double tax = 0.0;
        if (!exempt) tax += price * 0.10;
        if (imported) tax += price * 0.05;
        return roundTax(tax);
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
    }

    public double getTotalPrice() {
        return price + getTax();
    }

    @Override
    public String toString() {
        return quantity + " " + name + ": " + String.format("%.2f", getTotalPrice());
    }

    public double getRawTax() {
        return getTax();
    }

    public double getTotal() {
        return getTotalPrice();
    }
}
