package com.example.piG1.service.IService;

import com.example.piG1.model.City;
import com.example.piG1.model.CityDTO;

import java.util.List;

public interface ICiudadService {
    public City crearCiudad (CityDTO cityDTO);
    public CityDTO listarCiudad(Integer id);
    public City editarCiudad (CityDTO cityDTO);
    public void eliminarCiudad (Integer id);
    public List<CityDTO> listarCiudad();
}
