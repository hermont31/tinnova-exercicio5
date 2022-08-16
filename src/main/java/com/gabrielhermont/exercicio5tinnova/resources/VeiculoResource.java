package com.gabrielhermont.exercicio5tinnova.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabrielhermont.exercicio5tinnova.entities.Veiculo;
import com.gabrielhermont.exercicio5tinnova.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
	
    @Autowired
	VeiculoService service;
    
	/*@GetMapping
	public ResponseEntity<Veiculo> findAll(){
		return null;
	}
	*/
	@PostMapping
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo){
		Veiculo veiculoSave = service.save(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculoSave.getId())
				.toUri();
		return ResponseEntity.created(uri).body(veiculoSave);
	}
	
	
	
}
