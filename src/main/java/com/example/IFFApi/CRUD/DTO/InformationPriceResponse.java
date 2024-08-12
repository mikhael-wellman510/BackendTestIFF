package com.example.IFFApi.CRUD.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class InformationPriceResponse {

    private Integer price;
    private String keterangan;

    @Override
    public String toString() {
        return "InformationPriceResponse{" +
                "price=" + price +
                ", keterangan='" + keterangan + '\'' +
                '}';
    }
}
