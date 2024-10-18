package com.example.gestaoHotelaria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CheckDTO {
	private Long idReserva;
	private LocalDateTime data;
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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
