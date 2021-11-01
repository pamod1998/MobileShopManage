/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.pamo.mobile.modal;

/**
 *
 * @author HP
 */
public class Customer {

	private String customer_ID;
	private String customer_Name;
	private String gender;
	private String customer_Address;
	private int customer_Mobile_Number;
	private String customer_Email;

	public Customer() {
	}

	public Customer(String id, String name,String gender, String address, int tp, String email) {
		this.customer_ID = id;
		this.customer_Name = name;
		this.gender = gender;
		this.customer_Address = address;
		this.customer_Mobile_Number = tp;
		this.customer_Email = email;
	}


	public String getCustomerID() {
		return customer_ID;
	}

	public void setCustomerID(String customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getCustomerName() {
		return customer_Name;
	}

	public void setCustomerName(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCustomerAddress() {
		return customer_Address;
	}

	public void setCustomerAddress(String customer_Address) {
		this.customer_Address = customer_Address;
	}

	public int getCustomerMobileNumber() {
		return customer_Mobile_Number;
	}

	public void setCustomerMobileNumber(int customer_Mobile_Number) {
		this.customer_Mobile_Number = customer_Mobile_Number;
	}

	public String getCustomerEmail() {
		return customer_Email;
	}

	public void setCustomerEmail(String customer_Email) {
		this.customer_Email = customer_Email;
	}


}