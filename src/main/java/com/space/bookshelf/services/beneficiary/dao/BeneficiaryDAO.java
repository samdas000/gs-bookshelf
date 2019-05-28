package com.space.bookshelf.services.beneficiary.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.space.bookshelf.services.beneficiary.model.Beneficiary;
import com.space.bookshelf.services.beneficiary.model.BeneficiaryRequest;
import com.space.bookshelf.services.donor.model.Donor;

@Repository
public class BeneficiaryDAO 
{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(final DataSource dataSource) 
	{
		System.out.println("initializing JDBC Template" + dataSource.toString());
        jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("Initialized...");
	}
	
	
	
	public void addBeneficiary(Beneficiary beneficiary) 
	{
		//Add Donor	
    	System.out.println("Adding Donor");
		String sql = "INSERT INTO BENEFICIARY (FIRST_NAME, LAST_NAME, EMAIL_ID, ADDRESS, LOCALITY, PINCODE, PHONE_NO, COUNTRY, CITY, LATITUDE, LONGITUDE, SCHOOL_NAME, SCHOOL_STREAM, SCHOOL_LATITUDE, SCHOOL_LONGITUDE) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, beneficiary.getFirstName(), beneficiary.getLastName(), beneficiary.getEmailId(),
				beneficiary.getAddress(), beneficiary.getLocality(), beneficiary.getPinCode(), beneficiary.getPhoneNumber(),
				beneficiary.getCountry(), beneficiary.getCity(), beneficiary.getLatitude(), beneficiary.getLongitude(),
				beneficiary.getSchoolName(), beneficiary.getSchoolStream(), beneficiary.getSchoolLatititude(), beneficiary.getSchoolLongititude());
		System.out.println("Added Beneficiary");
		
	}

	public List<Beneficiary> getAllBeneficiaries()
	{
		String sql = "SELECT * FROM BENEFICIARY";
        RowMapper<Beneficiary> rowMapper = new BeneficiaryRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	public int requestBook(String book_id, String beneficiary_id) 
	{
		//Add Book	
		System.out.println("Logging a new request for a Book");
		String sql = "INSERT INTO BOOK_REQUEST (BOOK_ID, BENEFICIARY_ID, CREATION_DATE, STATUS) "
												+ "values (?, ?, ?, ?)";
		int i = jdbcTemplate.update(sql, book_id, beneficiary_id, new java.sql.Date(System.currentTimeMillis()), "N");
		System.out.println("Logged a new request for a Book");
		
		return i;
		
	}
	
	
	public List<BeneficiaryRequest> getRequestList()
	{
		String sql = "SELECT n.FIRST_NAME, n.LAST_NAME, n.EMAIL_ID, n.ADDRESS, n.LOCALITY, "
					+ "n.PINCODE, n.LAST_NAME, n.PHONE_NO, n.COUNTRY, n.CITY, "
					+ "n.LATITUDE, n.LONGITUDE, n.SCHOOL_NAME, n.SCHOOL_STREAM, n.SCHOOL_LATITUDE, n.SCHOOL_LONGITUDE, "
					+ "b.STREAM, b.STANDARD, b.SUBJECT, b.AUTHOR, b.TITLE, b.EDITION, r.CREATION_DATE "
					+ "FROM BOOK_REQUEST r, BENEFICIARY n, BOOK b "
					+ "WHERE r.BOOK_ID = b.ID AND r.BENEFICIARY_ID = n.ID";
        RowMapper<BeneficiaryRequest> rowMapper = new BeneficiaryRequestRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	

	
	

	
}

