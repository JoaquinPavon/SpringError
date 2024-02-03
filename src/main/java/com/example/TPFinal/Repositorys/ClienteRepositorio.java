package com.example.TPFinal.Repositorys;

import com.example.TPFinal.Models.Cliente;
import jakarta.websocket.ClientEndpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long> {


}
