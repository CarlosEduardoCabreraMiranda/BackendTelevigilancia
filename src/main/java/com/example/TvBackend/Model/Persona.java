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
    @Column(name = "primer_nombre")
    private String primer_nombre;
    @Column(name = "segundo_nombre")
    private String segundo_nombre;
    @Column(name = "primer_apellido")
    private String primer_apellido;
    @Column(name = "segundo_apellido")
    private String segundo_apellido;
    @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String usuario;
    private String password;


    public Persona(){}
    public Persona(int identificacion, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, Boolean estado, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String fecha_nacimiento, String direccion, String telefono, String usuario, String password) {
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
    }


}