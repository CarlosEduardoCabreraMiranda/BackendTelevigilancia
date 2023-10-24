package com.example.TvBackend.Service;

//import com.example.tv_Backend.Model.Empleado;
import com.example.TvBackend.Model.Producto;
//import com.example.tv_Backend.Repository.IEmpleado;
import com.example.TvBackend.Repository.IProducto;
//import com.example.tv_Backend.interfaceService.IEmpleadoService;
import com.example.TvBackend.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productoService implements IProductoService {

    @Autowired
    private IProducto productoIfc;

    @Override
    public List<Producto> ConseguirProductos() {return (List<Producto>) productoIfc.findAll();}

    @Override
    public Optional<Producto> ConseguirProductoPorId(int id) {

        return productoIfc.findById(id);
    }

    @Override
    public int savep(Producto prod) {
        int res = 0;
        Producto producto = productoIfc.save(prod);
        if(!producto.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void deletep(int id) {
        productoIfc.deleteById(id);
    }
}
