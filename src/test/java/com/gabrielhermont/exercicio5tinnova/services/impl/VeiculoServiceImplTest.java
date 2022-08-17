package com.gabrielhermont.exercicio5tinnova.services.impl;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.TestConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.gabrielhermont.exercicio5tinnova.entities.Veiculo;



@RunWith(SpringRunner.class)
public class VeiculoServiceImplTest {
	
	@TestConfiguration
	static class VeiculoServiceImplTestConfiguration {
		
		@Bean
		public VeiculoServiceImpl veiculoServiceImpl(){
			
			return new VeiculoServiceImpl();
		}
	}
	
	@Autowired
	VeiculoServiceImpl service;

			 	
	
	@Test
	void testFindAll() {
		
		Veiculo veiculo = new Veiculo(null, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		List<Veiculo> veiculos = service.findAll();
		assertTrue(veiculos.size() > 0);;
	}

	@Test
	void testFindAllError() {

		Veiculo veiculo = new Veiculo(null, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		List<Veiculo> veiculos = service.findAll();
		assertTrue(veiculos.size() < 0);
	}

	@Test
	void testFindById() {

		Veiculo veiculo = new Veiculo(null, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		Veiculo veiculoTeste = service.findById(1);
		assertNotNull(veiculoTeste);

	}
	@Test
	void testFindByIdError() {

		Veiculo veiculo = new Veiculo(null, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		Veiculo veiculoTeste = service.findById(1);
		assertNull(veiculoTeste);

	}

	@Test
	void testSave() {

		Veiculo veiculo = new Veiculo(null, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		assertNotNull(veiculo.getId());
		assertNotNull(veiculo.getCreated());
	}
	
	@Test
	void testSaveError() {

		Veiculo veiculo = new Veiculo(null, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		assertNull(veiculo.getId());
		assertNull(veiculo.getCreated());
	}

	@Test
	void testUpdate() {

		Veiculo veiculo = new Veiculo(1, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.update(veiculo, 1);
		assertNotNull(veiculo.getId());
		assertNotNull(veiculo.getUpdated());
	}

	@Test
	void testUpdateError() {

		Veiculo veiculo = new Veiculo(1, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.update(veiculo, 1);
		assertNull(veiculo.getId());
		assertNull(veiculo.getUpdated());
	}

	@Test
	void testDeleteById() {

		Veiculo veiculo = new Veiculo(1, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		service.deleteById(1);
		assertNull(service.findById(1));

	}
	
	@Test
	void testDeleteByIdError() {

		Veiculo veiculo = new Veiculo(1, "gol", "Volks", 2000, "Desgastado", true, null, null, "azul");
		service.save(veiculo);
		service.deleteById(1);
		assertNotNull(service.findById(1));

	}

}
