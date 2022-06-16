package com.example.piG1.Service.IService;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.ProductDTO.*;
import com.example.piG1.Model.Entity.Product;
import com.example.piG1.Service.ICheckId;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IProductServices extends ICheckId<Product> {
    ProductCompliteDTO saveComplite(ProductDTO productDTO);
    ProductCompliteDTO addImages(ProductAddImagesDTO productAddImagesDTO);
    ProductCompliteDTO addPolicies(ProductAddPoliciesDTO productAddPoliciesDTO);
    ProductCompliteDTO addFeatures(ProductAddFeaturesDTO productAddFeaturesDTO);
    ProductDTO save(ProductDTO ProductDTO);
    ProductFullDTO findById(Integer id) throws ResourceNotFoundException;
    ProductCompliteDTO findByIdComplite(Integer id) throws ResourceNotFoundException;
    List<GetProductsAllDTO> findAll() throws ResourceNotFoundException;
    void delete(Integer id) throws ResourceNotFoundException;
    List<ProductFindByFilterDTO> findByCityId(Integer cityId) throws ResourceNotFoundException;
    List<ProductFindByFilterDTO> findByCategoryId(Integer categoryId) throws ResourceNotFoundException;
    List<ProductFindByFilterDTO> findByQueryParams(Set<String> cityName, Set<String> categoryTitle) throws ResourceNotFoundException;
    List <ProductFindByFilterDTO> findBeetwenTwoDates(Date startDate, Date endDate) throws ResourceNotFoundException;
    List <ProductFindByFilterDTO> findBeetwenTwoDatesAndCity(Date startDate, Date endDate, String city) throws ResourceNotFoundException;
}
