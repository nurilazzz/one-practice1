package com.example.onepractice1.database.impl;

import com.example.onepractice1.database.ClientDAO;
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
public class JdbcClientDAO implements ClientDAO, InitializingBean {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    class ClientRowMapper implements RowMapper<Client> {
        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setId(rs.getLong("id"));
            client.setClientName(rs.getString("client_name"));
            client.setSurname(rs.getString("surname"));
            client.setEmail(rs.getString("email"));
            return client;
        }

    }

    @Override
    public Client findClientById(Long id) {
        String sql = "SELECT * FROM CLIENTS WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM CLIENTS";
        return jdbcTemplate.query(sql, new ClientRowMapper());
    }

    @Override
    public void saveClient(Client client) {
        String sql = "INSERT INTO CLIENTS(id, client_name, surname, email) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, client.getId(), client.getClientName(),client.getSurname(),client.getEmail());
    }

    @Override
    public boolean deleteClientById(Long id) {
        String sql = "DELETE FROM CLIENTS WHERE id = ?";
        return jdbcTemplate.update(sql, new Object[] {id}) == 1;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(jdbcTemplate == null){
            throw new BeanCreationException("Bean is null");
        }
    }
}
