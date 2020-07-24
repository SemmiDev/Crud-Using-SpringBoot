package com.sammdiev.demo.dao;

import com.sammdiev.demo.entity.Mahasiswa;

import java.util.List;

public interface MahasiswaDao {

    public boolean insert(Mahasiswa mahasiswa);

    public boolean update(Mahasiswa mahasiswa);

    public boolean delete(Mahasiswa mahasiswa);

    public Mahasiswa getByNim(String nim);

    public List<Mahasiswa> getAll();
}
