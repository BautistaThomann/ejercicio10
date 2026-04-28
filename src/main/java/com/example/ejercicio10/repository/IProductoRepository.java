package com.example.ejercicio10.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ejercicio10.models.Producto;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {
} 
