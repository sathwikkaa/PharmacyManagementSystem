package com.codegnan.jdbc.crud_operations;

public class Pharmacy {

    
    public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private String medicineName;
    private String category;
    private double price;

    public Pharmacy( String medicineName, String category, double price) {
       
        this.medicineName = medicineName;
        this.category = category;
        this.price = price;
    }

    
    public String getName() { return medicineName; }
    public String getType() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return  medicineName + " " + category + " " + price;
    }
}
