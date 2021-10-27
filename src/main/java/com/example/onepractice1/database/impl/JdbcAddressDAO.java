package com.example.onepractice1.database.impl;

import com.example.onepractice1.database.AddressDAO;
import com.example.onepractice1.models.Address;
import com.example.onepractice1.models.Client;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class JdbcAddressDAO implements AddressDAO, InitializingBean {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class AddressRowMapper implements RowMapper<Address> {
        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address address = new Address();
            address.setId(rs.getLong("id"));
            address.setLandmark(rs.getString("landmark"));
            address.setCity(rs.getString("city"));
            address.setStreet(rs.getString("street"));
            address.setHouseNumber(rs.getInt("house_number"));
            address.setFlatNumber(rs.getInt("flat_number"));
            return address;
        }

    }

    @Override
    public Address findAddressById(Long id) {
        String sql = "SELECT * FROM ADDRESSES WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Address.class));
    }

    @Override
    public List<Address> findAll() {
        String sql = "SELECT * FROM ADDRESSES";
        return jdbcTemplate.query(sql, new AddressRowMapper());
    }

    @Override
    public void saveAddress(Address address) {
        String sql = "INSERT INTO ADDRESSES(id, landmark, city, street, house_number, flat_number) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                address.getId(), address.getLandmark(), address.getCity(), address.getStreet(), address.getHouseNumber(), address.getFlatNumber());
    }

    @Override
    public boolean deleteAddressById(Long id) {
        String sql = "DELETE FROM ADDRESSES WHERE id = ?";
        Object[] args = new Object[]{id};

        return jdbcTemplate.update(sql, args) == 1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Bean is null");
        }
    }
}
