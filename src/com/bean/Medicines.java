/**
 * 
 */
package com.bean;

/**
 * @author Suneha Ghosh
 *
 */
public class Medicines {
	
    //getter method for rate
	
	public int getRate() {
		return rate;
	}
	
	//setter method for rate

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	//getter method for amount

	public int getAmount() {
		return amount;
	}
	
	//setter method for amount

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//getter method for patient_id

	public int getPatient_id() {
		return patient_id;
	}
	
	//setter method for patient_id
	
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	//getter method for medicine_name
	
	public String getMedicine_name() {
		return medicine_name;
	}
	
	//setter method for medicine_name
	
	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}
	
	//getter method for quantity
	
	public int getQuantity() {
		return quantity;
	}
	
	//setter method for quantity
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private int patient_id;
	private String medicine_name;
	private int quantity;
	private int rate;
	private int amount;

}
