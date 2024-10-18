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
	public ResponseEntity<String> saveReserva(@RequestBody ReservaDTO reservaDTO) {
		try {
			this.reservaService.save(reservaDTO);
			return ResponseEntity.ok("Reserva cadastrada com sucesso!");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
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
	
	@GetMapping("/")
	public ResponseEntity<List<ReservaDTO>> getReservas() {
		try {
			List<ReservaDTO> reservas = this.reservaService.getReservas();
			return ResponseEntity.ok(reservas);
		}catch (Exception e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.emptyList());
		}
	}
}
