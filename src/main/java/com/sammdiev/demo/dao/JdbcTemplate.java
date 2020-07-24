package com.sammdiev.demo.dao;

import com.sammdiev.demo.entity.Mahasiswa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcTemplate implements MahasiswaDao {

    private final String INSERT = "INSERT INTO mahasiswa (nim, name, ipk, jurusan) VALUES (?,?,?,?)";
    private final String UPDATE = "UPDATE mahasiswa SET name=?, ipk=?, jurusan=? WHERE nim=?";
    private final String DELETE = "DELETE FROM mahasiswa WHERE nim=?";
    private final String SELECT_ALL = "SELECT nim,name,ipk,jurusan FROM mahasiswa";
    private final String SELECT_BY_NIM = "SELECT nim,name,ipk,jurusan FROM mahasiswa WHERE nim=?";
    private static Logger LOGGER = LoggerFactory.getLogger(JdbcTemplate.class.getName());

    @Autowired
    org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;

    @Override
    public boolean insert(Mahasiswa mahasiswa) {
        return jdbcTemplate.update(INSERT, new Object[]
                {mahasiswa.getNim(), mahasiswa.getName(), mahasiswa.getIpk(), mahasiswa.getJurusan()}) > 0 ? true : false;
    }

    @Override
    public boolean update(Mahasiswa mahasiswa) {
        return jdbcTemplate.update(UPDATE, new Object[]
                {mahasiswa.getName(), mahasiswa.getIpk(), mahasiswa.getJurusan(), mahasiswa.getNim()}) > 0 ? true : false;
    }

    @Override
    public boolean delete(Mahasiswa mahasiswa) {
        return jdbcTemplate.update(DELETE, new Object[]{mahasiswa.getNim()}) > 0 ? true : false;
    }

    @Override
    public Mahasiswa getByNim(String nim) {
        return jdbcTemplate.queryForObject(SELECT_BY_NIM, new Object[]{nim}, new MahasiswaRowMapper());
    }

    @Override
    public List<Mahasiswa> getAll() {
        return jdbcTemplate.query(SELECT_ALL, new MahasiswaRowMapper());
    }

    private class MahasiswaRowMapper implements RowMapper<Mahasiswa> {

        @Override
        public Mahasiswa mapRow(ResultSet resultSet, int i) throws SQLException {
            Mahasiswa mahasiswa = new Mahasiswa();
            mahasiswa.setNim(resultSet.getString("nim"));
            mahasiswa.setName(resultSet.getString("name"));
            mahasiswa.setJurusan(resultSet.getString("jurusan"));
            mahasiswa.setIpk(resultSet.getFloat("ipk"));
            return mahasiswa;
        }
    }

}
