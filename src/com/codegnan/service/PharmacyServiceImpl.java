package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.PharmacyDao;
import com.codegnan.dao.PharmacyDaoImpl;
import com.codegnan.exceptions.MedicineNotFoundException;
import com.codegnan.jdbc.crud_operations.Pharmacy;

public class PharmacyServiceImpl implements PharmacyService {

    
    private PharmacyDao dao = new PharmacyDaoImpl();

   
    @Override
    public void addMedicine(Pharmacy pharmacy) {
        dao.save(pharmacy);
    }

    
    @Override
    public List<Pharmacy> getAllMedicines() {
        return dao.findAll();
    }

    
    @Override
    public Pharmacy getMedicineById(int id) throws MedicineNotFoundException {
        return dao.findById(id);
    }

   
    @Override
    public void updateMedicine(Pharmacy pharmacy) throws MedicineNotFoundException {
        dao.update(pharmacy);
    }

    
    @Override
    public void deleteMedicine(int id) throws MedicineNotFoundException {
        dao.deleteById(id);
    }
}

