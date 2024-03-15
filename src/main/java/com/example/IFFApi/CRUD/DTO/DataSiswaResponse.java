package com.example.IFFApi.CRUD.DTO;


import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class DataSiswaResponse {

private String id;
private String nama ;
private List<MataPelajaranResponse> mataPelajaranResponses;
}
