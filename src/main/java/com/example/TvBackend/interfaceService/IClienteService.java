package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> obtenerClientes();
    public Optional<Cliente> ConseguirClientePorId(int id);
    public ResponseEntity<String> registrarCliente(Map<String,String> mapCliente);
    public void deleteCliente(int id);
}
