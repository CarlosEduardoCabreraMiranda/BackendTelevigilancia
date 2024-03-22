package com.example.TvBackend.Model;

import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "empleado")
public class Empleado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identificacion;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private Boolean estado;
    @Column(name = "primer_nombre")
    private String primer_nombre;
    @Column(name = "segundo_nombre")
    private String segundo_nombre;
    @Column(name = "primer_apellido")
    private String primer_apellido;
    @Column(name = "segundo_apellido")
    private String segundo_apellido;
    @Column(name = "foto",columnDefinition = "LONGTEXT")
    private String foto;
    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String usuario;
    private String password;
    @Column(name = "fecha_ingreso")
    private String fecha_ingreso;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "salario")
    private float salario;
    public Empleado() {}

    public Empleado(Integer id, String identificacion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, Boolean estado, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String fecha_nacimiento, String direccion, String telefono, String usuario, String password, String fecha_ingreso, String cargo, float salario) {
        this.id = id;
        this.identificacion = identificacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.fecha_ingreso = fecha_ingreso;
        this.cargo = cargo;
        this.salario = salario;
    }
}