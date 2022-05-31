package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.City;
import com.example.piG1.Model.CityDTO;
import com.example.piG1.Repository.ICityRepository;
import com.example.piG1.Service.IService.ICityServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CityServices implements ICityServices {
    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public CityDTO save(CityDTO cityDTO) {
        return null;
    }

    @Override
    public CityDTO findById(Integer id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<CityDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {

    }
}
