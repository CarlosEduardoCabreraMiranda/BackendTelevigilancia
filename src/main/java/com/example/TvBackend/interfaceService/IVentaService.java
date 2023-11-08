package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Venta;

import java.util.List;
import java.util.Optional;

public interface IVentaService {
    public List<Venta> obtenerVentas();
    public Optional<Venta> ConseguirVentaPorId(int id);
    public void guardarVenta(Venta venta);
    public void deleteVenta(int id);
}
