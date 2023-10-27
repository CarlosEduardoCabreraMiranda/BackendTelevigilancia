package com.example.TvBackend.New.pojo;

import lombok.Data;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;


@NamedQuery(name="Producto.findProductoByCodigo_producto", query = "select p from Producto p where p.codigo=:codigo")

@Entity
@DynamicUpdate
@DynamicInsert
@Data
@Table (name = "producto")
public class Producto implements Serializable {
    private static final long serialversionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "costo")
    private String costo;

    @Column(name = "tipo")
    private String tipo;

    public Producto(){}

    public Producto(Integer id, String codigo, String nombre, String costo, String tipo) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
    }
}
