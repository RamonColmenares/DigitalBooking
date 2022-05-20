package com.example.piG1.repository;

import com.example.piG1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//el @repository le sirve pafra HACER MEJOR la inyeccion de dependencias, ya que el framework lo hace automaticamente(a aveces los crea y a veces lo reutiliza)
@Repository
//le tengo que indicar que tipo de objeto va a manipular, y el tipo de dato con el q lo voy a reconocer
public interface ICategoriaRepository extends JpaRepository<Categoria,Integer> {
}
