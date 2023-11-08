package com.example.TvBackend.Model;


import jakarta.persistence.*;

import lombok.Data;
@Data
@Entity
@Table(name="cliente")
public class Cliente extends Persona{

    private String ocupacion;
    public Cliente() {}
    public Cliente(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}
