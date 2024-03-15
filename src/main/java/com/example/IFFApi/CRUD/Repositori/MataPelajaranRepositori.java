package com.example.IFFApi.CRUD.Repositori;

import com.example.IFFApi.CRUD.Entity.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataPelajaranRepositori extends JpaRepository<MataPelajaran , String> {
}
