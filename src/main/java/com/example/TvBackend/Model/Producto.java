package com.example.TvBackend.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@NamedQuery(name="Producto.findProductByReference",query ="select p from Producto p where p.referencia=:referencia")
@Data
@Entity
@Table (name = "producto")
public class Producto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoProducto;
    private String nombre;
    private String marca;
    private float costo;
    private String caracteristicas;
    private String garantia;
    private String referencia;

    public Producto(){}

    public Producto(int codigoProducto, String nombre, String marca, float costo, String caracteristicas, String garantia, String referencia) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.caracteristicas = caracteristicas;
        this.garantia = garantia;
        this.referencia = referencia;
    }
}
