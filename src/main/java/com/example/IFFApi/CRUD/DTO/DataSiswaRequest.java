package com.example.IFFApi.CRUD.DTO;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DataSiswaRequest {

    private String nama;
    private String kelas ;
    private List<MataPelajaranRequest> mataPelajaran;

    @Override
    public String toString() {
        return "DataSiswaRequest{" +
                "nama='" + nama + '\'' +
                ", kelas='" + kelas + '\'' +
                ", mataPelajaran=" + mataPelajaran +
                '}';
    }
}
