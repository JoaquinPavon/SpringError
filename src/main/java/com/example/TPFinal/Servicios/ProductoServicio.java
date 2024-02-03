package com.example.TPFinal.Servicios;

import com.example.TPFinal.Models.Producto;
import com.example.TPFinal.Repositorys.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServicio {


    @Autowired
    ProductoRepositorio productoRepositorio;


    public Producto getProductoById(long productoId) {
        Optional<Producto> optionalProducto = productoRepositorio.findById(productoId);
        return optionalProducto.orElse(null);
    }


    public String saveProducto(Producto producto) {
        productoRepositorio.save(producto);
        return "Guardado";
    }


    public String updateProducto(long id, Producto producto) {
        Optional<Producto> optionalProducto = productoRepositorio.findById(id);
        if (optionalProducto.isPresent()) {
            Producto update = optionalProducto.get();
            update.setNombre(producto.getNombre());
            update.setStock(producto.getStock());
            update.setPrecio(producto.getPrecio());
            productoRepositorio.save(update);
            return "Actualizado";
        } else {
            return "Producto no encontrado";
        }
    }

    public String deleteProductoById(Long productoId) {
        Optional<Producto> optionalProducto = productoRepositorio.findById(productoId);
        if (optionalProducto.isPresent()) {
            productoRepositorio.deleteById(productoId);
            return "Eliminado";
        } else {
            return "Producto no encontrado";
        }
    }

    public String deleteAllProductos() {
        productoRepositorio.deleteAll();
        return "Eliminados";
    }
}
