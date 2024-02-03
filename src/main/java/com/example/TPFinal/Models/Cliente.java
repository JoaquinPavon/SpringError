package com.example.TPFinal.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String apellido;

    @Column(name = "DNI")
    @JsonProperty("DNI")
    private String DNI;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ComprobanteVenta> comprobantesVentas = new ArrayList<>();

    public Cliente() {
    }

    public void addComprobante(ComprobanteVenta c){
        if(!this.comprobantesVentas.contains(c)){
            comprobantesVentas.add(c);
        }
    }
}
