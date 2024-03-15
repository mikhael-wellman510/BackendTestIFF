package com.example.IFFApi.CRUD.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_siswa")
@Builder(toBuilder = true)
public class Siswa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false , length = 100)
    private String nama;

    @Column(nullable = false , length = 100)
    private String kelas;

    @Override
    public String toString() {
        return "Siswa{" +
                "id='" + id + '\'' +
                ", nama='" + nama + '\'' +
                ", kelas='" + kelas + '\'' +
                '}';
    }
//
//
//    @Override
//    public String toString() {
//        return "Siswa{" +
//                "id='" + id + '\'' +
//                ", nama='" + nama + '\'' +
//                ", kelas='" + kelas + '\'' +
//                ", dataSiswas.size=" + (dataSiswas != null ? dataSiswas : "null") +
//                '}';
//    }

}
