package com.example.TvBackend.Service;


import com.example.TvBackend.Model.Empleado;
import com.example.TvBackend.Repository.IEmpleado;
import com.example.TvBackend.interfaceService.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;



@Service
public class empleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleado empleadoIfc;

    /*@Autowired
    private BCryptPasswordEncoder passwordEncoder;
*/
    @Override
    public List<Empleado> ConseguirEmpleados() {
        return (List<Empleado>) empleadoIfc.findAll();
    }

    @Override
    public Optional<Empleado> ConseguirUnoPorId(int id) {
        return empleadoIfc.findById(id);
    }

    @Override
    public int save(Empleado emp) {

        int res = 0;
        empleadoIfc.save(emp);
        if (!emp.equals(null)) {
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id) {
        empleadoIfc.deleteById(id);
    }





}
