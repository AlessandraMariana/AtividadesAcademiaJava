package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Sapato;

@Controller
@RequestMapping("/")
public class SapatoController {
	private List<Sapato> sapatos = new ArrayList<>();
	
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}
	
	@GetMapping ("/consulta")
	public String formConsulta(Model model) {
		model.addAttribute("sapatos", sapatos);
		return "consulta";
	}
	
	@PostMapping("/cadastro")
    public String salvar (Sapato sapato) {
		sapato.setId(sapatos.size()+1);
		sapatos.add(sapato);
		return "redirect:/consulta";
        
    }
	
	
	
	
	
	
	
}
