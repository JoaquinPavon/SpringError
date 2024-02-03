package com.example.TPFinal.Servicios;

import com.example.TPFinal.Models.Cliente;
import com.example.TPFinal.Models.ComprobanteVenta;
import com.example.TPFinal.Models.Producto;
import com.example.TPFinal.Repositorys.ClienteRepositorio;
import com.example.TPFinal.Repositorys.ComprobanteVentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ComprobanteVentaServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Autowired
    ComprobanteVentaRepositorio comprobanteVentaRepositorio;


    public String addProductoToComprobante(long comprobanteId, Producto producto) {
        Optional<ComprobanteVenta> optionalComprobante = comprobanteVentaRepositorio.findById(comprobanteId);
        if (optionalComprobante.isPresent()) {
            ComprobanteVenta comprobanteVenta = optionalComprobante.get();
            comprobanteVenta.addProducto(producto);
            comprobanteVentaRepositorio.save(comprobanteVenta);
            return "Producto agregado al comprobante";
        } else {
            return "Comprobante inválido";
        }
    }

    public ComprobanteVenta getComprobanteById(long comprobanteId) {
        Optional<ComprobanteVenta> optionalComprobante = comprobanteVentaRepositorio.findById(comprobanteId);
        return optionalComprobante.orElse(null);
    }


    public String saveComprobante(ComprobanteVenta comprobanteVenta) {
        // Asignar el cliente al comprobante (si existe)
        if (comprobanteVenta.getCliente() != null && comprobanteVenta.getCliente().getId() != null) {
            Optional<Cliente> optionalCliente = clienteRepositorio.findById(comprobanteVenta.getCliente().getId());
            optionalCliente.ifPresent(comprobanteVenta::setCliente);
        }

        comprobanteVentaRepositorio.save(comprobanteVenta);
        return "Guardado";
    }

    public String deleteComprobanteById(Long comprobanteId) {
        Optional<ComprobanteVenta> optionalComprobante = comprobanteVentaRepositorio.findById(comprobanteId);
        if (optionalComprobante.isPresent()) {
            comprobanteVentaRepositorio.deleteById(comprobanteId);
            return "Eliminado";
        } else {
            return "Comprobante no encontrado";
        }
    }

    public double getTotalPriceById(long comprobanteId) {
        Optional<ComprobanteVenta> optionalComprobante = comprobanteVentaRepositorio.findById(comprobanteId);
        double resultado = 0;
        for(Producto hijo: optionalComprobante.get().getProductos()){
            resultado+=hijo.getPrecio();
        }
        return resultado;
    }


    public List<Producto> getProductosById(long comprobanteId) {
        Optional<ComprobanteVenta> optionalComprobante = comprobanteVentaRepositorio.findById(comprobanteId);
        return optionalComprobante.map(ComprobanteVenta::getProductos).orElse(Collections.emptyList());
    }

    public String deleteAllComprobantes() {
        comprobanteVentaRepositorio.deleteAll();
        return "Eliminados";
    }
}
