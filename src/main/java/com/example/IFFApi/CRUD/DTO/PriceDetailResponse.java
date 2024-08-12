package com.example.IFFApi.CRUD.DTO;

import com.example.IFFApi.CRUD.Constant.Category;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PriceDetailResponse {

    private Category category;
    private Long total;
    private Integer termurah;
    private Integer termahal;
    private Double rata_rata;

    @Override
    public String toString() {
        return "PriceDetailResponse{" +
                "category=" + category +
                ", total=" + total +
                ", termurah=" + termurah +
                ", termahal=" + termahal +
                ", rata_rata=" + rata_rata +
                '}';
    }
}
