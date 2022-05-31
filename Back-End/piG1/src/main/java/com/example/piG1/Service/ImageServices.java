package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.Image;
import com.example.piG1.Model.ImageDTO;
import com.example.piG1.Repository.IImageRepository;
import com.example.piG1.Repository.IProductRepository;
import com.example.piG1.Service.IService.IImageServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ImageServices implements IImageServices {
    @Autowired
    private IImageRepository imageRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public ImageDTO save(ImageDTO imageDTO) {
        return null;
    }

    @Override
    public ImageDTO findById(Integer id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ImageDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {

    }
}
