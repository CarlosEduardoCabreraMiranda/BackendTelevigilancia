package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Venta;
import com.example.TvBackend.Repository.VentaRepository;
import com.example.TvBackend.interfaceService.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService implements IVentaService {
    @Autowired
    VentaRepository ventaService;

    @Override
    public List<Venta> obtenerVentas() {
        return (List<Venta>) ventaService.findAll();
    }

    @Override
    public Optional<Venta> ConseguirVentaPorId(int id) {
        return ventaService.findById(id);
    }

    @Override
    public void guardarVenta(Venta venta) {
        ventaService.save(venta);
    }

    @Override
    public void deleteVenta(int id) {
        ventaService.deleteById(id);
    }
}
