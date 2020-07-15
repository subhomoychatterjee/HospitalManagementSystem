/**
 * 
 */
package com.bean;

import java.util.Date;

/**
 * @author Suneha Ghosh
 *
 */
public class Patient {
	
	/**
	 * @return the room_id
	 */
	public int getRoom_id() {
		return room_id;
	}

	/**
	 * @param room_id the room_id to set
	 */
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	/**
	 * @return the dod
	 */
	public Date getDod() {
		return dod;
	}

	/**
	 * @param dod the dod to set
	 */
	public void setDod(Date dod) {
		this.dod = dod;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	//getter method for ssn

	public int getSsn() {
		return ssn;
	}
	
	//setter method for ssn
	
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	//getter method for patient_id
	
	public int getPatient_id() {
		return patient_id;
	}
	
	//setter method for patient_id
	
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	//getter method for patient_name
	
	public String getPatient_name() {
		return patient_name;
	}
	
	//setter method for patient_name
	
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	
	//getter method for address
	
	public String getAddress() {
		return address;
	}
	
	//setter method for address
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	//getter method for age
	
	public int getAge() {
		return age;
	}
	
	//setter method for age
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//getter method for doj
	
	public Date getDoj() {
		return doj;
	}
	
	//setter method for doj
	
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	//getter method for room_type
	
	public String getRoom_type() {
		return room_type;
	}
	
	//setter method for room_type
	
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	
	private int ssn;
	private int patient_id;
	private String patient_name;
	private String address;
	private int age;
	private Date doj;
	private Date dod;
	private String room_type;
	private int rate;
	private int room_id;

}
