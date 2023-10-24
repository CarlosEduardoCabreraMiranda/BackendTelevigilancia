package com.example.TvBackend.Model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter

@Entity
@Table (name ="cotizacion")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int Empleado;
    private String direccion;
    private String diaInstalacion;
    public Cotizacion(){}

    public Cotizacion(int id, int Empleado, String direccion, String diaInstalacion) {
        this.id = id;
        this.Empleado = Empleado;
        this.direccion = direccion;
        this.diaInstalacion = diaInstalacion;
    }
}
