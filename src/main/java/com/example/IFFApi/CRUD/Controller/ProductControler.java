package com.example.IFFApi.CRUD.Controller;


import com.example.IFFApi.CRUD.Constant.AppPath;
import com.example.IFFApi.CRUD.Constant.Category;
import com.example.IFFApi.CRUD.DTO.*;
import com.example.IFFApi.CRUD.Service.ProdukService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping(AppPath.PRODUK)
public class ProductControler {

    private final ProdukService produkService;

    public ProductControler(ProdukService produkService){
        this.produkService = produkService;
    }
    @GetMapping(value = "/findMax")
    ResponseEntity<?> getMaxProduct(){
        ProductResponse productResponse = produkService.getMaxPriceCategory();
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<ProductResponse>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("succes")
                        .data(productResponse)
                        .build()
                    );
    }

    @GetMapping(value = "/findProducts/{product}")
    ResponseEntity<?> findProduct(@PathVariable String product){

        List<ProductResponse> productResponse = produkService.findProduct(product);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<ProductResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Succes")
                        .data(productResponse)
                        .build()
                );
    }

    @GetMapping(value = "/findRangePrice")
    ResponseEntity<?> findRangePriceProduct(@RequestParam Integer minPrice , @RequestParam Integer maxPrice){

        List<ProductResponse> productResponses = produkService.findRangeProduct(minPrice,maxPrice);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<ProductResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Success")
                        .data(productResponses)
                        .build()
                );
    }

    @GetMapping(value = "/findPriceByCategories")
    ResponseEntity<?> findPriceByCategories(@RequestParam Category category , @RequestParam String option ,@RequestParam Integer limit){

        List<ProductResponse> productResponses = produkService.findPriceByCategory(category, option, limit);

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<ProductResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Succes")
                        .data(productResponses)
                        .build()
                );
    }

    @GetMapping(value = "/groupByCategories")
    ResponseEntity<?> findPriceGroupBy(){
        List<CategoryCountResponse> productResponse = produkService.countPriceGroupBy();

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<CategoryCountResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Succes")
                        .data(productResponse)
                        .build()
                );
    }

    @GetMapping(value = "/sumProduct")
    ResponseEntity<?> getSumQuantity(){

        List<CategoryCountResponse> productResponse =  produkService.sumQuantity();


        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<CategoryCountResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Succes")
                        .data(productResponse)
                        .build()
                );
    }

    @GetMapping(value = "/getInformationPrice")
    ResponseEntity<?> getInformationPrice(@RequestParam Integer price){

        List<InformationPriceResponse> result = produkService.informationPrice(price);

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<InformationPriceResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .message("Succes")
                        .data(result)
                        .build()
                );
    }

    @GetMapping(value = "/getPriceDetail")
    ResponseEntity<?>getPriceDetail(){

        List<PriceDetailResponse> pdr = produkService.priceDetail();

        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.<List<PriceDetailResponse>>builder()
                        .statusCode(HttpStatus.FOUND.value())
                                .message("Succes")
                                .data(pdr)
                                .build()
                        );
    }





}
