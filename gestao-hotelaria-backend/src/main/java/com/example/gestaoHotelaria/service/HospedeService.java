package com.example.gestaoHotelaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.gestaoHotelaria.dto.HospedeDTO;
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

	//Método que retorna uma lista de hospedes que possuem reserva sem checkout
	public List<HospedeDTO> getHospedesSemCheckout() {
		return this.repository.getHospedesSemCheckout();
	}

}
