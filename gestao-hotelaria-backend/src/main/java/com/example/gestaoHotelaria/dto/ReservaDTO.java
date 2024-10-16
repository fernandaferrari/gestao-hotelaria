package com.example.gestaoHotelaria.dto;

import java.math.BigDecimal;

import com.example.gestaoHotelaria.entity.Reserva;

public class ReservaDTO {

	private Long id;
	private Long hospede;
	private String dataInicio;
	private String dataFim;
	private String estacionamento;
	private BigDecimal valor;
	private String temCheckin;
	private String temCheckout;
	

	public ReservaDTO() {
		super();
	}
	
	public ReservaDTO(Long id, Long hospede, String dataInicio, String dataFim, String estacionamento, BigDecimal valor,
			String temCheckin, String temCheckout) {
		super();
		this.id = id;
		this.hospede = hospede;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.estacionamento = estacionamento;
		this.valor = valor;
		this.temCheckin = temCheckin;
		this.temCheckout = temCheckout;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getHospede() {
		return hospede;
	}
	public void setHospede(Long hospede) {
		this.hospede = hospede;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getEstacionamento() {
		return estacionamento;
	}
	public void setEstacionamento(String estacionamento) {
		this.estacionamento = estacionamento;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getTemCheckin() {
		return temCheckin;
	}
	public void setTemCheckin(String temCheckin) {
		this.temCheckin = temCheckin;
	}
	public String getTemCheckout() {
		return temCheckout;
	}
	public void setTemCheckout(String temCheckout) {
		this.temCheckout = temCheckout;
	}
	
	public static ReservaDTO build(Reserva r) {
		return new ReservaDTO(r.getId(), r.getHospede().getId(), r.getDataInicioString(), r.getDataFimString(), r.getEstacionamento(), r.getValor(), r.isTemCheckin(), r.isTemCheckout());
	}
	
}
