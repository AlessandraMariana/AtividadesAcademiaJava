package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Sapato;
import com.example.demo.repository.SapatoRepository;

@RestController
@RequestMapping("/")
public class SapatoController {
	@Autowired
	SapatoRepository repo;
	
	
	@GetMapping("/sapatos")
	public ResponseEntity<Iterable<Sapato>> getSapatos() {
		Iterable<Sapato> sapatos =repo.findAll();
		return ResponseEntity.status(HttpStatus.OK) .body(sapatos);
	}
	
	@GetMapping("/sapatos/{idsapato}")
	public ResponseEntity <Sapato> getSapatoById(@PathVariable("idsapato") Long idsapato) {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findById(idsapato).get());
	}
	
	@PostMapping("/sapatos")
	public ResponseEntity <Sapato> saveSapato(@RequestBody Sapato sapato) {
		Sapato sa = repo.save(sapato);
		return  ResponseEntity.status(HttpStatus.CREATED) .body(sa);
	}
	
	@DeleteMapping("/sapatos/{idsapato}")
	public ResponseEntity<Void> deleteSapato(@PathVariable("idsapato") Long idsapato) {
		repo.deleteById(idsapato);
		return ResponseEntity.noContent().build();
	}

	@PutMapping ("/sapatos/{idsapato}")
	public ResponseEntity <Sapato> alteraSapato(@PathVariable("idsapato") Long idsapato, @RequestBody Sapato sapato) {
		return ResponseEntity.ok(repo.save(sapato));
	}
}
