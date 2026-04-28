package com.example.ejercicio10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejercicio10.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

} 
