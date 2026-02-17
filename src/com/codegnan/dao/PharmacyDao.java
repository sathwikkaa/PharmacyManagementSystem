package com.codegnan.dao;

import java.util.List;
import com.codegnan.exceptions.MedicineNotFoundException;
import com.codegnan.jdbc.crud_operations.Pharmacy;

public interface PharmacyDao {

    void save(Pharmacy pharmacy);

    List<Pharmacy> findAll();

    Pharmacy findById(int id) throws MedicineNotFoundException;

    void update(Pharmacy pharmacy) throws MedicineNotFoundException;

    void deleteById(int id) throws MedicineNotFoundException;
}
