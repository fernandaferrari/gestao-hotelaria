package com.example.gestaoHotelaria.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.dto.DetalhePagamentoDTO;
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
		Optional<Reserva> reservaOpt = this.reservaService.findById(checkDTO.getIdReserva());
		
		if(!reservaOpt.isPresent()) {
			throw new Exception("Reserva não encontrada!");
		}
		
		Reserva reserva = reservaOpt.get();
		ReservaCheckout checkout = new ReservaCheckout();
		checkout.setReserva(reserva);
		checkout.setData(checkDTO.getData());
		checkout.setValorAdicional(checkDTO.getValor());
		this.repository.save(checkout);
		
		reserva.setCheckout(checkout);
		this.reservaService.save(reserva);
	}

	public DetalhePagamentoDTO getDetalhePagamento(Long reservaId, LocalDateTime dataHoraCheckout) throws Exception {
		Optional<Reserva> reservaOpt = this.reservaService.findById(reservaId);
		
		if(!reservaOpt.isPresent()) {
			throw new Exception("Reserva não encontrada!");
		}
		
		Reserva reserva = reservaOpt.get();
		BigDecimal valorTotal = BigDecimal.ZERO;
		BigDecimal valorAdicional = BigDecimal.ZERO;
		
		LocalDateTime dataFim = reserva.getDataFim();
		dataFim = dataFim.withHour(14).withMinute(0).withSecond(0).withNano(0);
		if(dataHoraCheckout.isAfter(dataFim)) {
			valorAdicional = DiariaEnum.valorAdicional(dataHoraCheckout);
		}
		
		valorTotal = reserva.getValor().add(valorAdicional);
		return new DetalhePagamentoDTO(reserva.getValorDiariaString(), reserva.getValorEstacionamentoString(), valorAdicional.toString(), valorTotal.toString());
		
	}
	
}
