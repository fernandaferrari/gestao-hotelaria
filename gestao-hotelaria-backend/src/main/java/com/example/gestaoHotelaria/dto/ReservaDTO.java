package com.example.gestaoHotelaria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.gestaoHotelaria.entity.Reserva;

public class ReservaDTO {

	private Long id;
	private Long hospede;
	private String cpf;
	private String nomeHospede;
	private String dataInicio;
	private String dataFim;
	private String estacionamento;
	private BigDecimal valor;
	private boolean checkin;
	private boolean checkout;
	private LocalDateTime dataHoraCheckin;
	private LocalDateTime dataHoraCheckout;

	public ReservaDTO() {
		super();
	}
	
	public ReservaDTO(Long id, Long hospede, String nomeHospede, String dataInicio, String dataFim,
			String estacionamento, BigDecimal valor, boolean checkin, boolean checkout, LocalDateTime dataHoraCheckin, LocalDateTime dataHoraCheckout) {
		super();
		this.id = id;
		this.hospede = hospede;
		this.nomeHospede = nomeHospede;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.estacionamento = estacionamento;
		this.valor = valor;
		this.checkin = checkin;
		this.checkout = checkout;
		this.dataHoraCheckin = dataHoraCheckin;
		this.dataHoraCheckout = dataHoraCheckout;
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
	
	public static ReservaDTO build(Reserva r) {
		return new ReservaDTO(r.getId(), r.getHospede().getId(), r.getHospede().getNome(), r.getDataInicioString(), r.getDataFimString(), r.getEstacionamento(), r.getValor(), r.isTemCheckin(), r.isTemCheckout(), r.getCheckin() != null ? r.getCheckin().getData() : null, r.getCheckout() != null ? r.getCheckout().getData() : null);
	}

	public String getNomeHospede() {
		return nomeHospede;
	}

	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}

	public boolean isCheckin() {
		return checkin;
	}

	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}

	public boolean isCheckout() {
		return checkout;
	}

	public void setCheckout(boolean checkout) {
		this.checkout = checkout;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataHoraCheckin() {
		return dataHoraCheckin;
	}

	public void setDataHoraCheckin(LocalDateTime dataHoraCheckin) {
		this.dataHoraCheckin = dataHoraCheckin;
	}

	public LocalDateTime getDataHoraCheckout() {
		return dataHoraCheckout;
	}

	public void setDataHoraCheckout(LocalDateTime dataHoraCheckout) {
		this.dataHoraCheckout = dataHoraCheckout;
	}
	
}
