package com.example.gestaoHotelaria.entity;

import java.time.LocalDateTime;

import com.example.gestaoHotelaria.dto.HospedeDTO;
import com.example.gestaoHotelaria.utils.DateUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospede")
public class Hospede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private LocalDateTime dataNascimento;
	
	public Hospede() {
		super();
	}
	
	public Hospede(Long id, String nome, String cpf, String telefone, LocalDateTime dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDateTime dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Hospede build(HospedeDTO dto) {
		return new Hospede(null, dto.getNome(), dto.getDocumento(), dto.getTelefone(), DateUtils.getConverteStringToDate(dto.getDataNascimento()));
	}
	
	
}
