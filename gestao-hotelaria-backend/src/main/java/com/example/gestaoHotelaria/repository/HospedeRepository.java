package com.example.gestaoHotelaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestaoHotelaria.entity.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long>{

	@Query("Select h from Hospede h where h.cpf = :cpf")
	Optional<Hospede> findByCPF(String cpf);

}
