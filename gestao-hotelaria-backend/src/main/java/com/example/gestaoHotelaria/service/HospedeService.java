package com.example.gestaoHotelaria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.HospedeDTO;
import com.example.gestaoHotelaria.dto.ReservaDTO;
import com.example.gestaoHotelaria.entity.Hospede;
import com.example.gestaoHotelaria.repository.HospedeRepository;

@Service
public class HospedeService {

	@Autowired HospedeRepository repository;
	
	//Método para a persistência do hospede
	public void save(HospedeDTO hospedeDTO) {
		Hospede hospede = new Hospede().build(hospedeDTO);
		this.repository.save(hospede);
	}

	public List<HospedeDTO> getHospedes() {
		List<Hospede> hospedes =  this.repository.findAll();
		return hospedes.stream().map(h -> HospedeDTO.build(h)).collect(Collectors.toList());
	}
}
