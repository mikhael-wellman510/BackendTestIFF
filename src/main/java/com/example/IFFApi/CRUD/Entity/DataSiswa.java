package com.example.IFFApi.CRUD.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_data_siswa")
@Builder(toBuilder = true)
public class DataSiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "mata_pelajaran_id")
    private MataPelajaran mataPelajaran;

    @ManyToOne
    @JoinColumn(name = "siswa_id")
    private Siswa siswa;

    @Override
    public String toString() {
        return "DataSiswa{" +
                "id='" + id + '\'' +
                ", mataPelajaran=" + mataPelajaran +
                ", siswa=" + siswa +
                '}';
    }
}
