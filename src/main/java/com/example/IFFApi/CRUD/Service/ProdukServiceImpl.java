package com.example.IFFApi.CRUD.Service;

import com.example.IFFApi.CRUD.Constant.Category;
import com.example.IFFApi.CRUD.DTO.CategoryCountResponse;
import com.example.IFFApi.CRUD.DTO.InformationPriceResponse;
import com.example.IFFApi.CRUD.DTO.PriceDetailResponse;
import com.example.IFFApi.CRUD.DTO.ProductResponse;
import com.example.IFFApi.CRUD.Entity.Product;
import com.example.IFFApi.CRUD.InterfaceQuery.InformationProduct;
import com.example.IFFApi.CRUD.InterfaceQuery.PriceDetailInformation;
import com.example.IFFApi.CRUD.InterfaceQuery.ProductCountGrouping;
import com.example.IFFApi.CRUD.InterfaceQuery.ProductSumPrice;
import com.example.IFFApi.CRUD.Repositori.ProductRepositori;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
//@RequiredArgsConstructor
public class ProdukServiceImpl implements ProdukService{

    private final ProductRepositori productRepositori;


    public ProdukServiceImpl(ProductRepositori productRepositori){
        this.productRepositori = productRepositori;

    }

    @Override
    public ProductResponse getMaxPriceCategory() {
        List<Product> res = productRepositori.findMaxPriceCuk();

        return null;
    }

    @Override
    public List<ProductResponse> findProduct(String product) {

        List<Product> getProduct = productRepositori.findProduct(product);


        return getProduct.stream().map(val -> ProductResponse.builder()
                .id(val.getId())
                .name(val.getName())
                .price(val.getPrice())
                .build()).toList();
    }

    @Override
    public List<ProductResponse> findRangeProduct(Integer start, Integer finish) {

        List<Product> getProduct = productRepositori.findRangePrice(start,finish);

        return getProduct.stream().map(val -> {
            return ProductResponse.builder()
                    .id(val.getId())
                    .name(val.getName())
                    .price(val.getPrice())
                    .build();

        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> findPriceByCategory(Category category, String option, Integer limit) {


        if (option.equals("MURAH")){

            List<Product> products = productRepositori.findPriceByCategoriesNativeAsc(Category.MAKANAN.name() , limit);
            System.out.println(products);
        }else {

            List<Product> products = productRepositori.findPriceByCategoriesNativeDesc(Category.MAKANAN.name(),  limit);
            System.out.println(products);
        }



        return null;
    }

    @Override
    public List<CategoryCountResponse> countPriceGroupBy() {

        List<ProductCountGrouping> results = productRepositori.countGroupByPrice();
        List<CategoryCountResponse> categoryCountResponses = new ArrayList<>();

        results.stream().forEach(val -> {
            System.out.println(val.getCount());
            System.out.println(val.getCategory());
        });
        System.out.println(results);




        return null;
    }


    @Override
    public List<CategoryCountResponse> sumQuantity() {

        List<ProductSumPrice> psp = productRepositori.countSumPrice();

        List<CategoryCountResponse> res = psp.stream().map(val -> {

            return CategoryCountResponse.builder()
                    .category(val.getKategori())
                    .count(val.getTotal())
                    .build();

        }).toList();

        System.out.println(res);
        return null;
    }

    @Override
    public List<InformationPriceResponse> informationPrice(Integer price) {

        List<InformationProduct> informationProducts = productRepositori.findInformationProduct(price);

        return informationProducts.stream().map(val -> InformationPriceResponse.builder()
                .price(val.getPrice())
                .keterangan(val.getKeterangan())
                .build()).toList();
    }

    @Override
    public List<PriceDetailResponse> priceDetail() {
        List<PriceDetailInformation> res = productRepositori.priceDetail();

        List<PriceDetailResponse> pdr = res.stream().map(val -> {
            Category category = null;
            switch (val.getCategory()){
                case "MAKANAN" :
                    category = Category.MAKANAN;
                    break;
                case "MINUMAN" :
                    category = Category.MINUMAN;
                    break;
                case "KOPI" :
                    category =Category.KOPI;
                    break;

            }
            return PriceDetailResponse.builder()
                    .category(category)
                    .total(val.getTotal())
                    .termurah(val.getTermurah())
                    .termahal(val.getTermahal())
                    .rata_rata(val.getRata_rata())
                    .build();
        }).toList();

        return pdr;
    }
}
