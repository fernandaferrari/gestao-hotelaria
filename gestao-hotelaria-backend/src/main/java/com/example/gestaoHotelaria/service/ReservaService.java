package com.example.gestaoHotelaria.service;

import java.time.LocalDateTime;
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
import com.example.gestaoHotelaria.utils.DiariaEnum;

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
		Optional<Hospede> hospede = hospedeRepository.findByCPF(reservaDTO.getCpf());
		
		if(!hospede.isPresent()) {
			throw new Exception("O hóspede não existe!");
		}
		LocalDateTime dataInicio = DateUtils.getConverteStringToDate(reservaDTO.getDataInicio());
		LocalDateTime dataFim = DateUtils.getConverteStringToDate(reservaDTO.getDataFim());
		
		if(dataInicio.isAfter(dataFim)) {
			throw new Exception("A data inicial não pode ser menor que a final");
		}
		
		novaReserva.setHospede(hospede.get());
		novaReserva.setDataInicio(dataInicio);
		novaReserva.setDataFim(dataFim.withHour(14).withMinute(0).withSecond(0).withNano(0));
		novaReserva.setEstacionamento(reservaDTO.getEstacionamento());
		novaReserva.setValor(DiariaEnum.calcular(dataInicio, dataFim, "Sim".equals(reservaDTO.getEstacionamento())));
		this.repository.save(novaReserva);
	}

	public Optional<Reserva> findById(Long idHospede) {
		return this.repository.findById(idHospede);
	}

	public List<ReservaDTO> getReservas() {
		List<Reserva> reservas = repository.findAll();
		return reservas.stream().map(r -> ReservaDTO.build(r)).collect(Collectors.toList());
	}

	public void saveReserva(Reserva reserva) {
		this.repository.save(reserva);
	}

	public void save(Reserva reserva) {
		repository.save(reserva);
	}
}
