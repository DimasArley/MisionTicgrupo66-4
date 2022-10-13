package com.example.demo.servicio;

import com.example.demo.dao.IEmpleadoDAO;
import com.example.demo.domain.Empleado;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class EmpleadoServiceImp implements EmpleadoService{
    
    @Autowired
    private IEmpleadoDAO empleadoDao;

    @Override
    @Transactional(readOnly = true)// esta anotacion permite hacer un commit o un rollback sin embargo como solo se va hacer una
    //lectura se le indica que sera un readonly true.
    public List<Empleado> listEmpleados() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional// para este caso se deja solo la anotacion porque en este caso si se hara modificaciones en DB
    public void saveEmp(Empleado empleado) {
        empleado.setFechaCrea(new Date());
        empleado.setUserCrea("DIMAS LOPEZ");
        empleadoDao.save(empleado);
        log.info("ingreso a guardar empleado");
  
    }

    @Override
    @Transactional
    public void deleteEmp(Empleado empleado) {
        empleadoDao.delete(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findEmpleado(Empleado empleado) {
        
        return empleadoDao.findById(empleado.getIdEmpleado()).orElse(empleado);
    }
    
}
