package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Cliente;
import com.example.TvBackend.Repository.ClienteRepository;
import com.example.TvBackend.interfaceService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClienteService implements IClienteService {
    @Autowired
    ClienteRepository clienteService;
    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>)clienteService.findAll();
    }

    @Override
    public Optional<Cliente> ConseguirClientePorId(int id) {
        return clienteService.findById(id);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteService.save(cliente);
    }

    @Override
    public void deleteCliente(int id) {

    }
}
