package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.*;
import com.example.piG1.Repository.*;
import com.example.piG1.Service.IService.IProductServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ProductServices implements IProductServices {
    protected final static Logger logger = Logger.getLogger(ProductServices.class);

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ProductServices productServices;
    @Autowired
    private IImageRepository imageRepository;
    @Autowired
    private IFeatureRepository featureRepository;
    @Autowired
    private ICityRepository cityRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO findById(Integer id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {

    }
}
