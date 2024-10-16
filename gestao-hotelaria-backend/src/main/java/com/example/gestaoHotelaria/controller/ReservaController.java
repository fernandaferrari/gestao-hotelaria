package com.example.gestaoHotelaria.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.dto.ReservaDTO;
import com.example.gestaoHotelaria.service.ReservaService;


@RestController
@RequestMapping("/api/reservas")
public class ReservaController {
	
	@Autowired ReservaService reservaService;

	@PostMapping("/save")
	public String saveReserva(@RequestBody ReservaDTO reservaDTO) {
		try {
			this.reservaService.save(reservaDTO);
			return "Reserva cadastrada com sucesso!";
		}catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@PostMapping("/checkout/save")
	public String saveCheckoutHospede(@RequestBody CheckDTO checkDTO) {
		//TODO: process POST request
		
		return "Check-in efetuado com sucesso!";
	}
		
	@PostMapping("/checkin/save")
	public String saveCheckinHospede(@RequestBody String entity) {
		//TODO: process POST request
		
		return entity;
	}
	
	@GetMapping("/sem-checkout")
	public ResponseEntity<List<ReservaDTO>> getReservasSemCheckout() {
		try {
			List<ReservaDTO> reservas = this.reservaService.getReservasSemCheckout();
			return ResponseEntity.ok(reservas);
		}catch (Exception e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.emptyList());
		}
	}
	
	@GetMapping("/sem-checkin")
	public ResponseEntity<List<ReservaDTO>> getReservasSemCheckin() {
		try {
			List<ReservaDTO> reservas = this.reservaService.getReservasSemCheckin();
			return ResponseEntity.ok(reservas);
		}catch (Exception e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.emptyList());
		}
	}
}
