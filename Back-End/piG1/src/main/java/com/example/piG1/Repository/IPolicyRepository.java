package com.example.piG1.Repository;
import com.example.piG1.Model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy,Integer> {
}