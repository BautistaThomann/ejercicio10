package com.example.ejercicio10.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejercicio10.models.Producto;
import com.example.ejercicio10.repository.IProductoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final IProductoRepository productoRepository;

    public ProductoController(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    @GetMapping
    public Iterable<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/paginated")
    public Page<Producto> listaProductosPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return productoRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/buscar")
    public Page<Producto> buscarPorPrecio(
            @RequestParam Double precio,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return productoRepository.findByPrecio(precio, PageRequest.of(page, size));
    }
}