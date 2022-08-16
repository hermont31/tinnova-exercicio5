package com.gabrielhermont.exercicio5tinnova.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String veiculo;
	private String marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	private LocalDateTime created;
	private LocalDateTime updated;
	
	public Veiculo(){
	}
	public Veiculo(String veiculo, String marca, Integer ano, String descricao, Boolean vendido, LocalDateTime created,
			LocalDateTime updated) {
		this.veiculo = veiculo;
		this.marca = marca;
		this.ano = ano;
		this.descricao = descricao;
		this.vendido = vendido;
		this.created = created;
		this.updated = updated;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getVendido() {
		return vendido;
	}
	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, created, descricao, marca, updated, veiculo, vendido);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(created, other.created)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(marca, other.marca)
				&& Objects.equals(updated, other.updated) && Objects.equals(veiculo, other.veiculo)
				&& Objects.equals(vendido, other.vendido);
	}
	
	
}
