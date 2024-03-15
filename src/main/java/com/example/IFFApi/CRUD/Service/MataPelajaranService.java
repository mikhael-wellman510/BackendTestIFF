package com.example.IFFApi.CRUD.Service;

import com.example.IFFApi.CRUD.DTO.MataPelajaranRequest;
import com.example.IFFApi.CRUD.DTO.MataPelajaranResponse;

import java.util.List;

public interface MataPelajaranService {

    MataPelajaranResponse addMapel(MataPelajaranRequest mataPelajaranRequest);

    MataPelajaranResponse editMapel(MataPelajaranRequest mataPelajaranRequest);

    Boolean deleteMapel(String id);

    MataPelajaranResponse findById(String id);

    List<MataPelajaranResponse> findAll();
}
