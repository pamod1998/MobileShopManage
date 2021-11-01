/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pamo.mobile.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lk.pamo.mobile.db.DBConnection;
import lk.pamo.mobile.modal.Supplier;

/**
 *
 * @author HP
 */
public class SupplierFormController {
	public boolean saveSupplier(Supplier s) throws ClassNotFoundException, SQLException{
		Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Supplier VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
		stm.setString(1, s.getSupplier_id());
        stm.setString(2, s.getSupplier_Name());
		stm.setString(3, s.getSupplier_NIC());
        stm.setString(4, s.getSupplier_Address());
        stm.setString(5, s.getSupplier_Email());
		stm.setInt(6, s.getSupplier_Mobile_Number());
        return stm.executeUpdate() > 0;
	}
	 public Supplier getSupplier(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Supplier WHERE supplier_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if (set.next()) {
            return new Supplier(
                    set.getString(1),
                    set.getString(2),
                    set.getString(3),
                    set.getString(4),
                    set.getString(5),
                    set.getInt(6)
            );
        }
        return null;
    }

	 public boolean deleteSupplier(String id) throws ClassNotFoundException, SQLException {
        return DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM Supplier WHERE supplier_ID='" + id + "'").executeUpdate() > 0;

        /* Connection con=DBConnection.getInstance().getConnection();
            String sql="DELETE FROM Customer WHERE id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, txtCustomerId.getText());
         */
    }

    public boolean updateSupplier(Supplier s) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Supplier SET supplier_Name=?, supplier_NIC=?, supplier_Address=?, supplier_Email=?, supplier_Mobile_Number=? WHERE supplier_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, s.getSupplier_Name());
        stm.setString(2, s.getSupplier_NIC());
        stm.setString(3, s.getSupplier_Address());
        stm.setString(4, s.getSupplier_Email());
        stm.setInt(5, s.getSupplier_Mobile_Number());
        stm.setString(6, s.getSupplier_id());
        return stm.executeUpdate() > 0;
    }

    public static ArrayList<Supplier> getAllSuppliers() throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Supplier";
        Statement stm = con.createStatement();
        ResultSet set = stm.executeQuery(sql);

        ArrayList<Supplier> list= new ArrayList<>();

        while (set.next()) {
            Supplier s = new Supplier();
			s.setSupplier_id(set.getString(1));
			s.setSupplier_Name(set.getString(2));
			s.setSupplier_NIC(set.getString(3));
			s.setSupplier_Address(set.getString(4));
			s.setSupplier_Email(set.getString(5));
			s.setSupplier_Mobile_Number(set.getInt(6));
			list.add(s);

        }
        return list;
    }



}
