package com.space.bookshelf.services.donor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.space.bookshelf.services.donor.dao.DonorDAO;
import com.space.bookshelf.services.donor.model.Donor;

@RestController
public class DonorController 
{
	@Autowired
	private DonorDAO dao;
	
	@RequestMapping("/welcome")
	public String getWelcome()
	{
		return "welcome donors!";
	}
	
	@RequestMapping("/testadd")
	public String testAdd()
	{
		Donor donor = new Donor();
		
		donor.setId("1");
        donor.setFirstName("Samit");
        donor.setLastName("Das");
        donor.setEmailId("samit.das@gmail.com");
        donor.setAddress("ADDRESS 1 2 3");
        donor.setLocality("Viman Nagar");
        donor.setPhoneNumber("9503142904");
        
        donor.setCountry("India");
        donor.setCity("Pune");
        donor.setLatitude("LATITUDE");
        donor.setLongitude("LONGITUDE");
        
		dao.addDonor(donor);
		return "welcome donors!!";
	}
	
	
	
	@RequestMapping("/testshow")
	public String testShow()
	{
		return dao.getAllDonors().toString();		
		
	}

}