package com.codegnan.controller;

import com.codegnan.jdbc.crud_operations.Pharmacy;
import com.codegnan.service.PharmacyService;
import com.codegnan.service.PharmacyServiceImpl;

public class PharmacyController {

    public static void main(String[] args) {

        PharmacyService service = new PharmacyServiceImpl();

        service.addMedicine(new Pharmacy( "tousuq", "Tablet", 50));
        service.addMedicine(new Pharmacy( "benadryl", "syrup", 35));

        System.out.println("Medicines saved successfully!");
    }
}
