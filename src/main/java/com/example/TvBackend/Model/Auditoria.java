package com.example.TvBackend.Model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public abstract class Auditoria {
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private LocalDateTime fechaEliminacion;
    private Boolean estado;
    public Auditoria(){}

    public Auditoria(LocalDateTime fechaCreacion, LocalDateTime fechaModificacion, LocalDateTime fechaEliminacion, Boolean estado) {
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.fechaEliminacion = fechaEliminacion;
        this.estado = estado;
    }
}
