package com.gabrielhermont.exercicio5tinnova.services;

import java.util.List;



import com.gabrielhermont.exercicio5tinnova.entities.Veiculo;

public interface VeiculoService {

	public List<Veiculo> findAll();
	public Veiculo findById(Integer id);
	public Veiculo save(Veiculo veiculo);
	public Veiculo update(Veiculo veiculo, Integer id);
	/*public List<Veiculo> findByMarcaAnoCor(String marca, Integer ano, String cor);*/
	public void deleteById(Integer id);
	
	
	
}
