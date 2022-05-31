package com.example.piG1.Repository;

import com.example.piG1.Model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFeatureRepository extends JpaRepository<Feature,Integer> {
}
