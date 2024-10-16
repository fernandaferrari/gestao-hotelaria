package com.example.gestaoHotelaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.entity.Reserva;
import com.example.gestaoHotelaria.entity.ReservaCheckin;
import com.example.gestaoHotelaria.repository.ReservaCheckinRepository;
import com.example.gestaoHotelaria.utils.DateUtils;

@Service
public class ReservaCheckinService {
	
	@Autowired ReservaCheckinRepository repository;
	@Autowired ReservaService reservaService;

	public void save(CheckDTO checkDTO) throws Exception {
		Optional<Reserva> reserva = this.reservaService.findById(checkDTO.getIdReserva());
		
		if(!reserva.isPresent()) {
			throw new Exception("Reserva não encontrada!");
		}
		
		ReservaCheckin checkin = new ReservaCheckin();
		checkin.setReserva(reserva.get());
		checkin.setData(DateUtils.getConverteStringToDate(checkDTO.getData()));
		this.repository.save(checkin);
	}
	
}
