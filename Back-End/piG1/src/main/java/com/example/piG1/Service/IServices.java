package com.example.piG1.Service;

import com.example.piG1.Exceptions.ResourceNotFoundException;

import java.util.List;

public interface IServices<T>{
    T save(T t);
    T findById(Integer id) throws ResourceNotFoundException;
    List<T> findAll();
    void delete(Integer id) throws ResourceNotFoundException;
}