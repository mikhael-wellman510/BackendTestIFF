package com.example.IFFApi.CRUD.Service;

import com.example.IFFApi.CRUD.DTO.DataSiswaRequest;
import com.example.IFFApi.CRUD.DTO.DataSiswaResponse;
import com.example.IFFApi.CRUD.Entity.Siswa;

import java.util.List;

public interface DataSiswaService {

    DataSiswaResponse addDataSiswa(DataSiswaRequest dataSiswaRequest);

    List<Siswa> getAll();


}
