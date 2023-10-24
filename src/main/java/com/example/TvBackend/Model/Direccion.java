package com.example.TvBackend.Model;

import jakarta.persistence.*;

@Entity
@Table(name="direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String nombreCalle;
    private String numeroLocal;

    public Direccion(int id, String nombreCalle, String numeroLocal, String codigoPostal) {
        this.id = id;
        this.nombreCalle = nombreCalle;
        this.numeroLocal = numeroLocal;
        this.codigoPostal = codigoPostal;
    }

    private String codigoPostal;
    public Direccion(){}


}
