package com.example.piG1.Service.IService;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.TypeOfPolicyDTO.TypeOfPolicyAddPoliciesDTO;
import com.example.piG1.Model.DTO.TypeOfPolicyDTO.TypeOfPolicyDTO;
import com.example.piG1.Model.DTO.UserDTO.UserBasicDTO;
import com.example.piG1.Model.Entity.Product;
import com.example.piG1.Model.Entity.User;
import com.example.piG1.Service.ICheckId;

import java.util.List;

public interface IUserServices extends ICheckId<User> {
     UserBasicDTO save (UserBasicDTO userBasicDTO);
     UserBasicDTO findById (Integer id) throws ResourceNotFoundException;
     void delete (Integer id) throws ResourceNotFoundException;
     List <UserBasicDTO> findAll ();
     UserBasicDTO findByMail (String mail);
     String getEmailUserSession();

//     void bookMark (Integer productId) throws ResourceNotFoundException;
//     List<Product> getFavorites();
}
