package com.codegnan.jdbc.crud_operations;

public class Pharmacy {

    private int medicineId;
    private String medicineName;
    private String category;
    private double price;

    public Pharmacy(int medicineId, String medicineName, String category, double price) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.category = category;
        this.price = price;
    }

    public int getMedicineId() { return medicineId; }
    public String getMedicineName() { return medicineName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return medicineId + " " + medicineName + " " + category + " " + price;
    }
}
