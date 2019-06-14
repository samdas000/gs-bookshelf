package com.space.bookshelf.services.beneficiary;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.space.bookshelf.services.beneficiary.dao.BeneficiaryDAO;
import com.space.bookshelf.services.beneficiary.model.Beneficiary;
import com.space.bookshelf.services.book.dao.BookDAO;
import com.space.bookshelf.services.book.model.Book;
import com.space.bookshelf.services.donor.dao.DonorDAO;
import com.space.bookshelf.services.donor.model.Donor;
import com.space.bookshelf.system.BeanUtil;

@RestController
public class BeneficiaryController 
{
	@Autowired
	private BeneficiaryDAO dao;
	
	
	@RequestMapping("/punya/beneficiary/add")
	public String getListofBooks()
	{
		Beneficiary beneficiary = new Beneficiary();
		
		beneficiary.setId("1");
		beneficiary.setFirstName("Samit");
		beneficiary.setLastName("Das");
		beneficiary.setEmailId("samit.das@gmail.com");
		beneficiary.setAddress("ADDRESS 1 2 3");
		beneficiary.setLocality("Viman Nagar");
		beneficiary.setPhoneNumber("9503142904");
        
		beneficiary.setCountry("India");
		beneficiary.setCity("Pune");
		beneficiary.setLatitude("LATITUDE");
		beneficiary.setLongitude("LONGITUDE");
		
		BeanUtil.getJSon(beneficiary);
		
		dao.addBeneficiary(beneficiary);
		return "New Beneficiary added!!";
		
		//return "index"; later need to forward to boot catalogue page
	}
	
	
	@RequestMapping("punya/beneficiary/show")
	public String testShow()
	{
		//Type listType = new TypeToken<List<String>>() {}.getType();
		//Gson gson = new Gson();
		//String val = gson.toJson(dao.getAllBeneficiaries().toString());	
		//System.out.println(val);
		return BeanUtil.getJSon(dao.getAllBeneficiaries());
		
	}
	
	

	@RequestMapping("punya/book/request")
	public String requestBook()
	{
		String book_id ="3";
		String beneficiary_id ="2";
		
		return "" + dao.requestBook(book_id, beneficiary_id);		
		
	}
	
	@RequestMapping("punya/book/listrequest")
	public String listrequest()
	{
		BeanUtil.getJSon(dao.getRequestList());		
		return "" + dao.getRequestList();		
		
	}
	
	

}
