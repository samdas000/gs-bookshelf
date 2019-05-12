package com.space.bookshelf.services.donor.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.space.bookshelf.services.donor.model.Donor;

@Repository
public class DonorDAO 
{
	
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
    public void setDataSource(final DataSource dataSource) 
	{
		System.out.println("initializing JDBC Template");
        jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DROP TABLE DONOR IF EXISTS";
		//jdbcTemplate.execute(sql);
		String sql2 = "CREATE TABLE DONOR (" +
				"ID Bigint(10) NOT NULL AUTO_INCREMENT, " + 
				"FIRST_NAME Varchar(20), " + 
				"LAST_NAME Varchar(20), " + 
				"EMAIL_ID Varchar(20), " + 
				"ADDRESS Varchar(50), " + 
				"LOCALITY Varchar(20), " + 
				"PHONE_NO Varchar(20), " + 
				"COUNTRY Varchar(20), " + 
				"CITY Varchar(20), " + 
				"LATITUDE Varchar(20), " + 
				"LONGITUDE Varchar(20))";
		jdbcTemplate.execute(sql2);
		System.out.println("Initialized...");
	}
	
	
	
	public void addDonor(Donor donor) 
	{
		//Add Donor	
    	System.out.println("Adding Donor");
		String sql = "INSERT INTO DONOR (FIRST_NAME, LAST_NAME, EMAIL_ID, ADDRESS, LOCALITY, PHONE_NO, COUNTRY, CITY, LATITUDE, LONGITUDE) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, donor.getFirstName(), donor.getLastName(), donor.getEmailId(),
								donor.getAddress(), donor.getLocality(), donor.getPhoneNumber(),
								donor.getCountry(), donor.getCity(), donor.getLatitude(), donor.getLongitude());
		System.out.println("Added Donor");
		
	}

	public List<Donor> getAllDonors()
	{
		String sql = "SELECT * FROM DONOR";
        RowMapper<Donor> rowMapper = new DonorRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	
}

