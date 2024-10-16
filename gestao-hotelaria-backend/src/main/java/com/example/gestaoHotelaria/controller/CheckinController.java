package com.example.gestaoHotelaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gestaoHotelaria.dto.CheckDTO;
import com.example.gestaoHotelaria.service.ReservaCheckinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reserva/checkin")
public class CheckinController {
	
	@Autowired ReservaCheckinService checkinService;
	
	@PostMapping("/save")
	public String saveCheckin(@RequestBody CheckDTO checkDTO) {
		try {
			this.checkinService.save(checkDTO);
			return "Check-in efetuado com sucesso!";
		}catch (Exception e) {
			return e.getMessage();
		}
	}
}
