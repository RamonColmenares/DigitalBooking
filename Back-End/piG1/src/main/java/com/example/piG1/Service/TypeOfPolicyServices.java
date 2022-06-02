package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.Product;
import com.example.piG1.Model.ProductDTO;
import com.example.piG1.Model.TypeOfPolicy;
import com.example.piG1.Model.TypeOfPolicyDTO;
import com.example.piG1.Repository.ICategoryRepository;
import com.example.piG1.Repository.ITypeOfPolicyRepository;
import com.example.piG1.Service.IService.ITypeOfPolicyServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Service
public class TypeOfPolicyServices implements ITypeOfPolicyServices {
    protected final static Logger logger = Logger.getLogger(TypeOfPolicyServices.class);

    @Autowired
    public ITypeOfPolicyRepository typeOfPolicyRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public TypeOfPolicy checkId(Integer id) throws ResourceNotFoundException {
        Optional<TypeOfPolicy> typeOfPolicy = typeOfPolicyRepository.findById(id);
        if (typeOfPolicy.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return typeOfPolicy.get();
    }

    @Override
    public TypeOfPolicyDTO save(TypeOfPolicyDTO typeOfPolicyDTO) {
        TypeOfPolicy typeOfPolicy = mapper.convertValue(typeOfPolicyDTO, TypeOfPolicy.class);
        typeOfPolicyRepository.save(typeOfPolicy);
        if (typeOfPolicyDTO.getId() == null){
            typeOfPolicy.setId(typeOfPolicy.getId());
            logger.info("Politica registrada correctamente: "+ typeOfPolicyDTO);
        }else{
            logger.info("Politica actualizada correctamente: "+ typeOfPolicyDTO);
        }
        return typeOfPolicyDTO;
    }

    @Override
    public TypeOfPolicyDTO findById(Integer id) throws ResourceNotFoundException {
        TypeOfPolicy typeOfPolicy = checkId(id);
        TypeOfPolicyDTO typeOfPolicyDTO = mapper.convertValue(typeOfPolicy, TypeOfPolicyDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return typeOfPolicyDTO;
    }

    @Override
    public List<TypeOfPolicyDTO> findAll() {
        List<TypeOfPolicyDTO> typeOfPoliciesDTO= new ArrayList<>();
        List<TypeOfPolicy> typeOfPolicies = typeOfPolicyRepository.findAll();
        for(TypeOfPolicy typeOfPolicy: typeOfPolicies){
            typeOfPoliciesDTO.add(mapper.convertValue(typeOfPolicy, TypeOfPolicyDTO.class));
        }
        typeOfPoliciesDTO .sort(Comparator.comparing(TypeOfPolicyDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ typeOfPoliciesDTO);
        return typeOfPoliciesDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        typeOfPolicyRepository.deleteById(id);
        logger.info("Se elimino la politica correctamente con el id("+id+")");
    }
}
