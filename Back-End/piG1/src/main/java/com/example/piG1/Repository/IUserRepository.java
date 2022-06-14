package com.example.piG1.Repository;

import com.example.piG1.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    @Query("from User u where u.mail = :username")
    User findByUserName(@Param("username") String username);

    //Trae un usuario por mail
    @Query("select u from User u where u.mail like ?1")
    User findUserByMail(String mail);
}
