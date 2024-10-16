package com.example.gestaoHotelaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestaoHotelaria.entity.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

	@Query("SELECT rv FROM Reserva rv WHERE rv.checkout is null ")
	List<Reserva> getReservasSemCheckout();
	
	@Query("SELECT rv FROM Reserva rv WHERE rv.checkin is null ")
	List<Reserva> getReservasSemCheckin();

}
