package com.example.gestaoHotelaria.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestaoHotelaria.dto.HospedeDTO;
import com.example.gestaoHotelaria.service.HospedeService;

@RestController
@RequestMapping("/api/hospedes")
public class HospedeController {
	
	@Autowired HospedeService hospedeService;
	
	@PostMapping("/save")
	public  ResponseEntity<String> saveHospede(@RequestBody HospedeDTO hospedeDTO) {
		try {
			this.hospedeService.save(hospedeDTO);
			return ResponseEntity.ok("Hóspede salvo com sucesso!");
		}catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<List<HospedeDTO>> getHospedes() {
		try {
			List<HospedeDTO> hospedes = this.hospedeService.getHospedes();
			return ResponseEntity.ok(hospedes);
		}catch (Exception e) {
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(Collections.emptyList());
		}
	}
	
	
}
