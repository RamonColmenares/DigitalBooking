package com.example.piG1.Service.IService;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.PolicyDTO;
import com.example.piG1.Model.DTO.TypeOfPolicyAddPoliciesDTO;
import com.example.piG1.Model.DTO.TypeOfPolicyDTO;
import com.example.piG1.Model.Entity.Policy;
import com.example.piG1.Service.ICheckId;

import java.util.List;

public interface IPolicyServices extends  ICheckId<Policy> {
    void savePolicies(List<Policy> policiesList);
    PolicyDTO save(PolicyDTO policyDTO);
    PolicyDTO findById(Integer id) throws ResourceNotFoundException;
    List<PolicyDTO> findAll();
    void delete(Integer id) throws ResourceNotFoundException;
}
