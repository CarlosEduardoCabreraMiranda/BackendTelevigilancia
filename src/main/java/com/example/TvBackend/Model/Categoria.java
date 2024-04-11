package com.example.TvBackend.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 45, nullable = false, unique = true)
    private String nombre;
    @Column(length = 255, nullable = false)
    private String descripcion;
    public Categoria(){}

    public Categoria(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
