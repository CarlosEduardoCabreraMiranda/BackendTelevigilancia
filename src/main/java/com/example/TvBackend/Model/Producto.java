package com.example.TvBackend.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

//@Getter
//@Setter
@Data
@Entity
@Table (name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codigoProducto;
    private String nombre;
    private float costo;
    private String tipo;

    public Producto(){}

    public Producto(int id, String codigoProducto, String nombre, float costo, String tipo) {
        this.id = id;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
    }
}
