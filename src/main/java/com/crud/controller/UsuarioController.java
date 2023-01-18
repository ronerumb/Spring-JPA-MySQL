package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return  ResponseEntity.ok().body(usuarioRepositorio.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id){
		
		Usuario u = usuarioRepositorio.findById(id).get();
		return ResponseEntity.ok().body(u);
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		
		obj = usuarioRepositorio.save(obj);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

	

}
