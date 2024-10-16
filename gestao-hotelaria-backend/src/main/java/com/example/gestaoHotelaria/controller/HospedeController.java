package com.example.gestaoHotelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String saveHospede(@RequestBody HospedeDTO hospedeDTO) {
		try {
			this.hospedeService.save(hospedeDTO);
			return "Hóspede salvo com sucesso!";
		}catch (Exception e) {
			return "Erro ao salvar hóspede, tente novamente!";
		}
	}
	
}
