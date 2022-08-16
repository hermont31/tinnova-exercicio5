package com.gabrielhermont.exercicio5tinnova.resources;

import java.net.URI;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll(){
		List<Veiculo> veiculos = service.findAll();
		
		return ResponseEntity.ok(veiculos);
	}
	
	@GetMapping( "/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Integer id){
		Veiculo veiculo = service.findById(id);
		
		return ResponseEntity.ok(veiculo);
	}
		
	@PostMapping
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo){
		Veiculo veiculoSave = service.save(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculoSave.getId())
				.toUri();
		return ResponseEntity.created(uri).body(veiculoSave);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Veiculo> deleteById(@PathVariable Integer id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo,@PathVariable Integer id){
		Veiculo veiculoUpdate = service.update(veiculo,id);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculoUpdate.getId())
				.toUri();
		return ResponseEntity.created(uri).body(veiculoUpdate);
	}
	
	
}
