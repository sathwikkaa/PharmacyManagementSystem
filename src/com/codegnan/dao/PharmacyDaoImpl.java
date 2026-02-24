package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.exceptions.MedicineNotFoundException;
import com.codegnan.factory.ConnectionFactory;
import com.codegnan.jdbc.crud_operations.Pharmacy;

public class PharmacyDaoImpl implements PharmacyDao {

    
    @Override
    public void save(Pharmacy pharmacy) {

        String sql = "INSERT INTO pharmacy(name,type,price) VALUES(?,?,?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

           
            ps.setString(1, pharmacy.getName());
            ps.setString(2, pharmacy.getType());
            ps.setDouble(3, pharmacy.getPrice());

            ps.executeUpdate();

            System.out.println("Medicine Saved: " + pharmacy);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public List<Pharmacy> findAll() {

        List<Pharmacy> list = new ArrayList<>();
        String sql = "SELECT * FROM pharmacy";

        try (Connection con = ConnectionFactory.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pharmacy pharmacy = new Pharmacy(
                        rs.getInt("medicineId"),
                        rs.getString("medicineName"),
                        rs.getString("category"),
                        rs.getDouble("price")
                );
                list.add(pharmacy);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

   
    @Override
    public Pharmacy findById(int id) throws MedicineNotFoundException {

        String sql = "SELECT * FROM pharmacy WHERE medicineId = ?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Pharmacy(
                        rs.getInt("medicineId"),
                        rs.getString("medicineName"),
                        rs.getString("category"),
                        rs.getDouble("price")
                );
            } else {
                throw new MedicineNotFoundException("Medicine not found with ID: " + id);
            }

        } catch (SQLException e) {
            throw new MedicineNotFoundException("Database Error: " + e.getMessage());
        }
    }

 
    @Override
    public void update(Pharmacy pharmacy) throws MedicineNotFoundException {

        String sql = "UPDATE pharmacy SET medicineName=?, category=?, price=? WHERE medicineId=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, pharmacy.getMedicineName());
            ps.setString(2, pharmacy.getCategory());
            ps.setDouble(3, pharmacy.getPrice());
            ps.setInt(4, pharmacy.getMedicineId());

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new MedicineNotFoundException("Medicine ID not found: " + pharmacy.getMedicineId());
            }

            System.out.println("Medicine Updated: " + pharmacy);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    @Override
    public void deleteById(int id) throws MedicineNotFoundException {

        String sql = "DELETE FROM pharmacy WHERE medicineId=?";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows == 0) {
                throw new MedicineNotFoundException("Medicine ID not found: " + id);
            }

            System.out.println("Medicine Deleted with ID: " + id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

