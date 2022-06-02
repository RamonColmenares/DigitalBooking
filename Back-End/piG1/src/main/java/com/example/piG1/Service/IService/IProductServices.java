package com.example.piG1.Service.IService;

import com.example.piG1.Model.Category;
import com.example.piG1.Model.Product;
import com.example.piG1.Model.ProductDTO;
import com.example.piG1.Service.ICheckId;
import com.example.piG1.Service.IServices;

import java.util.List;

public interface IProductServices extends IServices<ProductDTO>, ICheckId<Product> {

    List<ProductDTO> findByCityId(Integer cityId);
    List<ProductDTO> findByCityName(String cityName);
    List<ProductDTO> findByCategoryId(Integer categoryId);
    List<ProductDTO> findByCategoryTitle(String categoryTitle);


}
