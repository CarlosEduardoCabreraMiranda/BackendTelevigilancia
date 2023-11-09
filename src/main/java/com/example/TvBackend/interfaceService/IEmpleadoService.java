package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Empleado;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = {"com.example.TvBackend"})
public interface IEmpleadoService {

    public List<Empleado> ConseguirEmpleados();
    public ResponseEntity<String> actualizarEmpleado(int id, Map<String,String> entidad);
    public ResponseEntity<String> registrarEmpleado (Map<String, String> requestMap);

    public void deleteEmpleado(int id);

}
