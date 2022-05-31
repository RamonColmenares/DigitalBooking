package com.example.piG1.service.IService;

import com.example.piG1.model.Image;
import com.example.piG1.model.ImageDTO;

import java.util.List;

public interface IImagenService {
    public Image crearImagen (ImageDTO imageDTO);
    public ImageDTO listarImagen (Integer id);
    public Image editarImagen  (ImageDTO imageDTO) throws ResourceNotFoundException;
    public void eliminarImagen  (Integer id);
    public List<ImageDTO> listarImagenes();
}
