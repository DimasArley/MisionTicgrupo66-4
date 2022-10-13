package com.example.demo.servicio;

import com.example.demo.domain.Empleado;
import java.util.List;


public interface EmpleadoService {
    
    public List<Empleado> listEmpleados();
    
    public void saveEmp(Empleado empleado);
    
    public void deleteEmp(Empleado empleado);
    
    public Empleado findEmpleado(Empleado empleado);
    
}
