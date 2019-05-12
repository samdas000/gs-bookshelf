package com.space.bookshelf.services.donor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.space.bookshelf.services.donor.model.Donor;

public class DonorRowMapper implements RowMapper<Donor> {

    @Override
    public Donor mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Donor donor = new Donor();

        donor.setId(rs.getString("ID"));
        donor.setFirstName(rs.getString("FIRST_NAME"));
        donor.setLastName(rs.getString("LAST_NAME"));
        donor.setEmailId(rs.getString("EMAIL_ID"));
        donor.setAddress(rs.getString("ADDRESS"));
        donor.setLocality(rs.getString("LOCALITY"));
        donor.setPhoneNumber(rs.getString("PHONE_NO"));
        
        donor.setCountry(rs.getString("COUNTRY"));
        donor.setCity(rs.getString("CITY"));
        donor.setLatitude(rs.getString("LATITUDE"));
        donor.setLongitude(rs.getString("LONGITUDE"));
        
        return donor;
    }


}
