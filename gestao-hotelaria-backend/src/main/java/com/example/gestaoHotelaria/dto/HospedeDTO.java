package com.example.gestaoHotelaria.dto;

import com.example.gestaoHotelaria.entity.Hospede;

public class HospedeDTO {

	private Long id;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	
	public HospedeDTO(Long id, String nome, String cpf, String dataNascimento, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	public HospedeDTO() {
		super();
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

	public void setCpf(String documento) {
		this.cpf = documento;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static HospedeDTO build(Hospede h) {
		return new HospedeDTO(h.getId(), h.getNome(), h.getCpf(), h.getDataNascimentoToString(), h.getTelefone());
	}
	
}
