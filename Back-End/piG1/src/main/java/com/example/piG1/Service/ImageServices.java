package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.*;
import com.example.piG1.Repository.IImageRepository;
import com.example.piG1.Repository.IProductRepository;
import com.example.piG1.Service.IService.IImageServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ImageServices implements IImageServices {
    protected final static Logger logger = Logger.getLogger(ImageServices.class);
    @Autowired
    private IImageRepository imageRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public ImageDTO save(ImageDTO imageDTO) {
        Image image = mapper.convertValue(imageDTO, Image.class);
        imageRepository.save(image);
        if (imageDTO.getId() == null){
            imageDTO.setId(image.getId());
            logger.info("Imagen registrada correctamente: "+ imageDTO);
        }else{
            logger.info("Imagen actualizada correctamente: "+ imageDTO);
        }
        return imageDTO;
    }

    @Override
    public ImageDTO findById(Integer id) throws ResourceNotFoundException {
        Image image = checkId(id);
        ImageDTO imageDTO = mapper.convertValue(image, ImageDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return imageDTO;
    }

    @Override
    public List<ImageDTO> findAll() {
        List<ImageDTO> imagesDTO = new ArrayList<>();
        List<Image> images = imageRepository.findAll();
        for(Image image: images){
            imagesDTO.add(mapper.convertValue(image, ImageDTO.class));
        }
        imagesDTO .sort(Comparator.comparing(ImageDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ imagesDTO);
        return imagesDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        imageRepository.deleteById(id);
        logger.info("Se elimino la imagen correctamente con el id("+id+")");
    }

    @Override
    public Image checkId(Integer id) throws ResourceNotFoundException {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return image.get();
    }
}
