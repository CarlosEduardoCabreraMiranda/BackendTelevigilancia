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
    public Optional<Cliente> ConseguirClientePorId(int id) {
        Optional<Cliente> cliente = clienteDao.findById(id);
        if (cliente.isPresent()) {
            Cliente clienteActualizado = new Cliente();
            clienteActualizado.setPrimerNombre(cliente.get().getPrimerNombre());
            clienteActualizado.setSegundoNombre(cliente.get().getSegundoNombre());
            clienteActualizado.setPrimerApellido(cliente.get().getPrimerApellido());
            clienteActualizado.setPrimerApellido(cliente.get().getSegundoApellido());
            clienteActualizado.setFechaNacimiento(cliente.get().getFechaNacimiento());
            clienteActualizado.setTelefono(cliente.get().getTelefono());
            clienteActualizado.setDireccion(cliente.get().getDireccion());
            clienteActualizado.setPassword(cliente.get().getPassword());
            clienteActualizado.setOcupacion(cliente.get().getOcupacion());
            return cliente;
        } else {
            throw new NoSuchElementException("No se encontró un producto con el ID especificado");
        }
    }

    @Override
    public ResponseEntity<String> registrarCliente(Map<String, String> mapCliente) {
        try {
            if (mapCliente.containsKey("identificacion") && mapCliente.containsKey("primer_nombre") &&
                    mapCliente.containsKey("primer_apellido") && mapCliente.containsKey("fecha_nacimiento") &&
                    mapCliente.containsKey("telefono") && mapCliente.containsKey("direccion") &&
                    mapCliente.containsKey("usuario") && mapCliente.containsKey("password") &&
                    mapCliente.containsKey("ocupacion") && mapCliente.containsKey("estado") ) {
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
        cliente.setSegundoApellido(mapCliente.get("segundo_nombre"));
        cliente.setFechaNacimiento(mapCliente.get("fecha_nacimiento"));
        cliente.setTelefono(mapCliente.get("telefono"));
        cliente.setDireccion(mapCliente.get("direccion"));
        cliente.setUsuario(mapCliente.get("usuario"));
        cliente.setPassword(mapCliente.get("password"));
        cliente.setOcupacion(mapCliente.get("ocupacion"));
        cliente.setEstado(Boolean.parseBoolean(mapCliente.get("estado")));
        return cliente;
    }
}
