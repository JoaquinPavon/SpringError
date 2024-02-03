package com.example.TPFinal.Servicios;

import com.example.TPFinal.Models.Cliente;
import com.example.TPFinal.Repositorys.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    ClienteRepositorio clienteRepositorio;


    public Cliente getClienteById(long clienteId) {
        Optional<Cliente> optionalCliente = clienteRepositorio.findById(clienteId);
        return optionalCliente.orElse(null);
    }


    public String saveCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
        return "Guardado";
    }


    public String updateCliente(long id, Cliente cliente) {
        Optional<Cliente> optionalCliente = clienteRepositorio.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente update = optionalCliente.get();
            update.setApellido(cliente.getApellido());
            update.setNombre(cliente.getNombre());
            update.setDNI(cliente.getDNI());
            clienteRepositorio.save(update);
            return "Actualizado";
        } else {
            return "Cliente no encontrado";
        }
    }

    public String deleteClienteById(Long clienteId) {
        Optional<Cliente> optionalCliente = clienteRepositorio.findById(clienteId);
        if (optionalCliente.isPresent()) {
            clienteRepositorio.deleteById(clienteId);
            return "Eliminado";
        } else {
            return "Cliente no encontrado";
        }
    }

    public String deleteAllClientes() {
        clienteRepositorio.deleteAll();
        return "Eliminados";
    }



}
