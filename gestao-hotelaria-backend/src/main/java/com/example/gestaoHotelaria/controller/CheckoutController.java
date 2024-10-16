package com.example.gestaoHotelaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.service.ReservaCheckoutService;
import com.example.gestaoHotelaria.utils.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/reserva/checkout")
public class CheckoutController {
	
	@Autowired ReservaCheckoutService checkoutService;
	
	@PostMapping("/save")
	public String saveCheckout(@RequestBody CheckDTO checkDTO) {
		try {
			this.checkoutService.save(checkDTO);
			return "Check-out efetuado com sucesso!";
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	

	@GetMapping("/valor/{reservaId}/{dataHoraCheckout}")
	public ResponseEntity<BigDecimal> getValorAdicional(@PathVariable Long reservaId, @PathVariable String dataHoraCheckout) {
		try {
			LocalDateTime dataCheckout = DateUtils.getConverteStringToDate(dataHoraCheckout);
			BigDecimal taxaAdicional;
			taxaAdicional = this.checkoutService.getValorAdicional(reservaId, dataCheckout);
			return ResponseEntity.ok(taxaAdicional);
		} catch (Exception e) {
			e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		                .body(BigDecimal.ZERO);
		}
	}
	
}
