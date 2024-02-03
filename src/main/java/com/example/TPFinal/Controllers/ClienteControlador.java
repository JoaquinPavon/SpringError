package com.example.TPFinal.Controllers;
import com.example.TPFinal.Models.Cliente;
import com.example.TPFinal.Repositorys.ClienteRepositorio;
import com.example.TPFinal.Servicios.ClienteServicio;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteControlador {

    @Autowired
     ClienteRepositorio repository;

    @Autowired
    ClienteServicio clienteServicio;

    // GET ALL
    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    // GET POR ID
    @GetMapping("/cliente/{id}")
    public Cliente getClienteById(@PathVariable long id) {
        return clienteServicio.getClienteById(id);
    }

    // POST
    @PostMapping("/cliente/alta")
    public String saveCliente(@RequestBody Cliente cliente) {
        return clienteServicio.saveCliente(cliente);
    }

    // PUT
    @PutMapping("/cliente/modificar/{id}")
    public String updateCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        return clienteServicio.updateCliente(id, cliente);
    }


    // DELETE
    @DeleteMapping("/cliente/baja/{id}")
    public String deleteClienteById(@PathVariable Long id) {
        return clienteServicio.deleteClienteById(id);
    }

    // DELETE ALL
    @DeleteMapping("/clientes/borrarTodos")
    public String deleteAllClientes() {
        return clienteServicio.deleteAllClientes();
    }

}
