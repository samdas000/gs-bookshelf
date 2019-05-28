package com.space.bookshelf.services.beneficiary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.space.bookshelf.services.beneficiary.model.Beneficiary;
import com.space.bookshelf.services.donor.model.Donor;

public class BeneficiaryRowMapper implements RowMapper<Beneficiary> {

    @Override
    public Beneficiary mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        
    	final Beneficiary beneficiary = new Beneficiary();

        beneficiary.setId(rs.getString("ID"));
        beneficiary.setFirstName(rs.getString("FIRST_NAME"));
        beneficiary.setLastName(rs.getString("LAST_NAME"));
        beneficiary.setEmailId(rs.getString("EMAIL_ID"));
        beneficiary.setAddress(rs.getString("ADDRESS"));
        beneficiary.setLocality(rs.getString("LOCALITY"));
        beneficiary.setPhoneNumber(rs.getString("PHONE_NO"));
        
        beneficiary.setCountry(rs.getString("COUNTRY"));
        beneficiary.setCity(rs.getString("CITY"));
        beneficiary.setLatitude(rs.getString("LATITUDE"));
        beneficiary.setLongitude(rs.getString("LONGITUDE"));
        
        beneficiary.setSchoolName(rs.getString("SCHOOL_NAME"));
        beneficiary.setSchoolStream(rs.getString("SCHOOL_STREAM"));
        beneficiary.setSchoolLatititude(rs.getString("SCHOOL_LATITUDE"));
        beneficiary.setSchoolLongititude(rs.getString("SCHOOL_LONGITUDE"));
        
        return beneficiary;
    }


}
