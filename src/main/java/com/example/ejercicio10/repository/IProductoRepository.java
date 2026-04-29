package com.example.ejercicio10.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.ejercicio10.models.Producto;

@Repository
public interface IProductoRepository extends PagingAndSortingRepository<Producto, Long>, CrudRepository<Producto, Long> {

    Page<Producto> findByPrecio(Double precio, Pageable pageable);
}