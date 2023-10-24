package com.example.TvBackend.Model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Persona {
    @Id
    private int identificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String fechaNacimiento;
    @ManyToOne
    private Direccion direccion;
    private String telefono;
    private String email;

    public Persona(){}

    public Persona(int identificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String telefono, String email) {
        this.identificacion = identificacion;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;

        this.telefono = telefono;
        this.email = email;
    }

}