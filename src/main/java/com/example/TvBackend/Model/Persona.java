package com.example.TvBackend.Model;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona{
    @Id
    private int identificacion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private Boolean estado;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String fechaNacimiento;
    private String direccion;
    private String telefono;
    private String usuario;
    private String password;


    public Persona(){}
    public Persona(int identificacion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, Boolean estado, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String direccion, String telefono, String usuario, String password) {
        this.identificacion = identificacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
    }


}