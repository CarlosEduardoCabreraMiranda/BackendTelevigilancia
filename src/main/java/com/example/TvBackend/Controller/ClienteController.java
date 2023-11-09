package com.example.TvBackend.Controller;


import com.example.TvBackend.Model.Cliente;
import com.example.TvBackend.Model.Empleado;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/televigilancia")
public class ClienteController {
    @Autowired
    IClienteService clienteService;

    @GetMapping("/getClientes")
    public List<Cliente> index(){
        return clienteService.obtenerClientes();
    }
    @PostMapping("/saveCLiente")
    public ResponseEntity<String> saveEmpleado(@RequestBody(required = true) Map<String, String> requestMap){
        try{
            return clienteService.registrarCliente(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PutMapping("/actualizarCliente/{id}")
    public Optional<Cliente> actualizarEmpleado(@PathVariable int id){
        return clienteService.ConseguirClientePorId(id);
    }
    @DeleteMapping("/eliminarCliente/{id}")
    public void eliminarEmpleado(int id){
        clienteService.deleteCliente(id);
    }
}
