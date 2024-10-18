package com.example.gestaoHotelaria.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.example.gestaoHotelaria.utils.DateUtils;
import com.example.gestaoHotelaria.utils.DiariaEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Hospede hospede;
	
	private LocalDateTime  dataInicio;
	private LocalDateTime  dataFim;
	private String estacionamento;
	private BigDecimal valor;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_checkin", referencedColumnName = "id")
    private ReservaCheckin checkin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_checkout", referencedColumnName = "id")
    private ReservaCheckout checkout;
    
	public Reserva() {
		super();
	}

	public Reserva(Long id, Hospede hospede, LocalDateTime dataInicio, LocalDateTime  dataFim, String estacionamento, BigDecimal valor) {
		super();
		this.id = id;
		this.hospede = hospede;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.estacionamento = estacionamento;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
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
	
	public ReservaCheckin getCheckin() {
		return checkin;
	}

	public void setCheckin(ReservaCheckin checkin) {
		this.checkin = checkin;
	}

	public ReservaCheckout getCheckout() {
		return checkout;
	}

	public void setCheckout(ReservaCheckout checkout) {
		this.checkout = checkout;
	}
	
	public boolean isTemCheckin() {
		return this.getCheckin() != null;
	}
	
	public boolean isTemCheckout() {
		return this.getCheckout() != null;
	}

	public String getDataFimString() {
		return DateUtils.getConverteDateToString(this.getDataFim());
	}

	public String getDataInicioString() {
		return DateUtils.getConverteDateToString(this.getDataInicio());
	}
	
	public boolean isEstacionamento() {
		return "Sim".equals(this.getEstacionamento());
	}

	public String getValorDiariaString() {
		//o ideal seria ter um campo de valor para cada um, desta maneira vou fazer uma gambi só pra exibição
		return this.isEstacionamento() ? this.getValor().divide(BigDecimal.TWO).toString() : this.getValor().toString();
	}

	public String getValorEstacionamentoString() {
		return this.isEstacionamento() ? this.getValor().divide(BigDecimal.TWO).toString() : "";
	}

}
