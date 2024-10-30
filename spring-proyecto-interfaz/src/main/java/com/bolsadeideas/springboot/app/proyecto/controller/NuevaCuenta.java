package com.bolsadeideas.springboot.app.proyecto.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.proyecto.models.entities.Usuario;
import com.bolsadeideas.springboot.app.proyecto.models.service.IServiceUsuario;

@Controller
@RequestMapping("/newAccount")
@SessionAttributes(names="usuario")
public class NuevaCuenta {

	static final Logger logger = LoggerFactory.getLogger(NuevaCuenta.class);
	
	@Autowired
	private IServiceUsuario service;
		
	@GetMapping
	public String usuarioHtml(Model model) {
		
		model.addAttribute("titulo", "Create New Account");
		model.addAttribute("usuario", new Usuario());
		return "sesion/CrearUsuario";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute(value = "usuario") Usuario usuario, Model model, RedirectAttributes flash,
			SessionStatus status) {
		try {
			usuario.setRoles(service.findByRol(usuario.getRoles().getRol()));

			if (usuario != null) {
				service.save(usuario);
				flash.addFlashAttribute("primary", "La cuenta ha sido creada satisfactoriamente");
			}
			status.setComplete();
			return "redirect:/newAccount";
		} catch (Exception e) {
			status.setComplete();
			flash.addFlashAttribute("sucess", "Llene los campos correctamente, vuelva a intentarlo");
			return "redirect:/newAccount";
		}
	}
}