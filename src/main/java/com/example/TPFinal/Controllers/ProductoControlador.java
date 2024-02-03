package com.example.TPFinal.Controllers;


import com.example.TPFinal.Models.Cliente;
import com.example.TPFinal.Models.Producto;
import com.example.TPFinal.Repositorys.ProductoRepositorio;
import com.example.TPFinal.Servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoControlador {

    @Autowired
    ProductoRepositorio repository;

    @Autowired
    ProductoServicio productoServicio;

    // GET ALL
    @GetMapping("productos")
    public List<Producto> getProductos(){
        return repository.findAll();
    }

    @GetMapping("/producto/{id}")
    public Producto getProductoById(@PathVariable long id) {
        return productoServicio.getProductoById(id);
    }

    // POST
    @PostMapping("/producto/alta")
    public String saveProducto(@RequestBody Producto producto) {
        return productoServicio.saveProducto(producto);
    }

    // PUT
    @PutMapping("/producto/modificar/{id}")
    public String updateProducto(@PathVariable long id, @RequestBody Producto producto) {
        return productoServicio.updateProducto(id, producto);
    }

    // DELETE ID
    @DeleteMapping("/producto/baja/{id}")
    public String deleteProductoById(@PathVariable Long id) {
        return productoServicio.deleteProductoById(id);
    }


    @DeleteMapping("/productos/borrarTodos")
    public String deleteAllProductos() {
        return productoServicio.deleteAllProductos();
    }


}
