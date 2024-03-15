package com.example.IFFApi.CRUD.Controller;


import com.example.IFFApi.CRUD.Constant.AppPath;
import com.example.IFFApi.CRUD.DTO.CommonResponse;
import com.example.IFFApi.CRUD.DTO.MataPelajaranRequest;
import com.example.IFFApi.CRUD.DTO.MataPelajaranResponse;
import com.example.IFFApi.CRUD.Service.MataPelajaranService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

@RequestMapping(AppPath.MATA_PELAJARAN)
public class MataPelajaranController {

    private final MataPelajaranService mataPelajaranService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/add")
    ResponseEntity<?>addProduct(@RequestBody MataPelajaranRequest mataPelajaranRequest){
        MataPelajaranResponse mataPelajaranResponse = mataPelajaranService.addMapel(mataPelajaranRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<MataPelajaranResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Succes Created mapel")
                        .data(mataPelajaranResponse)
                        .build()
                );
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/getAll")
    ResponseEntity<?>findAll(){
        List<MataPelajaranResponse> mataPelajaranResponses = mataPelajaranService.findAll();

     return    ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<List<MataPelajaranResponse>>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Success GetAll")
                        .data(mataPelajaranResponses)
                        .build()
                );
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping(value = "/editMapel")
    ResponseEntity<?> editMapel(@RequestBody MataPelajaranRequest mataPelajaranRequest){

        MataPelajaranResponse mataPelajaranResponse = mataPelajaranService.editMapel(mataPelajaranRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<MataPelajaranResponse>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Succes edit mapel")
                        .data(mataPelajaranResponse)
                        .build()
                );
    }

    @GetMapping("/find/{id}")
    ResponseEntity<?> findMapelById(@PathVariable String id){
        MataPelajaranResponse mpr = mataPelajaranService.findById(id);

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<MataPelajaranResponse>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Success Get Data By Id")
                        .data(mpr)
                        .build()
                );
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleted(@PathVariable String id){

        Boolean mapel = mataPelajaranService.deleteMapel(id);

        if (mapel){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.<Boolean>builder()
                            .statusCode(HttpStatus.OK.value())
                            .message("succes Deleted")
                            .build()
                    );
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Boolean>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Fail Deleted")
                        .build()
                );

    }

}
