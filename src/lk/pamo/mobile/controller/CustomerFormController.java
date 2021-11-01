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
import lk.pamo.mobile.modal.Customer;

/**
 *
 * @author HP
 */
public class CustomerFormController {
	public boolean saveCustomer(Customer c) throws ClassNotFoundException, SQLException {

        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, c.getCustomerID());
        stm.setString(2, c.getCustomerName());
		stm.setString(3, c.getGender());
        stm.setString(4, c.getCustomerAddress());
        stm.setInt(5, c.getCustomerMobileNumber());
        stm.setString(6, c.getCustomerEmail());
        return stm.executeUpdate() > 0;

    }

	 public Customer getCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer WHERE customer_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id);
        ResultSet set = stm.executeQuery();

        if(set.next()){
			return new Customer(
				set.getString(1),
				set.getString(2),
				set.getString(3),
				set.getString(4),
				set.getInt(5),
				set.getString(6)
			);

		}
        return null;
    }

	  public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return DBConnection.getInstance().getConnection().prepareStatement("DELETE FROM Customer WHERE customer_ID='" + id + "'").executeUpdate() > 0;

        /* Connection con=DBConnection.getInstance().getConnection();
            String sql="DELETE FROM Customer WHERE id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, txtCustomerId.getText());
         */
    }

	public boolean updateCustomer(Customer c) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET customer_Name=?, gender=?, customer_Address=?, customer_Mobile_Number=?, customer_Email=?  WHERE customer_ID=?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, c.getCustomerName());
        stm.setString(2, c.getGender());
        stm.setString(3, c.getCustomerAddress());
        stm.setInt(4, c.getCustomerMobileNumber());
        stm.setString(5, c.getCustomerEmail());
        stm.setString(6, c.getCustomerID());
        return stm.executeUpdate() > 0;
    }

	public static ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        Statement stm = con.createStatement();
        ResultSet set = stm.executeQuery(sql);

        ArrayList<Customer> list= new ArrayList<>();

        while (set.next()) {
            Customer c = new Customer();
			c.setCustomerID(set.getString(1));
			c.setCustomerName(set.getString(2));
			c.setGender(set.getString(3));
			c.setCustomerAddress(set.getString(4));
			c.setCustomerMobileNumber(set.getInt(5));
			c.setCustomerEmail(set.getString(6));
			list.add(c);

        }
        return list;
    }
}
