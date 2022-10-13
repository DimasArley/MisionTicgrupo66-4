
package com.example.demo.web;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Empleado;
import com.example.demo.domain.MateriaPrima;
import com.example.demo.domain.OrdenTrabajo;
import com.example.demo.domain.OrdenTrabajoXMateriaPrima;
import com.example.demo.servicio.ClienteService;
import com.example.demo.servicio.EmpleadoService;
import com.example.demo.servicio.MateriaPrimaService;
import com.example.demo.servicio.OrdenTrabajoService;
import com.example.demo.servicio.OrdenTrabajoXMatPriService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j // anotacion para enviar informacion al log
public class ControladorInicio {
    
    @Autowired
    private EmpleadoService empleadoService;
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private MateriaPrimaService materiaPrimaService;
    
    @Autowired
    private OrdenTrabajoService ordenTrabajoService;
    
    @Autowired 
    private OrdenTrabajoXMatPriService ordenTrabajoXMatPriService;
    
    @InitBinder
	public void init(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
    
    //SECCION EMPLEADO
    
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        var allEmpleado = empleadoService.listEmpleados();
        log.info("ingreso a la pagina inicio");
        log.info("usuario que hizo login: " + user);//para capturar el usuario que hizo login por consola
        model.addAttribute("AllEmpleado", allEmpleado);
        
        return "index";
    }
    
    @GetMapping("/agregarEmp")
    public String agregarEmpleado(Empleado empleado){
        log.info("ingreso a modificar");
        return "modificar";
    }
    
    @PostMapping("/guardarEmp")
    public String guardar(@Valid Empleado empleado, Errors errores, RedirectAttributes atributes){// @Valid le estamos indicando que este objeto de tipo persona sera validado
        if(errores.hasErrors()){//preguntamos que si tiene algun tipo de error nos redireccione a la pagina deseada
            return "modificar";
        }
        empleado.setNombre(empleado.getNombre().toUpperCase());
        empleado.setApellido(empleado.getApellido().toUpperCase());
        empleado.setCargo(empleado.getCargo().toUpperCase());
        empleado.setCategoria(empleado.getCategoria().toUpperCase());
        empleado.setDescripcionEmpleado(empleado.getDescripcionEmpleado().toUpperCase());
        empleado.setEmail(empleado.getEmail().toLowerCase());
        empleado.setTipoIdentificacion(empleado.getTipoIdentificacion().toUpperCase());
        empleadoService.saveEmp(empleado);
        atributes.addFlashAttribute("success", "El Empleado fue creado con éxito!");
        return "redirect:/";
    }
    
    @GetMapping("/editarEmp/{idEmpleado}")
    public String editar(Empleado empleado, Model model){
        empleado = empleadoService.findEmpleado(empleado);
        model.addAttribute("empleado", empleado);
        return "modificar";
    }
    
    @GetMapping("/eliminarEmp{idEmpleado}")
    public String eliminar(Empleado empleado, RedirectAttributes atributes){
        empleadoService.deleteEmp(empleado);
        atributes.addFlashAttribute("warning", "Empleado eliminado con éxito!");
        return "redirect:/";
    }
    
    //SECCION CLIENTES
    
    @GetMapping("/listaCli")
    public String inicioClientes(Model model, @AuthenticationPrincipal User user){
        var allClientes = clienteService.listClientes();
        log.info("ingreso a la pagina inicio clientes");
        model.addAttribute("AllClientes", allClientes);
        return "clientes";
    }
    
    @GetMapping("/agregarCli")
    public String agregarCliente(Cliente cliente){
        return "Clientes";
    }
    
    @PostMapping("/guardarCli")
    public String guardarCliente(@Valid Cliente cliente, Errors errores, RedirectAttributes atributes){
        if(errores.hasErrors()){
            return "redirect:/listaCli";
        }
        cliente.setNombre(cliente.getNombre().toUpperCase());
        cliente.setApellido(cliente.getApellido().toUpperCase());
        cliente.setCiudad(cliente.getCiudad().toUpperCase());
        cliente.setDepartamento(cliente.getDepartamento().toUpperCase());
        cliente.setDescripcion(cliente.getDescripcion().toUpperCase());
        cliente.setOrganizacion(cliente.getOrganizacion().toUpperCase());
        cliente.setTipoIdentificacion(cliente.getTipoIdentificacion().toUpperCase());
        clienteService.saveCliente(cliente);
        atributes.addFlashAttribute("success", "El cliente fue creado con éxito!");
        log.info("ingreso a la pagina inicio clientes2");
        return "redirect:/listaCli";
    }
    
    @GetMapping("/editarCli/{idCliente}")
    public String editarCliente(Cliente cliente, Model model){
        cliente = clienteService.findCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCli";
    }
    
    @GetMapping("/eliminarCli{idCliente}")
    public String eliminarCliente(Cliente cliente, RedirectAttributes atributes){
        clienteService.deleteCliente(cliente);
        atributes.addFlashAttribute("warning", "Cliente eliminado con éxito!");
        return "redirect:/listaCli";
    }
    
    // SECCION MATERIA PRIMA
    
    @GetMapping("/listaMatPri")
    public String inicioMateriaPrima(Model model, @AuthenticationPrincipal MateriaPrima materiaPrima){
        var allMateriaPrima = materiaPrimaService.listMateriaPrima();
        log.info("ingreso a la pagina inicio materia prima");
        model.addAttribute("allMateriaPrima", allMateriaPrima);
        return "materiaPrima";
    }
    
    @GetMapping("/agregarMatPri")
    public String agregarMateriaPrima(MateriaPrima materiaPrima){
        return "materiaPrima";
    }
    
    @PostMapping("/guardarMatPri")
    public String guardarMateriaPrima(@Valid MateriaPrima materiaPrima, Errors errores, RedirectAttributes atributes){
        log.info("ingreso a la pagina inicio clientes1" + errores);
        if(errores.hasErrors()){
            return "redirect:/listaMatPri";
        }
        materiaPrima.setNombre(materiaPrima.getNombre().toUpperCase());
        materiaPrima.setUnidadMedida(materiaPrima.getUnidadMedida().toUpperCase());
        materiaPrimaService.saveMateriaPrima(materiaPrima);
        atributes.addFlashAttribute("success", "Materia Prima creada con éxito!");
        return "redirect:/listaMatPri";
    }
    
    @GetMapping("/editarMatPri/{idMateriaPrima}") 
    public String editarMateriaPrima(MateriaPrima materiaPrima, Model model){
        materiaPrima = materiaPrimaService.findMateriaPrima(materiaPrima);
        model.addAttribute("materiaPrima", materiaPrima);
        return "modificarMatPri";
    }
    
    @GetMapping("/eliminarMatPri{idMateriaPrima}")
    public String eliminarMateriaPrima(MateriaPrima materiaPrima, RedirectAttributes atributes){
        materiaPrimaService.deleteMateriaPrima(materiaPrima);
        atributes.addFlashAttribute("warning", "Materia Prima eliminada con éxito!");
        return "redirect:/listaMatPri";
    }
    
    // ORDENES DE TRABAJO
    
    @GetMapping("/listaOrdTra")
    public String inicioOrdenTrabajo(Model model, @AuthenticationPrincipal OrdenTrabajo ordenTrabajo){
        var allOrdenTrabajo = ordenTrabajoService.listOrdenTrabajo();
        log.info("ingreso a la pagina inicio orden trabajo");
        model.addAttribute("allOrdenTrabajo", allOrdenTrabajo);
        return "ordenTrabajo";
    }
    
    @GetMapping("/agregarOrdTra")
    public String agregarOrdenTrabajo(OrdenTrabajo ordenTrabajo){
        return "ordenTrabajo";
    }
    
    @PostMapping("/guardarOrdTra")
    public String guardarOrdenTrabajo(@ModelAttribute("ordenTrabajo") OrdenTrabajo ordenTrabajo, Errors errores, Model model, RedirectAttributes atributes){
        log.info("ingreso a guardar orden trabajo" + errores);
        if(errores.hasErrors()){
            return "redirect:/listaOrdTra";
        }
        ordenTrabajo.setDescripcion(ordenTrabajo.getDescripcion().toUpperCase());
        ordenTrabajoService.saveOrdenTrabajo(ordenTrabajo);
        ordenTrabajoXMatPriService.guardarOrdTraXMatPri(ordenTrabajo.getMateriaPrimaFk(), ordenTrabajo.getIdOrdenTrabajo());
        atributes.addFlashAttribute("success", "Orden de Trabajo creada con éxito!");
        return "redirect:/listaOrdTra";
    }
    
    @GetMapping("/editarOrdTra/{idOrdenTrabajo}") 
    public String editarOrdenTrabajo(OrdenTrabajo ordenTrabajo, Model model){
        ordenTrabajo = ordenTrabajoService.findOrdenTrabajo(ordenTrabajo);
        model.addAttribute("ordenTrabajo", ordenTrabajo);
        return "modificarOrdenTrabajo";
    }
    
    @GetMapping("/ver/{clienteFk}") 
    public String verClienteMateriaPrima(@PathVariable("clienteFk") OrdenTrabajo clienteFk, Model model){
        Cliente cliente = clienteService.findById(clienteFk.getClienteFk());
        model.addAttribute("cliente", cliente);
        String nombre = cliente.getNombre();
        System.out.println("cliente: " + nombre);
        return "verCliente";
    }
    
    @GetMapping("/eliminarOrdTra{idOrdenTrabajo}")
    public String eliminarOrdenTrabajo(OrdenTrabajo ordenTrabajo, RedirectAttributes atributes){
        ordenTrabajoService.deleteFromOrdenTrabajoFk(ordenTrabajo.getIdOrdenTrabajo());
        ordenTrabajoService.deleteOrdenTrabajo(ordenTrabajo);
        atributes.addFlashAttribute("warning", "Orden de Trabajo eliminada con éxito!");
        System.out.println("se elimino con exito");
        return "redirect:/listaOrdTra";
    }
    
    @GetMapping("/prepararOrdenTrabajo")
    public String listMatpri(Model model){
        log.info("ingreso a lista materia prima");
        OrdenTrabajo ordenTrabajo = new OrdenTrabajo();
        
        List<MateriaPrima> listMatPrima = materiaPrimaService.listMateriaPrima();
        List<Cliente> lstClientes = clienteService.listClientes();
        
        model.addAttribute("ordenTrabajo", ordenTrabajo);
        model.addAttribute("listaMatPri", listMatPrima);
        model.addAttribute("lstClientes", lstClientes);
        
        System.out.println("lista: " + listMatPrima);
        return "agregarOrdenTrabajook";
        
        
    }
    
    // ORDEN TRABAJO X MATERIA PRIMA
    
    @GetMapping("/listaOrdTraXMatPri")
    public String inicioOrdTraXMatPri(Model model, @AuthenticationPrincipal OrdenTrabajoXMateriaPrima ordenTrabajoXMatPri){
        var allOrdenTrabajoXMatPri = ordenTrabajoXMatPriService.findOrdTraXMatPri(ordenTrabajoXMatPri);
        log.info("ingreso a la pagina inicio orden trabajo x mat pri");
        model.addAttribute("allOrdenTrabajoXMatPri", allOrdenTrabajoXMatPri);
        
        return "ordenTrabajo";
    }
    
    @GetMapping("/agregarOrdTraXMatPri")
    public String agregarOrdenTrabajoXMatPri(OrdenTrabajoXMateriaPrima ordenTrabajoXMatPri){
        return "ordenTrabajoXMatPri";
    }
    
    @PostMapping("/guardarOrdTraXMatPri")
    public String guardarOrdenTrabajoXMatPri(@Valid OrdenTrabajoXMateriaPrima ordenTrabajoXMatPri, Errors errores){
        log.info("ingreso a guardar orden trabajo x materia prima" + errores);
        if(errores.hasErrors()){
            return "redirect:/listaOrdtraXMatPri";
        }
        ordenTrabajoXMatPriService.saveOrdTraXMatPri(ordenTrabajoXMatPri);
        return "redirect:/listaOrdtraXMatPri";
    }
    
    @GetMapping("/editarOrdTraXMatPri/{idOrdenTrabajoXMatPri}") 
    public String editarOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordenTrabajoXMatPri, Model model){
        ordenTrabajoXMatPri = ordenTrabajoXMatPriService.findOrdTraXMatPri(ordenTrabajoXMatPri);
        model.addAttribute("ordenTrabajoXMatPri", ordenTrabajoXMatPri);
        return "modificarOrdTraXMatPri";
    }
    
    @GetMapping("/eliminarOrdTraXMatPri{idOrdenTrabajoXMatPri}")
    public String eliminarOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordenTrabajoXMatPri){
        
        ordenTrabajoXMatPriService.deleteOrdTraXMatPri(ordenTrabajoXMatPri);
        return "redirect:/listaOrdTraXMatPri";
    }
       
     
}
