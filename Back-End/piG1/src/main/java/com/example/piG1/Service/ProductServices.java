package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.*;
import com.example.piG1.Repository.*;
import com.example.piG1.Service.IService.IProductServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServices implements IProductServices {
    protected final static Logger logger = Logger.getLogger(ProductServices.class);

    @Autowired
    public IProductRepository productRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = mapper.convertValue(productDTO, Product.class);
        productRepository.save(product);
        if (productDTO.getId() == null){
            productDTO.setId(product.getId());
            logger.info("Producto registrada correctamente: "+ productDTO);
        }else{
            logger.info("Producto actualizada correctamente: "+ productDTO);
        }
        return productDTO;
    }

    @Override
    public ProductDTO findById(Integer id) throws ResourceNotFoundException {
        Product product = checkId(id);
        ProductDTO productDTO = mapper.convertValue(product, ProductDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return productDTO;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> productsDTO = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for(Product product: products){
            productsDTO.add(mapper.convertValue(product, ProductDTO.class));
        }
        productsDTO .sort(Comparator.comparing(ProductDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsDTO);
        return productsDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        productRepository.deleteById(id);
        logger.info("Se elimino el producto correctamente con el id("+id+")");
    }

    @Override
    public Product checkId(Integer id) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return product.get();
    }

    @Override
    public List<ProductDTO> findByCityId(Integer cityId) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        List<Product> products = productRepository.findByCityId(cityId);
        for(Product product: products){
            productsDTO.add(mapper.convertValue(product, ProductDTO.class));
        }
        productsDTO .sort(Comparator.comparing(ProductDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsDTO);
        return productsDTO;
    }

    @Override
    public List<ProductDTO> findByCityName(String cityName) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        List<Product> products = productRepository.findByCityName(cityName);
        for(Product product: products){
            productsDTO.add(mapper.convertValue(product, ProductDTO.class));
        }
        productsDTO .sort(Comparator.comparing(ProductDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsDTO);
        return productsDTO;
    }

    @Override
    public List<ProductDTO> findByCategoryId(Integer categoryId) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        List<Product> products = productRepository.findByCategoryId(categoryId);
        for(Product product: products){
            productsDTO.add(mapper.convertValue(product, ProductDTO.class));
        }
        productsDTO .sort(Comparator.comparing(ProductDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsDTO);
        return productsDTO;
    }

    @Override
    public List<ProductDTO> findByCategoryTitle(String categoryTitle) {
        List<ProductDTO> productsDTO = new ArrayList<>();
        List<Product> products = productRepository.findByCategoryTitle(categoryTitle);
        for(Product product: products){
            productsDTO.add(mapper.convertValue(product, ProductDTO.class));
        }
        productsDTO .sort(Comparator.comparing(ProductDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ productsDTO);
        return productsDTO;
    }
}
