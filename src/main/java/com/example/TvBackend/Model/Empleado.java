package com.example.TvBackend.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;
@Data
@Entity
@Table(name = "empleado")
public class Empleado extends Persona {
    private String fechaIngreso;
    private String cargo;
    private float salario;
    public Empleado() {}
    public Empleado(String fechaIngreso, String cargo, float salario) {
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.salario = salario;
    }
}