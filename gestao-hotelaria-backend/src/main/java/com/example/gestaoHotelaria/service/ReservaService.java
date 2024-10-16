package com.example.gestaoHotelaria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.ReservaDTO;
import com.example.gestaoHotelaria.entity.Hospede;
import com.example.gestaoHotelaria.entity.Reserva;
import com.example.gestaoHotelaria.repository.HospedeRepository;
import com.example.gestaoHotelaria.repository.ReservaRepository;
import com.example.gestaoHotelaria.utils.DateUtils;

@Service
public class ReservaService {

	@Autowired ReservaRepository repository;
	@Autowired HospedeRepository hospedeRepository;

	//Método que retorna lista de reservas sem checkout
	public List<ReservaDTO> getReservasSemCheckout() {
		List<Reserva> reservas = this.repository.getReservasSemCheckout();
		return reservas.stream().map(r -> ReservaDTO.build(r)).collect(Collectors.toList());
	}

	//Método que retorna lista de reservas sem checkin
	public List<ReservaDTO> getReservasSemCheckin() {
		List<Reserva> reservas = this.repository.getReservasSemCheckin();
		return reservas.stream().map(r -> ReservaDTO.build(r)).collect(Collectors.toList());
	}

	public void save(ReservaDTO reservaDTO) throws Exception {
		Reserva novaReserva = new Reserva();
		Optional<Hospede> hospede = hospedeRepository.findById(reservaDTO.getId());
		
		if(!hospede.isPresent()) {
			throw new Exception("O hóspede não existe!");
		}
		novaReserva.setHospede(hospede.get());
		novaReserva.setDataInicio(DateUtils.getConverteStringToDate(reservaDTO.getDataInicio()));
		novaReserva.setDataFim(DateUtils.getConverteStringToDate(reservaDTO.getDataFim()));
		novaReserva.setValor(reservaDTO.getValor());
		novaReserva.setEstacionamento(reservaDTO.getEstacionamento());
		this.repository.save(novaReserva);
	}

	public Optional<Reserva> findById(Long idHospede) {
		return this.repository.findById(idHospede);
	}
}
