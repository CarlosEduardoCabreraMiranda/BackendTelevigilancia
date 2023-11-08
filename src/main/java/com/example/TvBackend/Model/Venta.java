package com.example.TvBackend.Model;

import lombok.Data;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @ManyToMany
    private List<Producto> producto;
    private float valorTotal;
    @ManyToOne
    private Cliente cliente;
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Venta() {
    }

    public Venta(int codigo, List<Producto> producto, Cliente cliente, Date fecha) {
        this.codigo = codigo;
        this.producto = producto;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public float calcularValorTotal(List<Producto> productos) {
        for (int i = 0; i < productos.size(); i++) {
            this.valorTotal += productos.get(i).getCosto();
        }
        return valorTotal;
    }
}
