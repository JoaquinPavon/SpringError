package com.example.TPFinal.Controllers;

import com.example.TPFinal.Models.Cliente;
import com.example.TPFinal.Models.ComprobanteVenta;
import com.example.TPFinal.Models.Producto;
import com.example.TPFinal.Repositorys.ClienteRepositorio;
import com.example.TPFinal.Repositorys.ComprobanteVentaRepositorio;
import com.example.TPFinal.Servicios.ComprobanteVentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ComprobanteVentaControlador {

@Autowired
ComprobanteVentaRepositorio repository;
@Autowired
ClienteRepositorio clienteRepositorio;
@Autowired
ComprobanteVentaServicio comprobanteVentaServicio;


    // GET ALL
    @GetMapping("comprobantes")
    public List<ComprobanteVenta> getComprobantes(){
        return repository.findAll();
    }

    // GET POR ID
    @GetMapping("/comprobante/{id}")
    public ComprobanteVenta getComprobante(@PathVariable long id) {
        return comprobanteVentaServicio.getComprobanteById(id);
    }

    // POST - Cargando id de producto y cliente
    @PostMapping("/comprobante/alta")
    public String saveComprobante(@RequestBody ComprobanteVenta comprobanteVenta) {
        return comprobanteVentaServicio.saveComprobante(comprobanteVenta);
    }

    // AGREGAR PRODUCTO A COMPROBANTE
    @PutMapping("/comprobante/add/{id}")
    public String addProducto(@PathVariable long id, @RequestBody Producto producto) {
        return comprobanteVentaServicio.addProductoToComprobante(id, producto);
    }

    // DELETE
    @DeleteMapping("/comprobante/baja/{id}")
    public String deleteComprobante(@PathVariable Long id) {
        return comprobanteVentaServicio.deleteComprobanteById(id);
    }

// GET PRECIO COMPROBANTE
    @GetMapping("/precioComprobante/{id}")
    public double getTotalPriceById(@PathVariable long id) {
        return comprobanteVentaServicio.getTotalPriceById(id);
    }

    // TRAER TODOS LOS PRODUCTOS DE UN COMPROBANTE
    @GetMapping("/comprobante/productos/{id}")
    public List<Producto> getProductosById(@PathVariable long id) {
        return comprobanteVentaServicio.getProductosById(id);
    }


    @DeleteMapping("/comprobantes/borrarTodos")
    public String deleteAllComprobantes() {
        return comprobanteVentaServicio.deleteAllComprobantes();
    }

}
