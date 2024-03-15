package com.example.IFFApi.CRUD.Service;

import com.example.IFFApi.CRUD.DTO.DataSiswaRequest;
import com.example.IFFApi.CRUD.DTO.DataSiswaResponse;
import com.example.IFFApi.CRUD.DTO.MataPelajaranRequest;
import com.example.IFFApi.CRUD.DTO.SiswaDataDTO;
import com.example.IFFApi.CRUD.Entity.DataSiswa;
import com.example.IFFApi.CRUD.Entity.MataPelajaran;
import com.example.IFFApi.CRUD.Entity.Siswa;
import com.example.IFFApi.CRUD.Repositori.DataSiswaRepositori;
import com.example.IFFApi.CRUD.Repositori.MataPelajaranRepositori;
import com.example.IFFApi.CRUD.Repositori.SiswaRepositori;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataSiswaServiceImpl implements DataSiswaService{

    private final DataSiswaRepositori dataSiswaRepositori;
    private final SiswaRepositori siswaRepositori;
    private final MataPelajaranRepositori mataPelajaranRepositori;

    @Override
    @Transactional
    public DataSiswaResponse addDataSiswa(DataSiswaRequest dataSiswaRequest) {

        // Todo -> siswa

        Siswa siswa = Siswa.builder()
                .nama(dataSiswaRequest.getNama())
                .kelas(dataSiswaRequest.getKelas())
                .build();

        Siswa add = siswaRepositori.save(siswa);

        // looping
        List<DataSiswa> ds = new ArrayList<>();
        for (MataPelajaranRequest a  : dataSiswaRequest.getMataPelajaran()){

            MataPelajaran mp = mataPelajaranRepositori.findById(a.getId()).orElse(null);

            DataSiswa dataSiswa = DataSiswa.builder()
                    .siswa(siswa)
                    .mataPelajaran(mp)
                    .build();

            DataSiswa save = dataSiswaRepositori.saveAndFlush(dataSiswa);
            ds.add(save);
        }



        return DataSiswaResponse.builder()
                .id(siswa.getId())

                .build();
    }

    @Override
    public List<Siswa> getAll() {


        List<Siswa> data =  siswaRepositori.findAll();
        List<MataPelajaran> mp = mataPelajaranRepositori.findAll();





        return null;
    }
}


