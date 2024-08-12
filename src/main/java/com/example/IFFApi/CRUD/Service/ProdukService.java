package com.example.IFFApi.CRUD.Service;

import com.example.IFFApi.CRUD.Constant.Category;
import com.example.IFFApi.CRUD.DTO.CategoryCountResponse;
import com.example.IFFApi.CRUD.DTO.InformationPriceResponse;
import com.example.IFFApi.CRUD.DTO.PriceDetailResponse;
import com.example.IFFApi.CRUD.DTO.ProductResponse;

import java.util.List;

public interface ProdukService {

    ProductResponse getMaxPriceCategory();
    List<ProductResponse> findProduct(String product);
    List<ProductResponse> findRangeProduct(Integer start , Integer finish);

    List<ProductResponse> findPriceByCategory(Category category,String option , Integer limit);

    List<CategoryCountResponse> countPriceGroupBy();

    List<CategoryCountResponse> sumQuantity();

    List<InformationPriceResponse> informationPrice(Integer price);

    List<PriceDetailResponse> priceDetail();

}
