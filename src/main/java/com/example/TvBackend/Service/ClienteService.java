package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Cliente;
import com.example.TvBackend.Repository.ClienteRepository;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    ClienteRepository clienteDao;

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Optional<Cliente> conseguirPorId(int id){
        Optional<Cliente> cliente = clienteDao.findById(id);
        if(!cliente.isPresent()){
            throw new NoSuchElementException("No se encontró el cliente con el ID especificado");
        }
        return cliente;
    }

    @Override
    public Optional<Cliente> actualizarCliente(int id,Cliente clien) {
        Optional<Cliente> cliente = conseguirPorId(id);
        if (cliente.isPresent()) {
            Cliente clienteActualizado = new Cliente();
            clienteActualizado.setId(id);
            clienteActualizado.setIdentificacion(clien.getIdentificacion());
            clienteActualizado.setPrimer_nombre(clien.getPrimer_nombre());
            clienteActualizado.setSegundo_nombre(clien.getSegundo_nombre());
            clienteActualizado.setPrimer_apellido(clien.getPrimer_apellido());
            clienteActualizado.setSegundo_apellido(clien.getSegundo_apellido());
            clienteActualizado.setFecha_nacimiento(clien.getFecha_nacimiento());
            clienteActualizado.setTelefono(clien.getTelefono());
            clienteActualizado.setDireccion(clien.getDireccion());
            clienteActualizado.setUsuario(cliente.get().getUsuario());
            clienteActualizado.setPassword(clien.getPassword());
            clienteActualizado.setOcupacion(clien.getOcupacion());
            clienteActualizado.setFechaCreacion(cliente.get().getFechaCreacion());
            clienteActualizado.setEstado(cliente.get().getEstado());
            clienteActualizado.setFechaModificacion(LocalDateTime.now());
            clienteDao.save(clienteActualizado);
            return cliente;
        } else {
            throw new NoSuchElementException("No se encontró el cliente con el ID especificado");
        }
    }

    @Override
    public Cliente registrarCliente(Map<String, String> mapCliente) {
        try {
            if (validarInformacion(mapCliente)) {
                    return clienteDao.save(getClienteFromMap(mapCliente));
            } else {
                throw new NoSuchElementException("Datos inválidos." + HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new NoSuchElementException(Constantes.ALGO_PASO_MAL + HttpStatus.BAD_REQUEST);
    }

    @Override
    public void deleteCliente(int id) {
        clienteDao.deleteById(id);
    }

    public boolean validarInformacion(Map<String,String> mapCliente){
        if(mapCliente.containsKey("identificacion") && mapCliente.containsKey("primer_nombre") &&
                mapCliente.containsKey("primer_apellido") && mapCliente.containsKey("fecha_nacimiento") &&
                mapCliente.containsKey("telefono") && mapCliente.containsKey("direccion") &&
                mapCliente.containsKey("usuario") && mapCliente.containsKey("password") &&
                mapCliente.containsKey("ocupacion") ){
            return true;
        }
        return false;
    }

    public Cliente getClienteFromMap(Map<String, String> mapCliente) {
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(mapCliente.get("identificacion"));
        cliente.setPrimer_nombre(mapCliente.get("primer_nombre"));
        cliente.setSegundo_nombre(mapCliente.get("segundo_nombre"));
        cliente.setPrimer_apellido(mapCliente.get("primer_apellido"));
        cliente.setSegundo_apellido(mapCliente.get("segundo_apellido"));
        cliente.setFecha_nacimiento(mapCliente.get("fecha_nacimiento"));
        cliente.setTelefono(mapCliente.get("telefono"));
        cliente.setDireccion(mapCliente.get("direccion"));
        cliente.setUsuario(mapCliente.get("usuario"));
        cliente.setPassword(mapCliente.get("password"));
        cliente.setOcupacion(mapCliente.get("ocupacion"));
        cliente.setEstado(true);
        cliente.setFechaCreacion(LocalDateTime.now());
        return cliente;
    }
}
