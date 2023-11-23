package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> obtenerClientes();
    public Cliente conseguirPorId(int id);
    public Optional<Cliente> actualizarCliente(int id,Cliente cliente);
    public Cliente registrarCliente(Map<String,String> mapCliente);
    public void deleteCliente(int id);
}
