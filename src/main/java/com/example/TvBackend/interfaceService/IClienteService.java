package com.example.TvBackend.interfaceService;

import com.example.TvBackend.Model.Cliente;
import com.example.TvBackend.Model.Venta;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public List<Cliente> obtenerClientes();
    public Optional<Cliente> ConseguirClientePorId(int id);
    public void saveCliente(Cliente cliente);
    public void deleteCliente(int id);
}
