package com.example.TvBackend.Model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cliente")
public class Cliente extends Persona{

    private String ocupacion;
}
