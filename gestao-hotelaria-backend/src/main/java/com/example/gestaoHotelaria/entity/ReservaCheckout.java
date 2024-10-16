package com.example.gestaoHotelaria.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reserva_checkout")
public class ReservaCheckout {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime data;
	private BigDecimal valorAdicional;
	@OneToOne(mappedBy = "checkout")
	private Reserva reserva;
	
	
	public ReservaCheckout() {
		super();
	}
	
	public ReservaCheckout(Long id, LocalDateTime data, BigDecimal valorAdicional, Reserva reserva) {
		super();
		this.id = id;
		this.data = data;
		this.valorAdicional = valorAdicional;
		this.reserva = reserva;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public BigDecimal getValorAdicional() {
		return valorAdicional;
	}
	public void setValorAdicional(BigDecimal valorAdicional) {
		this.valorAdicional = valorAdicional;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	
}
