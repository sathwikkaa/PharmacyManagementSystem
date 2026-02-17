package com.codegnan.service;

import java.util.List;
import com.codegnan.exceptions.MedicineNotFoundException;
import com.codegnan.jdbc.crud_operations.Pharmacy;

public interface PharmacyService {

    void addMedicine(Pharmacy pharmacy);

    List<Pharmacy> getAllMedicines();

    Pharmacy getMedicineById(int id) throws MedicineNotFoundException;

    void updateMedicine(Pharmacy pharmacy) throws MedicineNotFoundException;

    void deleteMedicine(int id) throws MedicineNotFoundException;
}

