package com.example.TvBackend.Model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

//@NamedQuery(name="User.findByEmailId", query = "select u from User u where u.email=:email")


@Entity
@Data
@DynamicUpdate
@DynamicInsert
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