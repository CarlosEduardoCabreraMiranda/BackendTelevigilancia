package com.example.TvBackend.Model;

import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
@Table (name = "producto")
public class Producto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo_producto")
    private int codigo_producto;
    @Column(name="nombre")
    private String nombre;
    @Column(name="foto",columnDefinition = "LONGTEXT")
    private String foto;
    @Column(name="marca")
    private String marca;
    @Column(name="costo")
    private float costo;
    @Column(name="caracteristicas")
    private String caracteristicas;
    @Column(name="garantia")
    private String garantia;
    @Column(name="referencia")
    private String referencia;

    public Producto(){}

    public Producto(int codigo_producto, String nombre, String marca, float costo, String caracteristicas, String garantia, String referencia) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.caracteristicas = caracteristicas;
        this.garantia = garantia;
        this.referencia = referencia;
    }
}
