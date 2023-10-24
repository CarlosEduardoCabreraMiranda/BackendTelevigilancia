package com.example.TvBackend.interfaceService;

//import com.example.tv_Backend.Model.Empleado;
import com.example.TvBackend.Model.Producto;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.example.TvBackend"})
public interface IProductoService {
    public List<Producto> ConseguirProductos();
    public Optional<Producto> ConseguirProductoPorId(int id);
    public int savep (Producto prod);
    public void deletep(int id);
}
