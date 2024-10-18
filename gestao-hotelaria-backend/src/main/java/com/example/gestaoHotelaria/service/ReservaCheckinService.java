package com.example.gestaoHotelaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.entity.Reserva;
import com.example.gestaoHotelaria.entity.ReservaCheckin;
import com.example.gestaoHotelaria.repository.ReservaCheckinRepository;

@Service
public class ReservaCheckinService {
	
	@Autowired ReservaCheckinRepository repository;
	@Autowired ReservaService reservaService;

	public void save(CheckDTO checkDTO) throws Exception {
		Optional<Reserva> reservaOpt = this.reservaService.findById(checkDTO.getIdReserva());
		
		if(!reservaOpt.isPresent()) {
			throw new Exception("Reserva não encontrada!");
		}
		
		ReservaCheckin checkin = new ReservaCheckin();
		Reserva reserva = reservaOpt.get();
		checkin.setReserva(reserva);
		checkin.setData(checkDTO.getData());
		this.repository.save(checkin);
		reserva.setCheckin(checkin);
		this.reservaService.saveReserva(reserva);
	}
	
}
