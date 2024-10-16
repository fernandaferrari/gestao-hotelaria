package com.example.gestaoHotelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gestaoHotelaria.entity.ReservaCheckout;

@Repository
public interface ReservaCheckoutRepository extends JpaRepository<ReservaCheckout, Long>{

}
