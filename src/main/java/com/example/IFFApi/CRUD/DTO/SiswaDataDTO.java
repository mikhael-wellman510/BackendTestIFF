package com.example.IFFApi.CRUD.DTO;

import com.example.IFFApi.CRUD.Entity.MataPelajaran;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SiswaDataDTO {
    private String nama;
    private String kelas;
    private List<MataPelajaran> mapel;
}
