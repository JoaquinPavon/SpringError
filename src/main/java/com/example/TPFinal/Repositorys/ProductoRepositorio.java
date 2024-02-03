package com.example.TPFinal.Repositorys;

import com.example.TPFinal.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto,Long> {
}
