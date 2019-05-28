package com.space.bookshelf.services.beneficiary.model;

import com.space.bookshelf.model.Person;

public class Beneficiary extends Person
{
	private String SchoolName ="";
	private String SchoolStream ="";
	private String SchoolLatititude ="";	
	private String SchoolLongititude ="";	
	
	
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	public String getSchoolStream() {
		return SchoolStream;
	}
	public void setSchoolStream(String schoolStream) {
		SchoolStream = schoolStream;
	}
	public String getSchoolLatititude() {
		return SchoolLatititude;
	}
	public void setSchoolLatititude(String schoolLatititude) {
		SchoolLatititude = schoolLatititude;
	}
	public String getSchoolLongititude() {
		return SchoolLongititude;
	}
	public void setSchoolLongititude(String schoolLongititude) {
		SchoolLongititude = schoolLongititude;
	}
	
	public String toString()
	{
		String _tmp = super.toString();
		return _tmp + " | " + this.SchoolName + " | " + this.SchoolStream + " | " + this.SchoolLatititude + " | " + this.SchoolLongititude; 
	} 
			

}
