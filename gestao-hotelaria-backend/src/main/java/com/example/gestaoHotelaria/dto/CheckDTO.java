package com.example.gestaoHotelaria.dto;

import java.math.BigDecimal;

public class CheckDTO {
	private Long idReserva;
	private String data;
	private BigDecimal valor;
	
	public CheckDTO() {
		super();
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
