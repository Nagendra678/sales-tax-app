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
    //** in this block of code every Local,Luxery,local+Imported,Luxery+Imported all the items are checked here 
    public double getTax() {
        double tax = 0.0;
        if (!exempt) tax += price * 0.10; //luxery items here 10 percentage tax on that 
        if (imported) tax += price * 0.05; // luxery items with import here is 10 percentage luxery tax and 5 percentage imported duty
        return roundTax(tax);

        //* here not tax in daily items means local items which is considered in this code as exempt but 
        //* the local item is imported there is a tax for that is only 5 percentage  
    }

    private double roundTax(double tax) {
        return Math.ceil(tax * 20.0) / 20.0;
        
       // ** Rounds the given tax amount up to the nearest 0.05 using ceiling logic
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
