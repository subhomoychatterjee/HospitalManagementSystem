/**
 * 
 */
package com.bean;

/**
 * @author Suneha Ghosh
 *
 */
public class Diagonostics {
	
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
	
	//getter method for diagonosis
	
	public String getDiagonosis() {
		return diagonosis;
	}
	
	//setter method for diagonosis
	
	public void setDiagonosis(String diagonosis) {
		this.diagonosis = diagonosis;
	}
	
	private int patient_id;
	private String diagonosis;
	private int amount;

}
