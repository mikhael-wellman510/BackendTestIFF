package com.example.IFFApi.CRUD.Controller;

import com.example.IFFApi.CRUD.Constant.AppPath;
import com.example.IFFApi.CRUD.DTO.CommonResponse;
import com.example.IFFApi.CRUD.DTO.DataSiswaRequest;
import com.example.IFFApi.CRUD.DTO.DataSiswaResponse;
import com.example.IFFApi.CRUD.DTO.MataPelajaranResponse;
import com.example.IFFApi.CRUD.Entity.Siswa;
import com.example.IFFApi.CRUD.Service.DataSiswaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping(AppPath.DATA_SISWA)
public class DataSiswaController {

    private final DataSiswaService dataSiswaService;


    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/addDs")
    ResponseEntity<?> dataSiswa(@RequestBody DataSiswaRequest dataSiswaRequest){
        DataSiswaResponse dataSiswaResponse = dataSiswaService.addDataSiswa(dataSiswaRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<DataSiswaResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Succes Created mapel")
                        .data(dataSiswaResponse)
                        .build()
                );

    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/gets")
    ResponseEntity<?> getAllSiswa(){
        List<Siswa> result = dataSiswaService.getAll();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<List<Siswa>>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Succes get mapel")
                        .data(result)
                        .build()
                );

    }

}
