package com.example.IFFApi.CRUD.DTO;

import com.example.IFFApi.CRUD.Constant.Category;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {
    private String id;
    private String name;
    private Integer price;
    private Category category;
    private String description;

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
