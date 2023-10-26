package com.example.TvBackend.Model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

//@Setter
//@Getter
@Data
@Entity
@Table (name="empleado")
public class Empleado extends Persona {
        private  String cargo;
        public Empleado() {}

        public Empleado(String cargo) {
            this.cargo = cargo;
        }


}