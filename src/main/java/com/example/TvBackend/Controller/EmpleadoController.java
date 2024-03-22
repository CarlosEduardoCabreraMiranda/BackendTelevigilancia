package com.example.TvBackend.Controller;

import com.example.TvBackend.Model.Empleado;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
//@CrossOrigin(origins={"http://localhost:4200"})
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/televigilancia")
public class EmpleadoController {
    @Autowired
    IEmpleadoService empleadoService;
    @GetMapping("/getEmpleados")
    public List<Empleado> index(){
        return empleadoService.conseguirEmpleados();
    }
    @GetMapping("/getEmpleado/{id}")
    public Empleado getById(@PathVariable int id){
        return empleadoService.conseguirPorId(id);
    }
    @PostMapping("/saveEmpleado")
    public Empleado saveEmpleado(@RequestBody(required = true) Map<String, String> requestMap){
        try{
            return empleadoService.registrarEmpleado(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        throw new NoSuchElementException(Constantes.ALGO_PASO_MAL + HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/updateEmpleado/{id}")
    public Optional<Empleado> actualizarEmpleado(@PathVariable int id, @RequestBody Empleado empleado){
        return empleadoService.actualizarEmpleado(id,empleado);
    }
    @DeleteMapping("/deleteEmpleado/{id}")
    public void eliminarEmpleado(@PathVariable int id){
        empleadoService.deleteEmpleado(id);
    }

}
