package com.example.TPFinal.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ComprobanteVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Fecha",updatable = false)
    private LocalDate fecha;

    @PrePersist
    public void prePersist() {
        this.fecha = LocalDate.now();
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable(
            name = "ComprobanteVenta_Producto",
            joinColumns = @JoinColumn(name = "comprobante_venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )

    private List<Producto> productos = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "cliente_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cliente cliente;


    // add Producto
    public void addProducto(Producto p){
            this.productos.add(p);

    }

    public void deleteProducto(Producto p){
        this.productos.remove(p);
    }



}
