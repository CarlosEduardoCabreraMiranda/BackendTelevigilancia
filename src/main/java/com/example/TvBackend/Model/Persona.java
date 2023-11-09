package com.example.TvBackend.Model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona{
    @Id
    private int identificacion;
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

    public Persona(int identificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String direccion, String telefono, String usuario, String password) {
        this.identificacion = identificacion;
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