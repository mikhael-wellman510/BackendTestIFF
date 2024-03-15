package com.example.IFFApi.CRUD.Service;

import com.example.IFFApi.CRUD.DTO.MataPelajaranRequest;
import com.example.IFFApi.CRUD.DTO.MataPelajaranResponse;
import com.example.IFFApi.CRUD.Entity.MataPelajaran;
import com.example.IFFApi.CRUD.Repositori.MataPelajaranRepositori;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MataPelajaranServiceImpl implements MataPelajaranService{

    private final MataPelajaranRepositori mataPelajaranRepositori;


    @Override
    public MataPelajaranResponse addMapel(MataPelajaranRequest mataPelajaranRequest) {

        MataPelajaran mataPelajaran = MataPelajaran.builder()
                .code(mataPelajaranRequest.getCode())
                .mata_pelajaran(mataPelajaranRequest.getMataPelajaran())
                .build();

        MataPelajaran mp = mataPelajaranRepositori.saveAndFlush(mataPelajaran);
        return MataPelajaranResponse.builder()
                .id(mp.getId())
                .code(mp.getCode())
                .mataPelajaran(mp.getMata_pelajaran())

                .build();
    }

    @Override
    public MataPelajaranResponse editMapel(MataPelajaranRequest mataPelajaranRequest) {

        MataPelajaranResponse mp = findById(mataPelajaranRequest.getId());

        MataPelajaran mpNew = MataPelajaran.builder()
                .id(mp.getId())
                .code(mataPelajaranRequest.getCode())
                .mata_pelajaran(mataPelajaranRequest.getMataPelajaran())
                .build();

        MataPelajaran saveMp = mataPelajaranRepositori.saveAndFlush(mpNew);
        return MataPelajaranResponse.builder()
                .id(mpNew.getId())
                .code(saveMp.getCode())
                .mataPelajaran(saveMp.getMata_pelajaran())
                .build();
    }

    @Override
    public Boolean deleteMapel(String id) {

        MataPelajaran  mp = mataPelajaranRepositori.findById(id).orElse(null);

        if (mp != null){
            mataPelajaranRepositori.delete(mp);
            return true;
        }

        return false;
    }

    @Override
    public MataPelajaranResponse findById(String id) {

    MataPelajaran mataPelajaran = mataPelajaranRepositori.findById(id).orElse(null);



        return MataPelajaranResponse.builder()
                .id(mataPelajaran.getId())
                .code(mataPelajaran.getCode())
                .mataPelajaran(mataPelajaran.getMata_pelajaran())
                .build();
    }

    @Override
    public List<MataPelajaranResponse> findAll() {

        List<MataPelajaran> mataPelajaran = mataPelajaranRepositori.findAll();



        return mataPelajaran.stream().map(mapel -> MataPelajaranResponse.builder()
                .id(mapel.getId())
                .code(mapel.getCode())
                .mataPelajaran(mapel.getMata_pelajaran())
                .build()).toList();
    }
}
