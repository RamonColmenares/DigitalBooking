package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.*;
import com.example.piG1.Repository.IFeatureRepository;
import com.example.piG1.Service.IService.IFeatureServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FeatureServices implements IFeatureServices {

    @Autowired
    private IFeatureRepository featureRepository;
    @Autowired
    private FeatureServices featureServices;

    @Autowired
    ObjectMapper mapper;


    @Override
    public FeatureDTO save(FeatureDTO featureDTO) {
        return null;
    }

    @Override
    public FeatureDTO findById(Integer id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<FeatureDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {

    }
}
