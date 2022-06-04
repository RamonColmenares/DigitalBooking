package com.example.piG1.Service.IService;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.*;
import com.example.piG1.Model.Entity.Product;
import com.example.piG1.Service.ICheckId;

import java.util.List;

public interface IProductServices extends ICheckId<Product> {
    ProductCompliteDTO saveComplite(ProductDTO productDTO);
    ProductCompliteDTO addImages(ProductAddImagesDTO productAddImagesDTO);
    ProductCompliteDTO addPolicies(ProductAddPoliciesDTO productAddPoliciesDTO);
    ProductCompliteDTO addFeatures(ProductAddFeaturesDTO productAddFeaturesDTO);
    ProductDTO save(ProductDTO ProductDTO);
    ProductDTO findById(Integer id) throws ResourceNotFoundException;
    List<ProductCompliteDTO> findAll();
    void delete(Integer id) throws ResourceNotFoundException;
    List<ProductDTO> findByCityId(Integer cityId);
    List<ProductDTO> findByCityName(String cityName);
    List<ProductDTO> findByCategoryId(Integer categoryId);
    List<ProductDTO> findByCategoryTitle(String categoryTitle);


}
