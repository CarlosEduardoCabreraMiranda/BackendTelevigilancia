package com.example.TvBackend.Model;

import lombok.Data;
import jakarta.persistence.*;

import java.util.Date;
@NamedQuery(name = "Empleado.empleadoPorUsuario",query="select e from Empleado as e where e.usuario=:usuario")
@Data
@Entity
@Table(name = "empleado")
public class Empleado extends Persona {
    @Column(name = "fecha_ingreso")
    private String fecha_ingreso;
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "salario")
    private float salario;
    public Empleado() {}
    public Empleado(String fecha_ingreso, String cargo, float salario) {
        this.fecha_ingreso = fecha_ingreso;
        this.cargo = cargo;
        this.salario = salario;
    }
}