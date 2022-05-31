package com.example.piG1.service.IService;

import com.example.piG1.model.Feature;
import com.example.piG1.model.FeatureDTO;

import java.util.List;

public interface ICaracteristicaService {
    public Feature crearCaracteristica(FeatureDTO featureDTO);
    public FeatureDTO listarCaracteristica(Integer id);
    public Feature editarCaracteristica(FeatureDTO featureDTO);
    public void eliminarCategoria(Integer id);
    public List<FeatureDTO> listarCaracteristicas();

}
