package com.bolsadeideas.springboot.app.proyecto.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.bolsadeideas.springboot.app.proyecto.dto.FindByRol;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Medico;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Paciente;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServiceMedico;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServicePaciente;

@Controller
@SessionAttributes(names={"medico","paciente"})
public class AccesoController {

	@Autowired
	private IServicePaciente servicePaciente;
	
	@Autowired
	private IServiceMedico serviceMedico;
	
	@Autowired
	private FindByRol findByRol;

	
	@GetMapping("/acceso/ver")
	public String ver(@RequestParam Integer id,
			          @RequestParam String rol, 
			          Model model){

		if(rol.equals("paciente"))
			model.addAttribute("usuario", servicePaciente.findById(id).getBody());
		else 
			model.addAttribute("usuario", serviceMedico.findById(id).getBody());
			
	    
		model.addAttribute("rol",rol);
		model.addAttribute("titulo","Ver " + rol);
		return "UserInfo/ver";
	}
	
	
	
	@GetMapping("/acceso/{nombre}/eliminar")
	public String eliminar(@PathVariable String nombre, 
			               @RequestParam Integer id, 
			               @RequestParam String rol,
			             Model model
			               ) {
		
		if(rol.equals("paciente")) {
			servicePaciente.eliminar(id);
			model.addAttribute("listado", servicePaciente.findAll(Pageable.ofSize(5).first()).getBody());
	    }else {
			serviceMedico.eliminar(id);
			model.addAttribute("listado",serviceMedico.findAll(Pageable.ofSize(5).first()).getBody());
		}
		
		model.addAttribute("rol", rol);
		model.addAttribute("eliminado", true);
		model.addAttribute("nombre", nombre);
		return "acceso";
	}
	
	
	
	@GetMapping("/acceso/editar")
	public String getEditor(
			 @RequestParam Integer id, 
			 @RequestParam String rol,
             @RequestParam(required=false, defaultValue="false") String info,
			 Model model) {
		
		if(info.equals("true")) model.addAttribute("info",true);
		model.addAttribute("id",id);
		model.addAttribute("rol", rol);
		
		if(rol.equals("paciente"))
		    model.addAttribute("paciente", findByRol.RolPaciente(id));
		else
			model.addAttribute("medico", findByRol.RolMedico(id));
		
		return "UserInfo/editar";
	}
	
	
	
	@PostMapping("/act/paciente/{id}")
	public String actPaciente(@PathVariable Integer id, @ModelAttribute Paciente paciente,
			@RequestParam("file") MultipartFile foto,
			SessionStatus status,
			RedirectAttributes flash) {

		if(!foto.isEmpty()) {
			
			Path path = Paths.get("\\src\\main\\resources\\static\\img");
			String rootPath = path.toFile().getAbsolutePath();
			
			try {
				byte[] bytes = foto.getBytes(); 
				Path pathFoto = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(pathFoto, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			paciente.setFoto(foto.getOriginalFilename());
		}
		
		
	    servicePaciente.editar(paciente);
	    return httpAct(id,"paciente" ,status,flash);
	}

	@PostMapping("/act/medico/{id}")
	public String actMedico(@PathVariable Integer id, @ModelAttribute Medico medico, 
			MultipartFile foto,
			SessionStatus status,
			RedirectAttributes flash
			) {
		
	if(!foto.isEmpty()) {
			
			Path path = Paths.get("\\src\\main\\resources\\static\\img");
			String rootPath = path.toFile().getAbsolutePath();
			
			try {
				byte[] bytes = foto.getBytes(); 
				Path pathFoto = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(pathFoto, bytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
			medico.setFoto(foto.getOriginalFilename());
		}
		
		serviceMedico.editar(medico);
		return httpAct(id,"medico",status,flash);
	}
	
	private String httpAct(Integer id,String rol,  SessionStatus status, RedirectAttributes flash) {
		flash.addAttribute("id", id);
		flash.addAttribute("rol", rol);
		
		if(status.isComplete())
		status.setComplete();
		return "redirect:/acceso/editar/{id}/rol/{rol}?info=true";
	}

	
	@GetMapping("/acceso/agregar/{rol}")
	public String agregar(@PathVariable String rol, Model model) {
		
		if(rol.equals("paciente")) model.addAttribute("paciente",new Paciente());
		else model.addAttribute("medico",new Medico());
		
		model.addAttribute("rol", rol);
		
		return "UserInfo/agregar";
	}
	
	
	@PostMapping("/acceso/agregar/medico")
	public String agregarMedico(@ModelAttribute Medico medico,MultipartFile file, Model model) {
		return httpAgregar(medico,"medico",file,model);
	}
	
	@PostMapping("/acceso/agregar/paciente")
	public String agregarPaciente(@ModelAttribute Paciente paciente,MultipartFile file, Model model) {
		return httpAgregar(paciente,"paciente",file,model);
	}
	
	private String httpAgregar(Object object, String rol, MultipartFile file, Model model) {
		try {	
			if(rol.equals("paciente")) {
		        servicePaciente.agregar((Paciente) object);
		        model.addAttribute("paciente",new Paciente());
			}else {
				serviceMedico.agregar((Medico) object);
				model.addAttribute("medico",new Medico());
			}
		    model.addAttribute("info","Se agrego con exito el paciente");
		}catch(Exception e){
			model.addAttribute("danger",true);
		}finally {
			model.addAttribute("rol", rol);
		}
		return "UserInfo/agregar";
	}
	
	
	@GetMapping("/acceso/pag")
	public String medi(
			Pageable pageable,
			@RequestParam(required=false) String rol,
			@RequestParam(required=false) String nombre,  
			Model model){
		
		if(rol.equals("medico")) {
		    model.addAttribute("listado", serviceMedico.findAll(pageable).getBody());
		    model.addAttribute("rol", "medico");
		}else {
			model.addAttribute("listado", servicePaciente.findAll(pageable).getBody());
			model.addAttribute("rol", "paciente");
		}
		
		
        model.addAttribute("nombre", nombre);
        model.addAttribute("eliminado", false);
        
		return "acceso";
	}
	
}