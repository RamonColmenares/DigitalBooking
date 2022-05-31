package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.*;
import com.example.piG1.Repository.IFeatureRepository;
import com.example.piG1.Service.IService.IFeatureServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FeatureServices implements IFeatureServices {
    protected final static Logger logger = Logger.getLogger(FeatureServices.class);

    @Autowired
    private IFeatureRepository featureRepository;
    @Autowired
    private FeatureServices featureServices;

    @Autowired
    ObjectMapper mapper;


    @Override
    public FeatureDTO save(FeatureDTO featureDTO) {
        Feature feature = mapper.convertValue(featureDTO, Feature.class);
        featureRepository.save(feature);
        if (featureDTO.getId() == null){
            featureDTO.setId(feature.getId());
            logger.info("Caracteristica registrada correctamente: "+ featureDTO);
        }else{
            logger.info("Caracteristica actualizada correctamente: "+ featureDTO);
        }
        return featureDTO;
    }

    @Override
    public FeatureDTO findById(Integer id) throws ResourceNotFoundException {
        Feature feature = checkId(id);
        FeatureDTO featureDTO = mapper.convertValue(feature, FeatureDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return featureDTO;
    }

    @Override
    public List<FeatureDTO> findAll() {
        List<FeatureDTO> featuresDTO = new ArrayList<>();
        List<Feature> features = featureRepository.findAll();
        for(Feature feature: features){
            featuresDTO.add(mapper.convertValue(feature, FeatureDTO.class));
        }
        featuresDTO .sort(Comparator.comparing(FeatureDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ featuresDTO);
        return featuresDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        featureRepository.deleteById(id);
        logger.info("Se elimino la caracteristica correctamente con el id("+id+")");
    }

    @Override
    public Feature checkId(Integer id) throws ResourceNotFoundException {
        Optional<Feature> feature = featureRepository.findById(id);
        if (feature.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return feature.get();
    }
}
