package com.example.piG1.service;

import com.example.piG1.model.Image;
import com.example.piG1.model.ImageDTO;
import com.example.piG1.repository.IImageRepository;
import com.example.piG1.repository.IProductRepository;
import com.example.piG1.service.IService.IImagenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ImageServices implements IImagenService {
    @Autowired
    private IImageRepository imagenRepository;
    @Autowired
    private IProductRepository productoRepository;

    @Autowired
    ObjectMapper mapper;

    private Image guardarImagen (ImageDTO imageDTO) {
        Image imagen = mapper.convertValue(imageDTO, Image.class);
        return imagenRepository.save(imagen);
    }

    @Override
    public Image crearImagen(ImageDTO imageDTO) {
        return guardarImagen(imageDTO);
    }

    @Override
    public ImageDTO listarImagen(Integer id) {
        Optional<Image> imagen = imagenRepository.findById(id);
        ImageDTO imageDTO = null;
        if(imagen.isPresent()) {
            imageDTO = mapper.convertValue(imagen, ImageDTO.class);
        }
        return imageDTO;
    }

    @Override
    public Image editarImagen(ImageDTO imageDTO) {
        return guardarImagen(imageDTO);
    }

    @Override
    public void eliminarImagen(Integer id) {
        imagenRepository.deleteById(id);
    }

    @Override
    public List<ImageDTO> listarImagenes() {
        List<Image> imagenes = imagenRepository.findAll();
        List<ImageDTO> imagenesDTO = new ArrayList<>();

        for(Image imagen: imagenes){
            imagenesDTO.add(mapper.convertValue(imagen, ImageDTO.class));
        }
        imagenesDTO .sort(Comparator.comparing(ImageDTO::getId)); //
        return imagenesDTO;
    }
}
