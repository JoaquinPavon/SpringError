package com.example.TPFinal.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Stock")
    private int stock;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Precio")
    private double precio;

    @ManyToMany(mappedBy = "productos",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ComprobanteVenta> comprobantesVenta = new ArrayList<>();
}
