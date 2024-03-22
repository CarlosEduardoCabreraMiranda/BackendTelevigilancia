package com.example.TvBackend.Service;


import com.example.TvBackend.Model.Empleado;
import com.example.TvBackend.Repository.EmpleadoRepository;
import com.example.TvBackend.constantes.Constantes;
import com.example.TvBackend.interfaceService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;


@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoDao;

    @Override
    public List<Empleado> conseguirEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    public Empleado conseguirPorId (int id){
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public Optional<Empleado> actualizarEmpleado(int id,Empleado emp) {
        Optional<Empleado> empleado = empleadoDao.findById(id);
        if (empleado.isPresent()) {
            Empleado empleadoActualizado = new Empleado();
            empleadoActualizado.setId(id);
            empleadoActualizado.setIdentificacion(emp.getIdentificacion());
            empleadoActualizado.setPrimer_nombre(emp.getPrimer_nombre());
            empleadoActualizado.setSegundo_nombre(emp.getSegundo_nombre());
            empleadoActualizado.setPrimer_apellido(emp.getPrimer_apellido());
            empleadoActualizado.setSegundo_apellido(emp.getSegundo_apellido());
            empleadoActualizado.setFoto(emp.getFoto());
            empleadoActualizado.setFecha_nacimiento(emp.getFecha_nacimiento());
            empleadoActualizado.setTelefono(emp.getTelefono());
            empleadoActualizado.setDireccion(emp.getDireccion());
            empleadoActualizado.setUsuario(emp.getUsuario());
            empleadoActualizado.setPassword(emp.getPassword());
            empleadoActualizado.setFecha_ingreso(emp.getFecha_ingreso());
            empleadoActualizado.setCargo(emp.getCargo());
            empleadoActualizado.setSalario(emp.getSalario());
            empleadoActualizado.setEstado(empleado.get().getEstado());
            empleadoActualizado.setFechaCreacion(empleado.get().getFechaCreacion());
            empleadoActualizado.setFechaModificacion(LocalDateTime.now());
            empleadoDao.save(empleadoActualizado);
            return empleado;
        } else {
            throw new NoSuchElementException("No se encontró un empleado con el ID especificado");
        }
    }

    @Override
    public Empleado registrarEmpleado(Map<String, String> entidad) {
        try {
            if (validarInformacion(entidad)) {
                    return empleadoDao.save(getEmpleadoFromMap(entidad));
            } else {
                throw new NoSuchElementException("Datos invalidos " + HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        throw new NoSuchElementException(Constantes.ALGO_PASO_MAL + HttpStatus.BAD_REQUEST);
    }

    @Override
    public void deleteEmpleado(int id) {
        empleadoDao.deleteById(id);
    }

    public boolean validarInformacion(Map<String,String> entidad){
        if(entidad.containsKey("identificacion") && entidad.containsKey("primer_nombre") && entidad.containsKey("primer_apellido") &&
                entidad.containsKey("fecha_nacimiento") && entidad.containsKey("foto") && entidad.containsKey("telefono") &&
                entidad.containsKey("direccion") && entidad.containsKey("usuario") &&
                entidad.containsKey("password") && entidad.containsKey("fecha_ingreso") &&
                entidad.containsKey("cargo") && entidad.containsKey("salario")){
            return true;
        }
        return false;
    }

    public Empleado getEmpleadoFromMap(Map<String, String> entidad) {
        Empleado empleado = new Empleado();
        empleado.setIdentificacion(entidad.get("identificacion"));
        empleado.setPrimer_nombre(entidad.get("primer_nombre"));
        empleado.setSegundo_nombre(entidad.get("segundo_nombre"));
        empleado.setPrimer_apellido(entidad.get("primer_apellido"));
        empleado.setSegundo_apellido(entidad.get("segundo_apellido"));
        empleado.setFecha_nacimiento(entidad.get("fecha_nacimiento"));
        empleado.setTelefono(entidad.get("telefono"));
        empleado.setDireccion(entidad.get("direccion"));
        empleado.setUsuario(entidad.get("usuario"));
        empleado.setPassword(entidad.get("password"));
        empleado.setFecha_ingreso(entidad.get("fecha_ingreso"));
        empleado.setCargo(entidad.get("cargo"));
        empleado.setSalario(Float.parseFloat((entidad.get("salario"))));
        empleado.setFechaCreacion(LocalDateTime.now());
        empleado.setFoto(entidad.get("foto"));
        empleado.setEstado(true);
        return empleado;
    }


}
