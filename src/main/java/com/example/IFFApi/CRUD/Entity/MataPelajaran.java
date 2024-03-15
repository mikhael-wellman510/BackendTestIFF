package com.example.IFFApi.CRUD.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "m_mata_pelajaran")
@Builder(toBuilder = true)
public class MataPelajaran {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column( nullable = false , length = 100)
    private String code ;

    @Column(nullable = false , length = 100)
    private String mata_pelajaran;

    @Override
    public String toString() {
        return "MataPelajaran{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", mata_pelajaran='" + mata_pelajaran + '\'' +
                '}';
    }
}
