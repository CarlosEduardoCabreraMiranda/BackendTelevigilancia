package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Empleado;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.example.TvBackend"})
public interface IEmpleadoService {

    public List<Empleado> ConseguirEmpleados();
    public Optional<Empleado> ConseguirUnoPorId(int id);
    public int save (Empleado empleado);
    public void delete(int id);

}
