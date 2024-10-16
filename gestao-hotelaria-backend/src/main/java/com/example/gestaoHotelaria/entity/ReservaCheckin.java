package com.example.gestaoHotelaria.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva_checkin")
public class ReservaCheckin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime data;
	@OneToOne(mappedBy = "checkin")
	private Reserva reserva;
	
	public ReservaCheckin() {
		super();
	}
	
	public ReservaCheckin(Long id, LocalDateTime data, Reserva reserva) {
		super();
		this.id = id;
		this.data = data;
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
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
}
