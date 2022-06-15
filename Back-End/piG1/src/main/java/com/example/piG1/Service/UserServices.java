package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;
import com.example.piG1.Model.DTO.ProductDTO.ProductCompliteDTO;
import com.example.piG1.Model.DTO.UserDTO.UserBasicDTO;
import com.example.piG1.Model.Entity.*;
import com.example.piG1.Repository.IRoleRepository;
import com.example.piG1.Repository.IUserRepository;
import com.example.piG1.Service.IService.IProductServices;
import com.example.piG1.Service.IService.IUserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Log4j
@Service
public class UserServices implements IUserServices {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IProductServices productService;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserBasicDTO save(UserBasicDTO userBasicDTO) {
        User user = mapper.convertValue(userBasicDTO,User.class);
        Optional <Role> role = roleRepository.findById(userBasicDTO.getRoleId());
        user.setRole(role.get());
        //Encriptamos password
        String encodedPassword =this.bCryptPasswordEncoder.encode(user.getPassword());
        //Que se establezca password encriptada
        user.setPassword(encodedPassword);
        user = userRepository.save(user);
        return mapper.convertValue(user, UserBasicDTO.class);
    }

    @Override
    public UserBasicDTO findById(Integer id) throws ResourceNotFoundException {
        User user = checkId(id);
        UserBasicDTO userBasicDTO = mapper.convertValue(user, UserBasicDTO.class);
        return  userBasicDTO;
    }

    @Override
    public void delete(Integer id) throws ResourceNotFoundException {
        checkId(id);
        userRepository.deleteById(id);
        log.info("Se elimino el producto correctamente con el id("+id+")");
    }

    @Override
    public List<UserBasicDTO> findAll() {
        List<UserBasicDTO>  userBasicDTO= new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user: users){
            UserBasicDTO userBasicDTO1 = mapper.convertValue(user, UserBasicDTO.class);
        }
        userBasicDTO .sort(Comparator.comparing(UserBasicDTO::getId)); //
        log.info("La busqueda fue exitosa: "+ userBasicDTO);
        return userBasicDTO;
    }

    @Override
    public UserBasicDTO findByMail(String mail) {
        //raro, falta comprobar pero no se como, quizas el front ah re
        User user = userRepository.findUserByMail(mail);
        return  mapper.convertValue(user, UserBasicDTO.class);
    }

    @Override
    public String getEmailUserSession() {
        Authentication user = SecurityContextHolder.getContext().getAuthentication();
        return user.getName();
    }

    public User findUserModelByMail(String mail) {
        return  userRepository.findUserByMail(mail);
    }
//    @Override
//    public void bookMark(Integer productId) throws ResourceNotFoundException {
//        String userName = getEmailUserSession();
//        //me dice q cambie a string pero yo necesito la clase
//        User user = findUserModelByMail.(username);
//        List <Product> favorites = user.getFavorites();
//        ProductFullDTO productFullDTO = productService.findById(productId);
//        Product product = mapper.convertValue(productFullDTO, Product.class);
//        if (favorites.contains(product)){
//            favorites.remove(product);
//        }else{
//            favorites.add(product);
//        }
//        user.setFavorites(favorites);
//        userRepository.save(user);
//    }
//
//    @Override
//    public List<Product> getFavorites() {
//        String userName = getEmailUserSession();
//        User user = findUserModelByMail(userName);
//        return user.getFavorites();
//    }

    @Override
    public User checkId(Integer id) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException(messageError + id);
        }
        return user.get();
    }
}

