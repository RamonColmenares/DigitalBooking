package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.PolicyDTO.PolicyDTO;
import com.example.piG1.Model.Entity.Policy;
import com.example.piG1.Repository.IPolicyRepository;
import com.example.piG1.Service.IService.IPolicyServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Service
public class PolicyServices implements IPolicyServices {
    protected final static Logger logger = Logger.getLogger(PolicyServices.class);

    @Autowired
    private IPolicyRepository policyRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Policy checkId(Integer id) throws ResourceNotFoundException {
        Optional<Policy> policy = policyRepository.findById(id);
        if (policy.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return policy.get();
    }

    @Override
    public List<PolicyDTO> findByProductId(Integer id) throws ResourceNotFoundException {
            List<PolicyDTO> policiesDTO = new ArrayList<>();
            List<Policy> policies = policyRepository.findByProductId(id);
            for(Policy policy: policies){
                policiesDTO.add(mapper.convertValue(policy, PolicyDTO.class));
            }
            policiesDTO .sort(Comparator.comparing(PolicyDTO::getId)); //
            logger.info("La busqueda fue exitosa: "+ policiesDTO);
            return policiesDTO;
    }

    @Override
    public void savePolicies(List<Policy>policiesList) {
       policyRepository.saveAll(policiesList);
    }

    @Override
    public PolicyDTO save(PolicyDTO policyDTO) {
        Policy policy = mapper.convertValue(policyDTO, Policy.class);
        policy =  policyRepository.save(policy);
        return mapper.convertValue(policy,PolicyDTO.class);
    }

    @Override
    public PolicyDTO findById(Integer id) throws ResourceNotFoundException {
        Policy policy = checkId(id);
        PolicyDTO policyDTO = mapper.convertValue(policy, PolicyDTO.class);
        logger.info("La busqueda fue exitosa: id " + id);
        return policyDTO;
    }

    @Override
    public List<PolicyDTO> findAll() {
        List<PolicyDTO> policiesDTO = new ArrayList<>();
        List<Policy> policies = policyRepository.findAll();
        for(Policy policy: policies){
            policiesDTO.add(mapper.convertValue(policy, PolicyDTO.class));
        }
        policiesDTO .sort(Comparator.comparing(PolicyDTO::getId)); //
        logger.info("La busqueda fue exitosa: "+ policiesDTO);
        return policiesDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        policyRepository.deleteById(id);
        logger.info("Se elimino la politica correctamente con el id("+id+")");
    }
}
