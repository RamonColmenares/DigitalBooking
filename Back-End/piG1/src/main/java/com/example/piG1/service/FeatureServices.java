package com.example.piG1.service;

import com.example.piG1.model.*;
import com.example.piG1.repository.IFeatureRepository;
import com.example.piG1.service.IService.ICaracteristicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FeatureServices implements ICaracteristicaService {

    @Autowired
    private IFeatureRepository caracteristicaRepository;
    @Autowired
    private FeatureServices featureServices;

    @Autowired
    ObjectMapper mapper;

    private Feature guardarCaracteristica(FeatureDTO featureDTO){
        Feature feature = mapper.convertValue(featureDTO, Feature.class);
        return caracteristicaRepository.save(feature);
    }

    @Override
    public Feature crearCaracteristica(FeatureDTO featureDTO) {
        return guardarCaracteristica(featureDTO);
    }

    @Override
    public FeatureDTO listarCaracteristica(Integer id) {
        return null;
    }

    @Override
    public Feature editarCaracteristica(FeatureDTO featureDTO) {
        return guardarCaracteristica(featureDTO);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        caracteristicaRepository.deleteById(id);
    }

    @Override
    public List<FeatureDTO> listarCaracteristicas() {
        List<Feature> features = caracteristicaRepository.findAll();
        List<FeatureDTO> caracteristicasDTO = new ArrayList<>();

        for(Feature feature : features){
            caracteristicasDTO.add(mapper.convertValue(feature, FeatureDTO.class));
        }
        caracteristicasDTO .sort(Comparator.comparing(FeatureDTO::getId)); //                                                                                                                      CategoryDTO
        return caracteristicasDTO;
    }
}
