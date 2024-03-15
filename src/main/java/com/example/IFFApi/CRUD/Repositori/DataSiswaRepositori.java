package com.example.IFFApi.CRUD.Repositori;

import com.example.IFFApi.CRUD.DTO.SiswaDataDTO;
import com.example.IFFApi.CRUD.Entity.DataSiswa;
import com.example.IFFApi.CRUD.Entity.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataSiswaRepositori  extends JpaRepository<DataSiswa , String> {


}
