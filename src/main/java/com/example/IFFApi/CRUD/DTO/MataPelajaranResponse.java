package com.example.IFFApi.CRUD.DTO;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MataPelajaranResponse {

    private String id;
    private String code ;
    private String mataPelajaran;

}
