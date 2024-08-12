package com.example.IFFApi.CRUD.Repositori;

import com.example.IFFApi.CRUD.Entity.Product;
import com.example.IFFApi.CRUD.InterfaceQuery.InformationProduct;
import com.example.IFFApi.CRUD.InterfaceQuery.PriceDetailInformation;
import com.example.IFFApi.CRUD.InterfaceQuery.ProductCountGrouping;
import com.example.IFFApi.CRUD.InterfaceQuery.ProductSumPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositori extends JpaRepository<Product, String> {

    @Query(value = "select P.id, p.name , p.price , p.category , p.description , p.created_at , p.quantity from m_product as p join (select max(price) as max_prices , category from m_product group by category) \n" +
            "as max_price on p.category = max_price.category and p.price = max_price.max_prices", nativeQuery = true)
    List<Product> findMaxPriceCuk();

    @Query(value = "select * from m_product\n" +
            "where name ilike %:name%" , nativeQuery = true)
    List<Product> findProduct(@Param("name")String name);

    @Query(value = "select * from m_product where price between :min and :max" , nativeQuery = true)
    List<Product> findRangePrice(@Param("min") Integer min , @Param("max") Integer max);

    @Query(value = "select * from m_product where category = :category order by price asc limit :limit" , nativeQuery = true)
    List<Product> findPriceByCategoriesNativeAsc(@Param("category")String category , @Param("limit") Integer limit);

    @Query(value = "select * from m_product where category = :category order by price desc limit :limit" , nativeQuery = true)
    List<Product> findPriceByCategoriesNativeDesc(@Param("category")String category ,  @Param("limit") Integer limit);

    @Query(value = "select p.category , count(price) from m_product as p group by p.category" , nativeQuery = true)
    List<ProductCountGrouping> countGroupByPrice();


    @Query(value = "select p.category as kategori , sum(quantity) as total from m_product as p group by p.category having sum(quantity) > 40" , nativeQuery = true)
    List<ProductSumPrice> countSumPrice();

    @Query(value = "select p.price , case when p.price > :price then 'Mahal' when p.price < :price then 'Murah' else 'Normal' end as keterangan from m_product as p" , nativeQuery = true)
    List<InformationProduct> findInformationProduct(@Param("price") Integer price);

    @Query(value = "select p.category , " +
            "sum(p.price) as total ," +
            "min(p.price) as termurah ," +
            "max(p.price) as termahal ," +
            "avg(p.price) as rata_rata " +
            "from m_product as p " +
            "group by p.category" , nativeQuery = true)
    List<PriceDetailInformation> priceDetail();

}
