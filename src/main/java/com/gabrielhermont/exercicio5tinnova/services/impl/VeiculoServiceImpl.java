package com.gabrielhermont.exercicio5tinnova.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielhermont.exercicio5tinnova.entities.Veiculo;
import com.gabrielhermont.exercicio5tinnova.repository.VeiculoRepository;
import com.gabrielhermont.exercicio5tinnova.services.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	@Autowired
	VeiculoRepository repository;

	@Override
	public List<Veiculo> findAll() {

		return repository.findAll();
	}

	@Override
	public Veiculo findById(Integer id) {
		if (repository.findById(id).isPresent())
			return repository.findById(id).get();
		else
			return null;
	}

	@Override
	public Veiculo save(Veiculo veiculo) {
		if (veiculo.getId() == null) {
			LocalDateTime dateCreate = LocalDateTime.now();
			veiculo.setCreated(dateCreate);			
			Veiculo veiculoSave = repository.save(veiculo);
			return veiculoSave;
		} else {
			return update(veiculo,veiculo.getId());
		}
	}

	@Override
	public Veiculo update(Veiculo veiculo, Integer id) {
		
		Veiculo veiculoUpdate = findById(id);
		LocalDateTime dateUpdate = LocalDateTime.now();
		veiculoUpdate.setUpdated(dateUpdate);			
		veiculoUpdate.setAno(veiculo.getAno());
		veiculoUpdate.setVeiculo(veiculo.getVeiculo());
		veiculoUpdate.setMarca(veiculo.getMarca());
		veiculoUpdate.setDescricao(veiculo.getDescricao());
		veiculoUpdate.setVendido(veiculo.getVendido());
		veiculoUpdate.setCreated(veiculo.getCreated());
		Veiculo veiculoUpdate2 = repository.save(veiculoUpdate);
				
		return veiculoUpdate2;

	}

	@Override
	public void deleteById(Integer id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			
		}
	}

	/*@Override
	public List<Veiculo> findByMarcaAnoCor(String marca, Integer ano, String cor) {
		List<Veiculo> veiculos = repository.getVeiculoByCorAnoMarca(cor, marca, ano);
		   
		return veiculos;
	}
*/
	
}
