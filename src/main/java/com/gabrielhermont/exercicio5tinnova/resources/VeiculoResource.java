package com.gabrielhermont.exercicio5tinnova.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielhermont.exercicio5tinnova.entities.Veiculo;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {
    @GetMapping
	public ResponseEntity<Veiculo> findAll(){
		Veiculo v = new Veiculo("uno", "fiat", 1999, "usado", false, null, null);
		return ResponseEntity.ok().body(v);
	}
	
	
}
