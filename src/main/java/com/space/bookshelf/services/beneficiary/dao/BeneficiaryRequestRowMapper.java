package com.space.bookshelf.services.beneficiary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.space.bookshelf.services.beneficiary.model.Beneficiary;
import com.space.bookshelf.services.beneficiary.model.BeneficiaryRequest;
import com.space.bookshelf.services.book.model.Book;
import com.space.bookshelf.services.donor.model.Donor;

public class BeneficiaryRequestRowMapper implements RowMapper<BeneficiaryRequest> {

    @Override
    public BeneficiaryRequest mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        
    	final BeneficiaryRequest beneficiaryRequest = new BeneficiaryRequest();
    	final Beneficiary beneficiary = new Beneficiary();
    	final Book book = new Book();
    	
        //beneficiary.setId(rs.getString("ID"));
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
        
        book.setStream(rs.getString("STREAM"));
        book.setStandard(rs.getString("STANDARD"));
        book.setSubject(rs.getString("SUBJECT"));
        book.setAuthor(rs.getString("AUTHOR"));
        book.setTitle(rs.getString("TITLE"));
        book.setEdition(rs.getString("EDITION"));
        
        beneficiaryRequest.setBeneficiary(beneficiary);
        beneficiaryRequest.setBook(book);
        
        return beneficiaryRequest;
    }


}
