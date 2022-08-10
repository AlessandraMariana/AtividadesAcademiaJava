package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entidades.Sapato;
import com.example.demo.repository.SapatoRepository;


@Controller
@RequestMapping("/")
public class SapatoController {
		
	@Autowired
	private SapatoRepository repo;
			
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/consulta")
	public String formConsulta(Model model) {
		Iterable<Sapato> sapatos = repo.findAll();
		model.addAttribute("sapatos", sapatos);
		return "consulta";
	}
	
	@GetMapping("/consulta/{idsapato}")
	public String formEditar(@PathVariable("idsapato") int id, Model model) {
		Sapato sapato  = (Sapato) repo.findById(id).get();
		model.addAttribute("sapato", sapato);
		return "edicao";
	}

	
	@PostMapping("/cadastro")
	public String salvar(Sapato sapato) {
		repo.save(sapato);
		return "redirect:/consulta";
	}
	
	@GetMapping("/delete/{idsapato}")
	public String delete(@PathVariable("idsapato") int id) {
		repo.deleteById(id);
		return "redirect:/consulta";
	}
}