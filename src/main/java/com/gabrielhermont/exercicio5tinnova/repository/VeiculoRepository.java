package com.gabrielhermont.exercicio5tinnova.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.gabrielhermont.exercicio5tinnova.entities.Veiculo;
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer>{
	/*@Query("SELECT v FROM veiculo v WHERE v.marca = :marca AND v.cor = :cor AND v.ano= :ano") 
	List<Veiculo> getVeiculoByCorAnoMarca(@Param("cor") String cor, @Param("marca") String marca,
			@Param("ano") Integer ano);*/
	


}
