package com.example.piG1.service;

import com.example.piG1.model.City;
import com.example.piG1.model.CityDTO;
import com.example.piG1.repository.ICityRepository;
import com.example.piG1.service.IService.ICiudadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CityServices implements ICiudadService {
    @Autowired
    private ICityRepository ciudadRepository;

    @Autowired
    ObjectMapper mapper;

    private City guardarCiudad (CityDTO cityDTO) {
        City city = mapper.convertValue(cityDTO, City.class);
        return ciudadRepository.save(city);
    }

    @Override
    public City crearCiudad(CityDTO cityDTO) {
        return guardarCiudad(cityDTO);
    }

    @Override
    public CityDTO listarCiudad(Integer id) {
        Optional<City> ciudad = ciudadRepository.findById(id);
        CityDTO cityDTO = null;
        if(ciudad.isPresent()) {
            cityDTO = mapper.convertValue(ciudad, CityDTO.class);
        }
        return cityDTO;
    }

    @Override
    public City editarCiudad(CityDTO cityDTO) {
        return guardarCiudad(cityDTO);
    }

    @Override
    public void eliminarCiudad(Integer id) {
        ciudadRepository.deleteById(id);
    }

    @Override
    public List<CityDTO> listarCiudad() {
        List<City> ciudades = ciudadRepository.findAll();
        List<CityDTO> ciudadesDTO = new ArrayList<>();

        for(City city : ciudades){
            ciudadesDTO.add(mapper.convertValue(city, CityDTO.class));
        }
        ciudadesDTO .sort(Comparator.comparing(CityDTO::getId)); //
        return ciudadesDTO;
    }
}
