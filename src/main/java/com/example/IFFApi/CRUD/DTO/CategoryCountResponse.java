package com.example.IFFApi.CRUD.DTO;


import com.example.IFFApi.CRUD.Constant.Category;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CategoryCountResponse {

    private Category category;
    private Long count;

    @Override
    public String toString() {
        return "CategoryCountResponse{" +
                "category=" + category +
                ", count=" + count +
                '}';
    }
}
