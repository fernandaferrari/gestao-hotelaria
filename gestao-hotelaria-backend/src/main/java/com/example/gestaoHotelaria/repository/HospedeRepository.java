package com.example.gestaoHotelaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gestaoHotelaria.entity.Hospede;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long>{

	@Query("SELECT h FROM Hospede h WHERE exists(Select 1 from Reserva rv where rv.hospede.id = h.id and rv.checkout is null)")
	List<Hospede> getHospedesSemCheckout();

}
