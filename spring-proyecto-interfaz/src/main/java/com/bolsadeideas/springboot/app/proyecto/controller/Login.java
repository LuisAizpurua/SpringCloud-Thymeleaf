package com.bolsadeideas.springboot.app.proyecto.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.proyecto.dto.FindByRol;
import com.bolsadeideas.springboot.app.proyecto.models.entities.Usuario;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServiceUsuario;


@Controller
public class Login {
	
	@Autowired
	private IServiceUsuario serviceUsuario;

	@Autowired
	private FindByRol findByRol;

	private Map<String,Object> map;
	
	@GetMapping
	public String login(Model model){
		model.addAttribute("titulo", "Login");
		return "login";
	}

	@PostMapping("/acceso")
	public String AccesoLogin(@RequestParam(name = "password", defaultValue = "default") String password,
			@RequestParam(name = "rol", required = false) String rol,
			@RequestParam(name = "username", defaultValue = "default") String username, Model model,
			RedirectAttributes flash) {
		    
	    this.map = new HashMap<String,Object>();
	    
		try {
			Optional<Usuario> usuOpt = Optional.ofNullable(serviceUsuario.findByPassword(password));
			Usuario user = usuOpt.orElse(null);
			if (user != null && user.getRoles().getRol().equals(rol)) {

				map.put("rol", rol);
				map.put("nombre", user.getName());
				map.put("titulo", "Home " + rol);
				
				model.addAttribute("listado", findByRol.Roles(rol));
				model.addAttribute("eliminado", false);
				model.addAttribute("rol", rol);
				model.addAttribute("nombre", user.getName());
				model.addAttribute("titulo", "Home " + rol);
				return "acceso";
			}

			flash.addFlashAttribute("success", "Intentelo denuevo");
			return "redirect:/";

		} catch (Exception e) {
			flash.addFlashAttribute("success", "Password o username incorrecto");
			return "redirect:/";
		}
	}
	
	
	@GetMapping("/acceso")
	public String RetornarAcceso(Model model) {
		
		model.addAttribute("listado", findByRol.Roles(this.map.get("rol").toString()));
		model.addAttribute("eliminado", false);
		model.addAttribute("rol", this.map.get("rol").toString());
		model.addAttribute("nombre", this.map.get("nombre").toString());
		model.addAttribute("titulo", "Home " + this.map.get("rol").toString());
		
		return "acceso";
	}
	
}