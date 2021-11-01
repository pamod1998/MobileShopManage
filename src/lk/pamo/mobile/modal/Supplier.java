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
public class Supplier {
	private String supplier_id;
	private String supplier_Name;
	private String supplier_NIC;
	private String supplier_Address;
	private int supplier_Mobile_Number;
	private String supplier_Email;

	public Supplier(){

	}

	public Supplier(String id, String name, String nic, String address, String email,int tp) {
		this.supplier_id = id;
		this.supplier_Name = name;
		this.supplier_NIC = nic;
		this.supplier_Address = address;
		this.supplier_Mobile_Number = tp;
		this.supplier_Email = email;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_Name() {
		return supplier_Name;
	}

	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}

	public String getSupplier_NIC() {
		return supplier_NIC;
	}

	public void setSupplier_NIC(String supplier_NIC) {
		this.supplier_NIC = supplier_NIC;
	}

	public String getSupplier_Address() {
		return supplier_Address;
	}

	public void setSupplier_Address(String supplier_Address) {
		this.supplier_Address = supplier_Address;
	}

	public String getSupplier_Email() {
		return supplier_Email;
	}

	public void setSupplier_Email(String supplier_Email) {
		this.supplier_Email = supplier_Email;
	}

	public int getSupplier_Mobile_Number() {
		return supplier_Mobile_Number;
	}

	public void setSupplier_Mobile_Number(int supplier_Mobile_Number) {
		this.supplier_Mobile_Number = supplier_Mobile_Number;
	}

	@Override
	public String toString() {
		return "Supplier{" + "id=" + supplier_id + ", Name=" + supplier_Name + ", NIC=" + supplier_NIC + ", Address=" + supplier_Address + ", Mobile_Number=" + supplier_Mobile_Number + ", Email=" + supplier_Email +  '}';
	}

}
