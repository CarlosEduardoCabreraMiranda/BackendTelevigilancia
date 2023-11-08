package com.example.TvBackend.Controller;

import com.example.TvBackend.Model.Empleado;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/televigilancia")
public class EmpleadoController {
    @Autowired
    IEmpleadoService empleadoService;
    @GetMapping("/getEmpleados")
    public List<Empleado> index(){
        return empleadoService.ConseguirEmpleados();
    }
    @PostMapping("/saveEmpleado")
    public ResponseEntity<String> saveEmpleado(@RequestBody(required = true) Map<String, String> requestMap){
        try{
            return empleadoService.registrarEmpleado(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/actualizarEmpleado/{id}")
    public Optional<Empleado> actualizarEmpleado(@PathVariable int id){
        return empleadoService.ConseguirUnoPorId(id);
    }
    @DeleteMapping("/eliminarEmpleado/{id}")
    public void eliminarEmpleado(int id){
        empleadoService.deleteEmpleado(id);
    }

}
