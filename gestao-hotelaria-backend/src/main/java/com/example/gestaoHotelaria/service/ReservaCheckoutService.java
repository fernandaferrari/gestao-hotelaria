package com.example.gestaoHotelaria.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.entity.Reserva;
import com.example.gestaoHotelaria.entity.ReservaCheckout;
import com.example.gestaoHotelaria.repository.ReservaCheckoutRepository;
import com.example.gestaoHotelaria.utils.DateUtils;
import com.example.gestaoHotelaria.utils.DiariaEnum;

@Service
public class ReservaCheckoutService {
	
	@Autowired ReservaCheckoutRepository repository;
	@Autowired ReservaService reservaService;

	public void save(CheckDTO checkDTO) throws Exception {
		Optional<Reserva> reserva = this.reservaService.findById(checkDTO.getIdReserva());
		
		if(!reserva.isPresent()) {
			throw new Exception("Reserva não encontrada!");
		}
		
		ReservaCheckout checkout = new ReservaCheckout();
		checkout.setReserva(reserva.get());
		checkout.setData(DateUtils.getConverteStringToDate(checkDTO.getData()));
		checkout.setValorAdicional(checkDTO.getValor());
		this.repository.save(checkout);
	}

	public BigDecimal getValorAdicional(Long reservaId, LocalDateTime dataCheckout) throws Exception {
		Optional<Reserva> reserva = this.reservaService.findById(reservaId);
		
		if(!reserva.isPresent()) {
			throw new Exception("Reserva não encontrada!");
		}		
		Reserva reservaEncontrada = reserva.get();
		if(dataCheckout.isAfter(reservaEncontrada.getDataFim())) {
			return DiariaEnum.valorAdicional(reservaEncontrada.getDataFim());
		}
		return BigDecimal.ZERO;
	}
	
}
