package com.example.gestaoHotelaria.dto;

public class DetalhePagamentoDTO {

	private String valorDiaria;
	private String valorEstacionamento;
	private String valorAdicional;
	private String  total;
	
	public DetalhePagamentoDTO() {
		super();
	}

	public DetalhePagamentoDTO(String valorDiaria, String valorEstacionamento, String valorAdicional, String total) {
		super();
		this.valorDiaria = valorDiaria;
		this.valorEstacionamento = valorEstacionamento;
		this.valorAdicional = valorAdicional;
		this.total = total;
	}

	public String getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(String valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getValorEstacionamento() {
		return valorEstacionamento;
	}

	public void setValorEstacionamento(String valorEstaiconamento) {
		this.valorEstacionamento = valorEstaiconamento;
	}

	public String getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(String valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
