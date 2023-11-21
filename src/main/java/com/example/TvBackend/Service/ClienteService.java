package com.example.TvBackend.Service;

import com.example.TvBackend.Model.Cliente;
import com.example.TvBackend.Repository.ClienteRepository;
import com.example.TvBackend.Utilidades.Utilidades;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Optional<Cliente> ConseguirClientePorId(int id,Cliente clien) {
        Optional<Cliente> cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            Cliente clienteActualizado = new Cliente();
            clienteActualizado.setIdentificacion(id);
            clienteActualizado.setPrimerNombre(clien.getPrimerNombre());
            clienteActualizado.setSegundoNombre(clien.getSegundoNombre());
            clienteActualizado.setPrimerApellido(clien.getPrimerApellido());
            clienteActualizado.setSegundoApellido(clien.getSegundoApellido());
            clienteActualizado.setFechaNacimiento(clien.getFechaNacimiento());
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
    public ResponseEntity<String> registrarCliente(Map<String, String> mapCliente) {
        try {
            if (mapCliente.containsKey("identificacion") && mapCliente.containsKey("primer_nombre") &&
                    mapCliente.containsKey("primer_apellido") && mapCliente.containsKey("fecha_nacimiento") &&
                    mapCliente.containsKey("telefono") && mapCliente.containsKey("direccion") &&
                    mapCliente.containsKey("usuario") && mapCliente.containsKey("password") &&
                    mapCliente.containsKey("ocupacion") ) {
                Cliente cliente = clienteDao.obtenerPorUsuario("usuario");
                if (Objects.isNull(cliente)) {
                    clienteDao.save(getClienteFromMap(mapCliente));
                    return Utilidades.getResponseEntity("Registro exitoso!", HttpStatus.OK);
                } else {
                    return Utilidades.getResponseEntity("Email ya existe!", HttpStatus.BAD_REQUEST);
                }
            } else {
                return Utilidades.getResponseEntity(Constantes.DATO_INVALIDO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Utilidades.getResponseEntity(Constantes.ALGO_PASO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public void deleteCliente(int id) {
        clienteDao.deleteById(id);
    }

    public Cliente getClienteFromMap(Map<String, String> mapCliente) {
        Cliente cliente = new Cliente();
        cliente.setIdentificacion(Integer.parseInt(mapCliente.get("identificacion")));
        cliente.setPrimerNombre(mapCliente.get("primer_nombre"));
        cliente.setSegundoNombre(mapCliente.get("segundo_nombre"));
        cliente.setPrimerApellido(mapCliente.get("primer_apellido"));
        cliente.setSegundoApellido(mapCliente.get("segundo_apellido"));
        cliente.setFechaNacimiento(mapCliente.get("fecha_nacimiento"));
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
